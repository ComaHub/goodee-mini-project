package com.goodee.proj.like;

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
@RequestMapping("/like/*")
public class LikeController {
	@Autowired
	private LikeService likeService;
	
	@GetMapping("list")
	public String getLikeList(HttpSession session, Model model) throws Exception {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		
		List<ProductDTO> productList = likeService.getLikeList(accountDTO);
		model.addAttribute("productList", productList);
		model.addAttribute("isLikeList", true);
		
		return "product/list";
	}
	
	@GetMapping("add")
	@ResponseBody
	public boolean getLikeAdd(Long productNumber, HttpSession session) throws Exception {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		
		int result = likeService.addLike(accountDTO.getAccountNumber(), productNumber);
		
		if (result > 0) return true;
		else return false;
	}
	
	@GetMapping("delete")
	public String getLikeDelete(Long productNumber, HttpSession session, Model model) throws Exception {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		
		int result = likeService.removeLike(accountDTO.getAccountNumber(), productNumber);
		
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
