package com.goodee.proj.cart;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.proj.product.ProductDTO;

@Mapper
public interface CartDAO {
	
	List<ProductDTO> selectCartList(Long accountNumber) throws Exception;
	int insertCart(CartDTO cartDTO) throws Exception;
	int deleteCart(CartDTO cartDTO) throws Exception;

}
