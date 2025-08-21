	package com.goodee.proj.naverPay;
	
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.goodee.proj.account.AccountDTO;
import com.goodee.proj.product.ProductDAO;
import com.goodee.proj.product.ProductDTO;
	
	@Service
	public class NaverPayService {

		@Value("${npay.partner.id}")
		private String partnerId;
		@Value("${npay.chain.id}")
		private String chainId;
		@Value("${npay.client.id}")
		private String clientId;
		@Value("${npay.client.secret}")
		private String clientSecret;
		
		@Autowired
		ProductDAO productDAO;
		
		public Map<String, Object> purchase(Map<String, Object> params, AccountDTO accountDTO) throws Exception {
			Long productNumber = Long.parseLong((String) params.get("productNumber"));
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNumber(productNumber);
			productDTO = productDAO.selectProduct(productDTO);
			
			
			Map<String, Object> create = (Map) params.get("create");
			Map<String, Object> open = (Map) params.get("open");
			
			create.put("clientId", clientId);
			create.put("chainId", chainId);
			
			open.put("merchantPayKey", accountDTO.getAccountNumber() + "-" + productDTO.getProductNumber());
			open.put("productName", productDTO.getName());
			long productCount = Long.parseLong((String) open.get("productCount"));
			long totalPayAmount = productDTO.getPrice() * productCount;
			open.put("totalPayAmount", totalPayAmount);
			open.put("taxScopeAmount", totalPayAmount);
//			open.put("returnUrl", "http://localhost/naverPay/approve");
			open.put("returnUrl", "https://developers.pay.naver.com/user/sand-box/payment");
			
			Map<String, Object> result = new HashMap<>();
			result.put("create", create);
			result.put("open", open);
			
			return result;
		}

		public Map<String, Object> approve(String paymentId) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			headers.set("X-Naver-Client-Id", clientId);
			headers.set("X-Naver-Client-Secret", clientSecret);
			headers.set("X-Naver-Chain-Id", chainId);
			// headers.set("Content-Type", "application/x-www-form-urlencoded");
			String uuid = UUID.randomUUID().toString();
			headers.set("X-NaverPay-Idempotency-Key", uuid);
			
			
			MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
			params.add("paymentId", paymentId);
			
			HttpEntity<?> request = new HttpEntity<>(params, headers);
			
			RestTemplate template = new RestTemplate();
			String url = "https://dev-pay.paygate.naver.com/" + partnerId + "/naverpay/payments/v2.2/apply/payment";
			
			Map<String, Object> res = template.postForObject(url, request, Map.class);
			
			return res;
		}
	}
