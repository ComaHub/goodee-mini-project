package com.goodee.proj.KakaoPay;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/kakaoPay")
public class KakaoPayController {

	@Autowired
	KakaoPayService kakaoPayService;

	
	@PostMapping("/purchase")
	@ResponseBody
	public Map<String, Object> purchase(@RequestBody Map<String, Object> params, 
			HttpSession session) throws Exception {
		
		Map<String, Object> result = kakaoPayService.purchase(params, session);
		
		return result;
	}
	
	@GetMapping("/approve")
	public void approve(@RequestParam("pg_token") String pgToken, HttpSession session) throws Exception {
		Map<String, Object> res = kakaoPayService.approve(pgToken, session);
	}
	
}
