package com.goodee.proj.naverPay;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class NaverPayService {

	@Value("${npay.client.id}")
	private String clientId;
	@Value("${npay.client.secret}")
	private String clientSecret;
	
	public void progress(Map<String, String> params) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Naver-Client-Id", clientId);
		headers.set("X-Naver-Client-Secret", clientSecret);
		
	}
}
