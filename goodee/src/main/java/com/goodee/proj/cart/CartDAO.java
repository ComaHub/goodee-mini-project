package com.goodee.proj.cart;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.proj.product.ProductDTO;

@Mapper
public interface CartDAO {
	
	List<ProductDTO> selectCartList(Map<String, Object> map) throws Exception;
	Long totalCount(Map<String, Object> map);
	int insertCart(CartDTO cartDTO) throws Exception;
	int deleteCart(CartDTO cartDTO) throws Exception;
	int deleteCartList(CartDTO cartDTO) throws Exception;

}
