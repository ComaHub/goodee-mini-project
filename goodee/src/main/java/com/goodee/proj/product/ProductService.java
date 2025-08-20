package com.goodee.proj.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.proj.common.Paging;

import jakarta.validation.Valid;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public int insert(ProductDTO productDTO) throws Exception {
		return productDAO.insert(productDTO);
	}
	
	public List<ProductDTO> list(Paging paging) throws Exception {
		return productDAO.list(paging);
	}

	public Long totalCount(Paging paging) throws Exception {
		return productDAO.totalCount(paging);
	}

	public ProductDTO detail(ProductDTO productDTO) throws Exception {
		return productDAO.detail(productDTO);
	}

	public int update(@Valid ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}

}
