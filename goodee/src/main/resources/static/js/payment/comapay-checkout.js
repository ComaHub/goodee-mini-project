let totalPrice = 0;

document.querySelectorAll(".productPrice").forEach((price) => {
	totalPrice += parseInt(price.getAttribute("data-product-price"));
});

fetch("valid?valid=" + totalPrice, {
	method : "GET"
})
.then((data) => data.text())
.then((data) => {
	document.querySelector("#totalPrice").append(parseInt(data));
})

async function main() {
	const payBtn = document.querySelector("#payBtn");
	const orderId = crypto.randomUUID().substring(0, 8) + "-" + userData.customerId;
	
	const clientKey = "test_gck_docs_Ovk5rk1EwkEbP0W43n07xlzm";
	const tossPayments = TossPayments(clientKey);
	
	const customerKey = "8crlm7AwWJgTgs1S-gPMT";
	const widgets = tossPayments.widgets({ customerKey });
	
	await widgets.setAmount({
    currency: "KRW",
    value: totalPrice,
  });
	
	await Promise.all([
    widgets.renderPaymentMethods({
      selector: "#payment-method",
      variantKey: "DEFAULT",
    }),
    widgets.renderAgreement({ selector: "#agreement", variantKey: "AGREEMENT" })
  ]);
	
	payBtn.addEventListener("click", async function() {
		await widgets.requestPayment({
			orderId : orderId,
			orderName : userData.orderName,
			successUrl : window.location.origin + "/comapay/success",
			failUrl : window.location.origin + "/comapay/fail",
			customerEmail: userData.customerEmail,
      customerName: userData.customerName,
      customerMobilePhone: userData.customerMobilePhone
		})
	})
}

main();