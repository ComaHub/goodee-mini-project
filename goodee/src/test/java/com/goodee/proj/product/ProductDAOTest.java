package com.goodee.proj.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductDAOTest {

	@Autowired
	ProductDAO productDAO;
	
	@Test
	void testList() throws Exception {
		
		for (int i = 20; i < 60; i++) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setName("name" + i);
			productDTO.setCategory("cat" + i);
			productDTO.setAmount(Long.valueOf(i * 10));
			productDTO.setPrice(Long.valueOf(i * 1000));
			
			productDAO.insert(productDTO);
		}
	}

}
