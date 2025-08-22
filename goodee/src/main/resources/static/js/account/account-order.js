document.querySelector("#cancelBtn").addEventListener("click", (event) => {
	Swal.fire({
		title: "구매를 취소하시겠습니까?",
	  text: "배송 완료된 주문은 취소할 수 없습니다.",
	  icon: "question",
	  showCancelButton: true,
	  confirmButtonColor: "#3085d6",
	  cancelButtonColor: "#d33",
	  confirmButtonText: "확인",
		cancelButtonText: "취소",
		heightAuto: false
	}).then((result) => {
	  if (result.isConfirmed) {
			const paymentId = event.target.getAttribute("data-payment-id");
			
			location.href = "/comapay/cancel?paymentId=" + paymentId;
		}
	});
})