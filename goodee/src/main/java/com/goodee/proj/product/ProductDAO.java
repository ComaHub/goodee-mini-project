package com.goodee.proj.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.proj.common.Paging;

import jakarta.validation.Valid;

@Mapper
public interface ProductDAO {

	int insert(ProductDTO productDTO) throws Exception;
	List<ProductDTO> list(Paging paging) throws Exception;
	Long totalCount(Paging paging) throws Exception;
	ProductDTO detail(ProductDTO productDTO) throws Exception;
	int update(@Valid ProductDTO productDTO) throws Exception;
}
