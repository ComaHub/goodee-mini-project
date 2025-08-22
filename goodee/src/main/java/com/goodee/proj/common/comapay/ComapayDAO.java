package com.goodee.proj.common.comapay;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.proj.product.ProductDTO;

@Mapper
public interface ComapayDAO {

	List<ProductDTO> selectCheckedProductList(List<Long> productNumbers) throws Exception;
	List<PaymentDTO> selectOrderList(Long accountNumber) throws Exception;
	int insertPayment(PaymentDTO paymentDTO) throws Exception;
	int insertOrder(OrderDTO orderDTO) throws Exception;
	int updatePayment(PaymentDTO paymentDTO) throws Exception;

}
