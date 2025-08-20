package com.goodee.proj.cart;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartDAO {
	
	int insertCart(CartDTO cartDTO) throws Exception;

}
