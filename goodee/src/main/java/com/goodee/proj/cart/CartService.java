package com.goodee.proj.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.proj.account.AccountDTO;
import com.goodee.proj.common.Paging;
import com.goodee.proj.product.ProductDTO;

@Service
public class CartService {
	@Autowired
	private CartDAO cartDAO;
	
	public List<ProductDTO> getCartList(AccountDTO accountDTO, Paging paging) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("accountNumber", accountDTO.getAccountNumber());
		map.put("paging", paging);
		return cartDAO.selectCartList(map);
	}

	public Long totalCount(AccountDTO accountDTO, Paging paging) {
		Map<String, Object> map = new HashMap<>();
		map.put("accountNumber", accountDTO.getAccountNumber());
		map.put("paging", paging);
		return cartDAO.totalCount(map);
	}

	public int addCart(Long accountNumber, Long productNumber) throws Exception {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setAccountNumber(accountNumber);
		cartDTO.setProductNumber(productNumber);
		
		return cartDAO.insertCart(cartDTO);
	}

	public int removeCart(Long accountNumber, Long productNumber) throws Exception {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setAccountNumber(accountNumber);
		cartDTO.setProductNumber(productNumber);
		
		return cartDAO.deleteCart(cartDTO);
	}
}
