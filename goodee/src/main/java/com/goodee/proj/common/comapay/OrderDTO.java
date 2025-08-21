package com.goodee.proj.common.comapay;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDTO {
	private Long orderNumber;
	private Long accountNumber;
	private Long productNumber;
	private Long paymentNumber;
	
	private List<Long> productNumbers;
}
