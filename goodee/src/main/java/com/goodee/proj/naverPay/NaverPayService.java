	package com.goodee.proj.naverPay;
	
	import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
	
	@Service
	public class NaverPayService {
	
		@Value("${npay.client.id}")
		private String clientId;
		@Value("${npay.client.secret}")
		private String clientSecret;
		
		public Map<String, Object> progress(Map<String, Object> params) {
			Map<String, Object> create = (Map<String, Object>) params.get("create");
			Map<String, Object> open = (Map<String, Object>) params.get("open");
			
			create.put("clientId", clientId);
			create.put("chainId", "test");
			
			Map<String, Object> result = new HashMap<>();
			result.put("create", create);
			result.put("open", open);
			
			return result;
		}
	}
