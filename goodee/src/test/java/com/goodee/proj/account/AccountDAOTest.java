package com.goodee.proj.account;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountDAOTest {

	@Autowired
	AccountDAO accountDAO;
	
	@Test
	void testInsert() throws Exception {
		
		for (int i = 0; i < 60; i++) {
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setId("user" + i);
			accountDTO.setPassword("user" + i);
			accountDTO.setName("name" + i);
			accountDTO.setEmail("email" + i + "@gmail.com");
			accountDTO.setPhone("010-1234-5678");
			accountDTO.setPostcode("123456");
			accountDTO.setAddress("가산디지털단지");
			accountDTO.setAddressDetail("KM타워");
			
			accountDAO.insert(accountDTO);
		}
		
	}

	@Test
	void testList() {
		fail("Not yet implemented");
	}

}
