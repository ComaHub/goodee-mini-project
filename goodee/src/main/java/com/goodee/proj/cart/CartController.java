package com.goodee.proj.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodee.proj.account.AccountDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart/*")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@GetMapping("add")
	@ResponseBody
	public boolean getCartAdd(Long productNumber, HttpSession session) throws Exception {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		
		int result = cartService.addCart(accountDTO.getAccountNumber(), productNumber);
		
		if (result > 0) return true;
		else return false;
	}
}
