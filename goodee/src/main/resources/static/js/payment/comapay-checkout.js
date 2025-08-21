async function main() {
	const payBtn = document.querySelector("#payBtn");
	
	const clientKey = "test_gck_docs_Ovk5rk1EwkEbP0W43n07xlzm";
	const tossPayments = TossPayments(clientKey);
	
	const customerKey = "8crlm7AwWJgTgs1S-gPMQ";
	const widgets = tossPayments.widgets({ customerKey });
	
	await widgets.setAmount({
    currency: "KRW",
    value: 50000,
  });
	
	await Promise.all([
    widgets.renderPaymentMethods({
      selector: "#payment-method",
      variantKey: "DEFAULT",
    }),
    widgets.renderAgreement({ selector: "#agreement", variantKey: "AGREEMENT" })
  ]);
}

main();