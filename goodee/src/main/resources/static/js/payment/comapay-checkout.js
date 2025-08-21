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
			orderId : "testOrder6",
			orderName : "테스트",
			successUrl : window.location.origin + "/comapay/success",
			failUrl : window.location.origin + "/comapay/fail",
			customerEmail: "test@example.com",
      customerName: "테스터",
      customerMobilePhone: "01012341234"
		})
	})
}

main();