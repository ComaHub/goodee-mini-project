document.querySelectorAll(".addCartBtn").forEach((btn) => {
	btn.addEventListener("click", (event) => {
		event.preventDefault();
		
		const productNumber = event.target.parentElement.getAttribute("data-product-number");
		
		Swal.fire({
		  text: "장바구니에 추가하시겠습니까?",
		  icon: "question",
		  showCancelButton: true,
		  confirmButtonColor: "#3085d6",
		  cancelButtonColor: "#d33",
		  confirmButtonText: "추가",
			cancelButtonText: "취소",
			heightAuto: false
		}).then((result) => {
		  if (result.isConfirmed) {
				fetch("/cart/add?productNumber=" + productNumber, {
					method : "GET"
				})
				.then((data) => data.text())
				.then((data) => {
					if (data) {
						Swal.fire({
							title: "장바구니에 추가했습니다!",
						  text: "내 장바구니로 이동하시겠습니까?",
						  icon: "question",
						  showCancelButton: true,
						  confirmButtonColor: "#3085d6",
						  cancelButtonColor: "#d33",
						  confirmButtonText: "이동",
							cancelButtonText: "취소",
							heightAuto: false
						}).then((result) => {
						  if (result.isConfirmed) {
								location.href = "/cart/list";
						  }
						});
					} else {
						Swal.fire({ text: "장바구니에 추가하는 중 오류가 발생했습니다.", icon: "warning" });
					}
				})
				.catch(() => {
					Swal.fire({ text: "장바구니에 추가하는 중 오류가 발생했습니다.", icon: "warning" });
				})
		  }
		});
	})
})

document.querySelectorAll(".removeCartBtn").forEach((btn) => {
	btn.addEventListener("click", (event) => {
		event.preventDefault();
		
		Swal.fire({
		  text: "장바구니에서 제거하시겠습니까?",
		  icon: "question",
		  showCancelButton: true,
		  confirmButtonColor: "#3085d6",
		  cancelButtonColor: "#d33",
		  confirmButtonText: "제거",
			cancelButtonText: "취소",
			heightAuto: false
		}).then((result) => {
		  if (result.isConfirmed) {
				const productNumber = event.target.parentElement.getAttribute("data-product-number");
				
				location.href = "/cart/delete?productNumber=" + productNumber;
			}
		});
	})
});

document.querySelectorAll(".addLikeBtn").forEach((btn) => {
	btn.addEventListener("click", (event) => {
		event.preventDefault();
		
		const productNumber = event.target.parentElement.getAttribute("data-product-number");
		
		Swal.fire({
		  text: "찜 목록에 추가하시겠습니까?",
		  icon: "question",
		  showCancelButton: true,
		  confirmButtonColor: "#3085d6",
		  cancelButtonColor: "#d33",
		  confirmButtonText: "추가",
			cancelButtonText: "취소",
			heightAuto: false
		}).then((result) => {
		  if (result.isConfirmed) {
				fetch("/like/add?productNumber=" + productNumber, {
					method : "GET"
				})
				.then((data) => data.text())
				.then((data) => {
					if (data) {
						Swal.fire({
							title: "찜 목록에 추가했습니다!",
						  text: "찜 목록으로 이동하시겠습니까?",
						  icon: "question",
						  showCancelButton: true,
						  confirmButtonColor: "#3085d6",
						  cancelButtonColor: "#d33",
						  confirmButtonText: "이동",
							cancelButtonText: "취소",
							heightAuto: false
						}).then((result) => {
						  if (result.isConfirmed) {
								location.href = "/like/list";
						  }
						});
					} else {
						Swal.fire({ text: "찜 목록에 추가하는 중 오류가 발생했습니다.", icon: "warning" });
					}
				})
				.catch(() => {
					Swal.fire({ text: "찜 목록에 추가하는 중 오류가 발생했습니다.", icon: "warning" });
				})
		  }
		});
	})
});

document.querySelectorAll(".removeLikeBtn").forEach((btn) => {
	btn.addEventListener("click", (event) => {
		event.preventDefault();
		
		Swal.fire({
		  text: "찜 목록에서 제거하시겠습니까?",
		  icon: "question",
		  showCancelButton: true,
		  confirmButtonColor: "#3085d6",
		  cancelButtonColor: "#d33",
		  confirmButtonText: "제거",
			cancelButtonText: "취소",
			heightAuto: false
		}).then((result) => {
		  if (result.isConfirmed) {
				const productNumber = event.target.parentElement.getAttribute("data-product-number");
				
				location.href = "/like/delete?productNumber=" + productNumber;
			}
		});
	})
});