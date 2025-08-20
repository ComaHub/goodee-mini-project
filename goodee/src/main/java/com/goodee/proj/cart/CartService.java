package com.goodee.proj.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.proj.account.AccountDTO;
import com.goodee.proj.product.ProductDTO;

@Service
public class CartService {
	@Autowired
	private CartDAO cartDAO;
	
	public List<ProductDTO> getCartList(AccountDTO accountDTO) throws Exception {
		return cartDAO.selectCartList(accountDTO.getAccountNumber());
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
