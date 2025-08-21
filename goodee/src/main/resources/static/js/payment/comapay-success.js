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
  }

  // 결제 성공 비즈니스 로직을 구현하세요.
  console.log(json);
}

confirm();

document.querySelector("#amount").append(amount);
document.querySelector("#orderId").append(orderId);