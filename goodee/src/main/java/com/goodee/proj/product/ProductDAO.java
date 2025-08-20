package com.goodee.proj.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jakarta.validation.Valid;

@Mapper
public interface ProductDAO {

	int insert(ProductDTO productDTO) throws Exception;
	List<ProductDTO> list() throws Exception;
	ProductDTO detail(ProductDTO productDTO) throws Exception;
	int update(@Valid ProductDTO productDTO) throws Exception;

}
