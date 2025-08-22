package com.goodee.proj.kakaoPay;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.proj.account.AccountDTO;
import com.goodee.proj.common.comapay.OrderDTO;
import com.goodee.proj.common.comapay.PaymentDTO;
import com.goodee.proj.product.ProductDTO;

@Mapper
public interface KakaoPayDAO {

	List<ProductDTO> selectCheckedProductList(List<Long> productNumbers) throws Exception;
	List<PaymentDTO> selectOrderList(Long accountNumber) throws Exception;
	int insertPayment(PaymentDTO paymentDTO) throws Exception;
	int insertOrder(OrderDTO orderDTO) throws Exception;
	PaymentDTO selectPayment(PaymentDTO paymentDTO) throws Exception;
	int updatePayment(PaymentDTO paymentDTO) throws Exception;
	List<PaymentDTO> paymentList(AccountDTO accountDTO) throws Exception;

}
