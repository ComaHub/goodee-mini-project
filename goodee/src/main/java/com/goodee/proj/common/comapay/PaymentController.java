package com.goodee.proj.common.comapay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comapay/*")
public class PaymentController {

	@GetMapping("checkout")
	public void getPaymentCheckout() throws Exception {
		// Empty
	}
}
