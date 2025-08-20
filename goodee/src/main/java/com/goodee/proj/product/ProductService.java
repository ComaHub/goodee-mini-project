package com.goodee.proj.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public int insert(ProductDTO productDTO) throws Exception {
		return productDAO.insert(productDTO);
	}
	
	public List<ProductDTO> list() throws Exception {
		return productDAO.list();
	}

	public ProductDTO detail(ProductDTO productDTO) throws Exception {
		return productDAO.detail(productDTO);
	}

	public int update(@Valid ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}

}
