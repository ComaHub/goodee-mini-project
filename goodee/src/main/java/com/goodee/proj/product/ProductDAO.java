package com.goodee.proj.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDAO {

	List<ProductDTO> selectProductList() throws Exception;
	ProductDTO detail(ProductDTO productDTO) throws Exception;
	int insertProduct(ProductDTO productDTO) throws Exception;
	int insertProductImage(ProductImageDTO productImageDTO) throws Exception;
	int update(ProductDTO productDTO) throws Exception;

}
