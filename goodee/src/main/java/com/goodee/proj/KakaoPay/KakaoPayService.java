package com.goodee.proj.KakaoPay;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.goodee.proj.account.AccountDTO;
import com.goodee.proj.common.comapay.ComapayDAO;
import com.goodee.proj.common.comapay.PaymentDTO;
import com.goodee.proj.product.ProductDAO;
import com.goodee.proj.product.ProductDTO;

import jakarta.servlet.http.HttpSession;

@Service
public class KakaoPayService {

	@Value("${kpay.client.id}")
	private String clientId;
	@Value("${kpay.client.secret}")
	private String clientSecret;
	
	@Autowired
	ProductDAO productDAO;
	@Autowired
	ComapayDAO comapayDAO;
	
	public Map<String, Object> purchase(Map<String, Object> params, HttpSession session) throws Exception {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "SECRET_KEY " + clientSecret);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Long productNumber = Long.parseLong((String) params.get("productNumber"));
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNumber(productNumber);
		productDTO = productDAO.selectProduct(productDTO);
		
		Map<String, Object> data = new HashMap<>();
		
		String orderId = UUID.randomUUID().toString();
		
		data.put("cid", clientId);
		data.put("partner_order_id", orderId);
		data.put("partner_user_id", "test");
		data.put("item_name", productDTO.getName());
		long quantity = 1;
		long total_amount = productDTO.getPrice() * quantity;
		data.put("quantity", quantity);
		data.put("total_amount", total_amount);
		data.put("tax_free_amount", 0);
		data.put("approval_url", "http://localhost/kakaoPay/approve");
		data.put("fail_url", "http://localhost/kakaoPay/fail");
		data.put("cancel_url", "http://localhost/kakaoPay/cancel");
		
		System.out.println(data);
		
		HttpEntity<Map> request = new HttpEntity<>(data, headers);
		
		RestTemplate template = new RestTemplate();
		String url = "https://open-api.kakaopay.com/online/v1/payment/ready";
		
		Map<String, Object> res = template.postForObject(url, request, Map.class);
		
		String tid = (String) res.get("tid");
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setPaymentType("Kakao");
		paymentDTO.setPaymentId(tid);
		paymentDTO.setOrderId(orderId);
		
		comapayDAO.insertPayment(paymentDTO);
		
		session.setAttribute("orderId", orderId);
		
		return res;
	}

	public Map<String, Object> approve(String pgToken, String orderId) {
		PaymentDTO paymentDTO = comapayDAO.get
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "SECRET_KEY " + clientSecret);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Map<String, Object> params = new HashMap<>();
		params.put("cid", clientId);
		params.put("tid", purchase.get("tid"));
		params.put("partner_order_id", purchase.get("partner_order_id"));
		params.put("partner_user_id", "test");
		params.put("pg_token", pgToken);
		
		HttpEntity<Map> request = new HttpEntity<>(params, headers);
		
		RestTemplate template = new RestTemplate();
		String url = "https://open-api.kakaopay.com/online/v1/payment/approve";
		
		Map<String, Object> res = template.postForObject(url, request, Map.class);
		
		return res;
	}
	
//	public Map<String, Object> purchaseCart(Map<String, Object> params, AccountDTO accountDTO) throws Exception {
//		
//		List<String> strList = (List) params.get("productNumberArr");
//		long[] productNumberArr = strList.stream().mapToLong(Long::parseLong).toArray();
//		
//		List<ProductDTO> list = productDAO.selectListByArr(productNumberArr);
//		
//		Map<String, Object> create = (Map) params.get("create");
//		Map<String, Object> open = (Map) params.get("open");
//		
//		create.put("clientId", clientId);
//		create.put("chainId", chainId);
//		
//		open.put("merchantPayKey", accountDTO.getAccountNumber() + "-" + list.get(0).getProductNumber());
//		open.put("productName", list.get(0).getName());
//		
//		long productCount = Long.parseLong((String) open.get("productCount"));
//		
//		long totalPayAmount = 0;
//		
//		for (ProductDTO p : list) {
//			totalPayAmount += p.getPrice();
//			System.out.println(totalPayAmount);
//		}
//			
//		open.put("totalPayAmount", totalPayAmount);
//		open.put("taxScopeAmount", totalPayAmount);
////		open.put("returnUrl", "http://localhost/naverPay/approve");
//		open.put("returnUrl", "https://developers.pay.naver.com/user/sand-box/payment");
//		
//		Map<String, Object> result = new HashMap<>();
//		result.put("create", create);
//		result.put("open", open);
//		
//		return result;
//	}
}
