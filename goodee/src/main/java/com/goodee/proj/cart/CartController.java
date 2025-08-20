package com.goodee.proj.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodee.proj.account.AccountDTO;
import com.goodee.proj.common.Paging;
import com.goodee.proj.product.ProductDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart/*")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@GetMapping("list")
	public String getCartList(HttpSession session, Model model, Paging paging) throws Exception {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		Long totalCount = cartService.totalCount(accountDTO, paging);
		paging.setTotalData(totalCount);
		
		List<ProductDTO> productList = cartService.getCartList(accountDTO, paging);
		model.addAttribute("productList", productList);
		model.addAttribute("isCartList", true);
		
		return "product/list";
	}
	
	@GetMapping("add")
	@ResponseBody
	public boolean getCartAdd(Long productNumber, HttpSession session) throws Exception {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		
		int result = cartService.addCart(accountDTO.getAccountNumber(), productNumber);
		
		if (result > 0) return true;
		else return false;
	}
	
	@GetMapping("delete")
	public String getCartDelete(Long productNumber, HttpSession session, Model model) throws Exception {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		
		int result = cartService.removeCart(accountDTO.getAccountNumber(), productNumber);
		
		String resultMsg = "상품 제거 중 오류가 발생했습니다.";
		String resultIcon = "warning";
		
		if (result > 0) {
			resultMsg = "상품이 제거되었습니다.";
			resultIcon = "success";
			
			String url = "list";
			model.addAttribute("url", url);
		}
		
		model.addAttribute("resultMsg", resultMsg);
		model.addAttribute("resultIcon", resultIcon);
		return "common/result";
	}
}
