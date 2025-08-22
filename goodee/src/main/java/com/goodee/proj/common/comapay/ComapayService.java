package com.goodee.proj.common.comapay;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goodee.proj.product.ProductDTO;

@Service
@Transactional(rollbackFor = Exception.class)
public class ComapayService {
	@Autowired
	private ComapayDAO comapayDAO;

	public List<ProductDTO> getCheckedProductList(Long[] checkedProduct) throws Exception {
		List<Long> productNumbers = Arrays.asList(checkedProduct);
		
		return comapayDAO.selectCheckedProductList(productNumbers);
	}
	
	public PaymentDTO getOrder(String paymentId) throws Exception {
		return comapayDAO.selectOrderByPaymentId(paymentId);
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

	public int updateCancelResult(PaymentDTO paymentDTO) throws Exception {
		return comapayDAO.updatePayment(paymentDTO);
	}

	

	
}
