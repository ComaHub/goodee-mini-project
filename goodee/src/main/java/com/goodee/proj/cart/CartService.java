package com.goodee.proj.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
	@Autowired
	private CartDAO cartDAO;

	public int addCart(Long accountNumber, Long productNumber) throws Exception {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setAccountNumber(accountNumber);
		cartDTO.setProductNumber(productNumber);
		
		return cartDAO.insertCart(cartDTO);
	}
}
