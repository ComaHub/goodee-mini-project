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
	const orderId = userData.orderIdFirst + "-" + userData.customerId;
	const customerKey = "8crlm7AwWJgTgs1S-gPMT";
	
	const tossPayments = TossPayments(clientKey);
	const payment = tossPayments.payment({ customerKey });
	
	payBtn.addEventListener("click", async function() {
		await payment.requestPayment({
      method: "CARD",
      amount: {
        currency: "KRW",
        value: totalPrice,
      },
      orderId: orderId,
      orderName: userData.orderName,
      successUrl: window.location.origin + "/comapay/success",
      failUrl: window.location.origin + "/comapay/fail",
      customerEmail: userData.customerEmail,
      customerName: userData.customerName,
      customerMobilePhone: userData.customerMobilePhone,
      card: {
        useEscrow: false,
        flowMode: "DEFAULT",
        useCardPoint: false,
        useAppCardOnly: false,
      },
    });
	});
}

main();