package com.goodee.proj.common.comapay;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodee.proj.account.AccountDTO;
import com.goodee.proj.cart.CartService;
import com.goodee.proj.product.ProductDTO;
import com.goodee.proj.product.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/comapay/*")
public class ComapayController {
	@Autowired
	private ComapayService comapayService;
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	@Value("${toss.client.key}")
	private String clientKey;
	@Value("${toss.secret.key}")
	private String secretKey;

	@GetMapping("checkout")
	public void getComapayCheckout(Long productNumber, HttpSession session, Model model) throws Exception {
		Long[] checkedProduct = new Long[] {productNumber};
		
		List<ProductDTO> productList = comapayService.getCheckedProductList(checkedProduct);
		session.setAttribute("productList", productList);
		
		model.addAttribute("clientKey", clientKey);
		model.addAttribute("orderId", UUID.randomUUID().toString().substring(0, 8));
	}
	
	@PostMapping("checkout")
	public void postComapayCheckout(Long[] checkedProduct, HttpSession session, Model model) throws Exception {
		List<ProductDTO> productList = comapayService.getCheckedProductList(checkedProduct);
		session.setAttribute("productList", productList);
		
		model.addAttribute("clientKey", clientKey);
		model.addAttribute("orderId", UUID.randomUUID().toString().substring(0, 8));
	}
	
	@GetMapping("valid")
	@ResponseBody
	public String getComapayValid(String valid, HttpSession session) throws Exception {
		session.setAttribute("valid", valid);
		
		return valid;
	}
	
	@GetMapping("success")
	public String getComapaySuccess(String amount, String orderId, String paymentKey, HttpSession session) throws Exception {
		String valid = (String) session.getAttribute("valid");
		
		if (!amount.equals(valid)) {
			return "redirect:comapay/fail?code=410&message=결제%20금액이%20일치하지%20않습니다.&orderId=" + orderId;
		}
		
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setPaymentType("TOSS");
		paymentDTO.setPaymentId(paymentKey);
		paymentDTO.setOrderId(orderId);
		paymentDTO.setPaymentStatus("READY");
		
		comapayService.addOrderReady(paymentDTO);
		
		session.setAttribute("paymentDTO", paymentDTO);
		session.removeAttribute("valid");
		return "comapay/success";
	}
	
	@GetMapping("fail")
	public void getComapayFail(String code, String message, Model model) throws Exception {
		model.addAttribute("code", code);
		model.addAttribute("message", message);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("confirm")
	public ResponseEntity<JSONObject> postComapayConfirm(@RequestBody HashMap<String, Object> map) throws Exception {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("orderId", map.get("orderId"));
		jsonObj.put("amount", map.get("amount"));
		jsonObj.put("paymentKey", map.get("paymentKey"));
		
		String tossSecretKey = secretKey;
		Base64.Encoder encoder = Base64.getEncoder();
		byte[] encodedBytes = encoder.encode((tossSecretKey + ":").getBytes(StandardCharsets.UTF_8));
		String authorizations = "Basic " + new String(encodedBytes);
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
																		 .uri(URI.create("https://api.tosspayments.com/v1/payments/confirm"))
																		 .header("Authorization", authorizations)
																		 .header("Content-Type", "application/json")
																		 .POST(HttpRequest.BodyPublishers.ofString(jsonObj.toString(), StandardCharsets.UTF_8))
																		 .build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		int code = response.statusCode();
		JSONParser parser = new JSONParser();
		JSONObject result = (JSONObject) parser.parse(response.body());
		
		return ResponseEntity.status(code).body(result);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("result")
	public void postComapayResult(@RequestBody HashMap<String, Object> map, HttpSession session) throws Exception {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		List<ProductDTO> productList = (List<ProductDTO>) session.getAttribute("productList");
		
		List<Long> productNumbers = new ArrayList<>();
		for (ProductDTO productDTO : productList) {
			productNumbers.add(productDTO.getProductNumber());
		}
		
		PaymentDTO paymentDTO = (PaymentDTO) session.getAttribute("paymentDTO");
		
		if (paymentDTO.getPaymentId().equals(map.get("paymentKey"))) {
			paymentDTO.setPaymentStatus("COMPLETED");
		} else {
			// TODO 일치하지 않는 경우 결제 취소로 이어지는 로직 구현
		}
		
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setAccountNumber(accountDTO.getAccountNumber());
		orderDTO.setProductNumbers(productNumbers);
		
		comapayService.addOrderResult(paymentDTO, orderDTO);
		
		cartService.removeCartList(accountDTO.getAccountNumber(), productNumbers);
		
		productService.updateProductAmount(productNumbers);
		
		session.removeAttribute("productList");
		session.removeAttribute("paymentDTO");
	}
	
	@GetMapping("cancel")
	public void getComapayCancel(String paymentId, HttpSession session) throws Exception {
		PaymentDTO paymentDTO = comapayService.getOrder(paymentId);
		session.setAttribute("cancelOrder", paymentDTO);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("cancel")
	public String postComapayCancel(String cancelReason, HttpSession session, Model model) throws Exception {
		PaymentDTO paymentDTO = (PaymentDTO) session.getAttribute("cancelOrder");
		String uri = "https://api.tosspayments.com/v1/payments/" + paymentDTO.getPaymentId() + "/cancel";
		
		if (cancelReason == null || cancelReason.equals("")) {
			cancelReason = "없음";
		}
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("cancelReason", cancelReason);
		
		String tossSecretKey = secretKey;
		Base64.Encoder encoder = Base64.getEncoder();
		byte[] encodedBytes = encoder.encode((tossSecretKey + ":").getBytes(StandardCharsets.UTF_8));
		String authorizations = "Basic " + new String(encodedBytes);
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
																		 .uri(URI.create(uri))
																		 .header("Authorization", authorizations)
																		 .header("Content-Type", "application/json")
																		 .POST(HttpRequest.BodyPublishers.ofString(jsonObj.toString(), StandardCharsets.UTF_8))
																		 .build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		int code = response.statusCode();
		
		if (code != 200) {
			model.addAttribute("resultMsg", "결제 취소 중 오류가 발생했습니다.");
			model.addAttribute("resultIcon", "warning");
			model.addAttribute("url", "/comapay/cancel?paymentId=" + paymentDTO.getPaymentId());
			return "common/result";
		}
		
		return "redirect:canceled";
	}
	
	@GetMapping("canceled")
	public void getComapayCancelResult(HttpSession session, Model model) throws Exception {
		PaymentDTO paymentDTO = (PaymentDTO) session.getAttribute("cancelOrder");
		
		paymentDTO.setPaymentStatus("CANCELED");
		comapayService.updateCancelResult(paymentDTO);
		
		model.addAttribute("cancelOrder", paymentDTO);
		session.removeAttribute("cancelOrder");
	}
}
