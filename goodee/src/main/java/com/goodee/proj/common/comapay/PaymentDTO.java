package com.goodee.proj.common.comapay;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentDTO {
	private Long paymentNumber;
	private String paymentType;
	private String paymentId;
	private String orderId;
}
