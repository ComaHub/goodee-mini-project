package com.goodee.proj.naverPay;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodee.proj.GoodeeApplication;
import com.goodee.proj.account.AccountDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/naverPay")
public class NaverPayController {

    private final GoodeeApplication goodeeApplication;

	@Autowired
	NaverPayService naverPayService;


    NaverPayController(GoodeeApplication goodeeApplication) {
        this.goodeeApplication = goodeeApplication;
    }
	
	@PostMapping("/purchase")
	@ResponseBody
	public Map<String, Object> purchase(@RequestBody Map<String, Object> params, 
			HttpSession session) throws Exception {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		
		Map<String, Object> result = naverPayService.purchase(params, accountDTO);
		
		return result;
	}
	
	@PostMapping("/purchaseCart")
	@ResponseBody
	public Map<String, Object> purchaseCart(@RequestBody Map<String, Object> params, 
			HttpSession session) throws Exception {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		Map<String, Object> result = naverPayService.purchaseCart(params, accountDTO);
		
		return result;
	}
	
	
	@GetMapping("/approve")
	public String approve(String resultCode, String paymentId) {
		
		System.out.println(paymentId);
		
		if (Objects.equals(resultCode, "Success")) {
			Map<String, Object> res = naverPayService.approve(paymentId);
			
			System.out.println(res);
			
			if (Objects.equals(res.get("code"), "Success")) {
				return "/naverPay/approve";
			}
		}
		return "redirect:/product/list";
	}
}
