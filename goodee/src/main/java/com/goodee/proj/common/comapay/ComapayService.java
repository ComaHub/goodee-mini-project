package com.goodee.proj.common.comapay;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.proj.product.ProductDTO;

@Service
public class ComapayService {
	@Autowired
	private ComapayDAO comapayDAO;

	public List<ProductDTO> getCheckedProductList(Long[] checkedProduct) throws Exception {
		List<Long> productNumbers = Arrays.asList(checkedProduct);
		
		return comapayDAO.selectCheckedProductList(productNumbers);
	}
	
	public int addOrderReady(PaymentDTO paymentDTO) throws Exception {
		return comapayDAO.insertPayment(paymentDTO);
	}

	public int addOrderResult(PaymentDTO paymentDTO, OrderDTO orderDTO) throws Exception {
		int result = comapayDAO.updatePayment(paymentDTO);
		
		orderDTO.setPaymentNumber(paymentDTO.getPaymentNumber());
		result = comapayDAO.insertOrder(orderDTO);
		
		return result;
	}

	public List<PaymentDTO> getOrderList(Long accountNumber) throws Exception {
		return comapayDAO.selectOrderList(accountNumber);
	}

	
}
