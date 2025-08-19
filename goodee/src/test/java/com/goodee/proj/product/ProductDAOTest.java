package com.goodee.proj.product;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductDAOTest {

	@Autowired
	ProductDAO productDAO;
	
	@Test
	void testList() throws Exception {
		
		for (int i = 0; i < 10; i++) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setName("name" + i);
			productDTO.setCategory("cat" + i);
			productDTO.setPrice(Long.valueOf(i));
			
			productDAO.insert(productDTO);
		}
	}

}
