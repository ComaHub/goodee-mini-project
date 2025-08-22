package com.goodee.proj.kakaoPay;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.goodee.proj.account.AccountDTO;
import com.goodee.proj.common.comapay.PaymentDTO;

@SpringBootTest
class KakaoPayDAOTest {

	@Autowired
	KakaoPayDAO kakaoPayDAO;
	
	@Test
	void testPaymentList() throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountNumber(17L);
		List<PaymentDTO> list = kakaoPayDAO.paymentList(accountDTO);
		System.out.println(list);
	}

}
