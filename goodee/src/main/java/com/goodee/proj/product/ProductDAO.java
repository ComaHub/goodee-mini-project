package com.goodee.proj.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.proj.common.Paging;

@Mapper
public interface ProductDAO {

	int insert(ProductDTO productDTO) throws Exception;
	List<ProductDTO> list(Paging paging) throws Exception;
	Long totalCount(Paging paging) throws Exception;
	ProductDTO selectProduct(ProductDTO productDTO) throws Exception;
	List<ProductDTO> selectProductList(Paging paging) throws Exception;
	ProductImageDTO selectProductImage(Long productNumber) throws Exception;
	int insertProduct(ProductDTO productDTO) throws Exception;
	int insertProductImage(ProductImageDTO productImageDTO) throws Exception;
	int updateProduct(ProductDTO productDTO) throws Exception;
	int updateProductImage(ProductImageDTO productImageDTO) throws Exception;
	int updateProductAmount(List<Long> productNumbers) throws Exception;
	int deleteProduct(Long productNumber) throws Exception;
	int deleteProductImage(Long attachNumber) throws Exception;
	List<ProductDTO> selectListByArr(long[] productNumberArr) throws Exception;
}
