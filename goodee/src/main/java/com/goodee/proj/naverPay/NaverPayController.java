package com.goodee.proj.naverPay;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/naverPay")
public class NaverPayController {

	@PostMapping("/try")
	public void pay(Map<String, String> params) {
		
	}
}
