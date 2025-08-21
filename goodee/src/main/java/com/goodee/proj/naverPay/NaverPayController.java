package com.goodee.proj.naverPay;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/naverPay")
public class NaverPayController {

	@Autowired
	NaverPayService naverPayService;
	
	@PostMapping("/try")
	@ResponseBody
	public Map<String, Object> pay(Map<String, Object> params) {
		return naverPayService.progress(params);
	}
}
