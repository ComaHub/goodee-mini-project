package com.goodee.proj.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDAO {

	ProductDTO selectProduct(ProductDTO productDTO) throws Exception;
	List<ProductDTO> selectProductList() throws Exception;
	ProductImageDTO selectProductImage(Long productNumber) throws Exception;
	int insertProduct(ProductDTO productDTO) throws Exception;
	int insertProductImage(ProductImageDTO productImageDTO) throws Exception;
	int updateProduct(ProductDTO productDTO) throws Exception;
	int updateProductImage(ProductImageDTO productImageDTO) throws Exception;
	int deleteProduct(Long productNumber) throws Exception;
	int deleteProductImage(Long attachNumber) throws Exception;

}
