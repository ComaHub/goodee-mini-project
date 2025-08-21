const urlParams = new URLSearchParams(window.location.search);
const paymentKey = urlParams.get("paymentKey");
const orderId = urlParams.get("orderId");
const amount = urlParams.get("amount");

async function confirm() {
  const requestData = {
    paymentKey: paymentKey,
    orderId: orderId,
    amount: amount,
  };

  const response = await fetch("confirm", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(requestData),
  });

  const json = await response.json();

  if (!response.ok) {
    window.location.href = `/comapay/fail?message=${json.message}&code=${json.code}`;
		return;
  }

  fetch("result", {
		method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(requestData),
	});
}

confirm();

document.querySelector("#amount").append(amount);
document.querySelector("#orderId").append(orderId);