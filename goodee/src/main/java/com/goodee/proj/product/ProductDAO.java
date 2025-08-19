package com.goodee.proj.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDAO {

	int insert(ProductDTO productDTO) throws Exception;
	List<ProductDTO> list() throws Exception;

}
