package com.goodee.proj.kakaoPay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.goodee.proj.account.AccountDTO;
import com.goodee.proj.common.comapay.ComapayController;
import com.goodee.proj.common.comapay.OrderDTO;
import com.goodee.proj.common.comapay.PaymentDTO;
import com.goodee.proj.product.ProductDAO;
import com.goodee.proj.product.ProductDTO;

import jakarta.servlet.http.HttpSession;

@Service
public class KakaoPayService {

    private final ComapayController comapayController;

	@Value("${kpay.client.id}")
	private String clientId;
	@Value("${kpay.client.secret}")
	private String clientSecret;
	
	@Autowired
	ProductDAO productDAO;
	@Autowired
	KakaoPayDAO kakaoPayDAO;


    KakaoPayService(ComapayController comapayController) {
        this.comapayController = comapayController;
    }

	
	public Map<String, Object> purchase(Map<String, Object> params, HttpSession session) throws Exception {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "SECRET_KEY " + clientSecret);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		List<String> strList = (List) params.get("productNumberArr");
		long[] productNumberArr = strList.stream().mapToLong(Long::parseLong).toArray();
		
		List<ProductDTO> list = productDAO.selectListByArr(productNumberArr);
		
		Map<String, Object> data = new HashMap<>();
		
		String orderId = UUID.randomUUID().toString().substring(0, 9) + accountDTO.getId();
		
		data.put("cid", clientId);
		data.put("partner_order_id", orderId);
		data.put("partner_user_id", "test");
		data.put("item_name", list.get(0).getName());
		long quantity = list.size();
		
		long total_amount = 0;
		for (ProductDTO p : list) {
			total_amount += p.getPrice();
		}
		
		data.put("quantity", quantity);
		data.put("total_amount", total_amount);
		data.put("tax_free_amount", 0);
		data.put("approval_url", "http://localhost/kakaoPay/approve");
		data.put("fail_url", "http://localhost/kakaoPay/fail");
		data.put("cancel_url", "http://localhost/kakaoPay/cancel");
		
		HttpEntity<Map> request = new HttpEntity<>(data, headers);
		
		RestTemplate template = new RestTemplate();
		String url = "https://open-api.kakaopay.com/online/v1/payment/ready";
		
		Map<String, Object> res = template.postForObject(url, request, Map.class);
		
		String tid = (String) res.get("tid");
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setPaymentType("Kakao");
		paymentDTO.setPaymentId(tid);
		paymentDTO.setOrderId(orderId);
		
		session.setAttribute("paymentDTO", paymentDTO);
		
		
		List<Long> productNumberList = new ArrayList<>();
		for (ProductDTO p : list) {
			productNumberList.add(p.getProductNumber());
		}
		
		session.setAttribute("productNumberList", productNumberList);
		
		return res;
	}

	@Transactional(rollbackFor = Exception.class)
	public Map<String, Object> approve(String pgToken, HttpSession session) throws Exception {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		PaymentDTO paymentDTO = (PaymentDTO) session.getAttribute("paymentDTO");
		List<Long> productNumberList = (List) session.getAttribute("productNumberList");
		
		session.removeAttribute("paymentDTO");
		session.removeAttribute("productNumberList");
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "SECRET_KEY " + clientSecret);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Map<String, Object> params = new HashMap<>();
		params.put("cid", clientId);
		params.put("tid", paymentDTO.getPaymentId());
		params.put("partner_order_id", paymentDTO.getOrderId());
		params.put("partner_user_id", "test");
		params.put("pg_token", pgToken);
		
		HttpEntity<Map> request = new HttpEntity<>(params, headers);
		
		RestTemplate template = new RestTemplate();
		String url = "https://open-api.kakaopay.com/online/v1/payment/approve";
		
		Map<String, Object> res = template.postForObject(url, request, Map.class);
		
		if (res.get("error_code") != null) {
			System.out.println(res);
			return res;
		}
		paymentDTO.setPaymentStatus("COMPLETED");
		int result = kakaoPayDAO.insertPayment(paymentDTO);
		if (result != 1) throw new Exception();
		
		OrderDTO orderDTO = new OrderDTO();

		orderDTO.setAccountNumber(accountDTO.getAccountNumber());
		orderDTO.setProductNumbers(productNumberList);
		orderDTO.setPaymentNumber(paymentDTO.getPaymentNumber());
		result = kakaoPayDAO.insertOrder(orderDTO);
		if (result <= 0) throw new Exception();
		
		System.out.println(res);
		
		return res;
	}

	public List<Map<String, Object>> list(AccountDTO accountDTO) throws Exception {
		List<PaymentDTO> paymentList = kakaoPayDAO.paymentList(accountDTO);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "SECRET_KEY " + clientSecret);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		List<Map<String, Object>> resList = new ArrayList<>();
		
		for (PaymentDTO p : paymentList) {
			Map<String, String> data = new HashMap<>();
			data.put("cid", clientId);
			data.put("tid", p.getPaymentId());
			
			HttpEntity<Map> request = new HttpEntity<Map>(data, headers);
			
			RestTemplate template = new RestTemplate();
			String url = "https://open-api.kakaopay.com/online/v1/payment/order";
			
			Map<String, Object> res = template.postForObject(url, request, Map.class);
			
			resList.add(res);
		}
		
		return resList;
	}


	public void cancel(AccountDTO accountDTO) {
		
	}
}
