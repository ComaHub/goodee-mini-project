if (document.querySelector("#updateBtn") != null) {
	document.querySelector("#updateBtn").addEventListener("click", (event) => {
		const productNum = event.target.getAttribute("data-product-number");
		
		location.href = "update?productNumber=" + productNum;
	});
}

if (document.querySelector("#deleteBtn") != null) {
	document.querySelector("#deleteBtn").addEventListener("click", (event) => {
		Swal.fire({
		  title: "정말 삭제하시겠습니까?",
		  text: "이 결정은 되돌릴 수 없습니다.",
		  icon: "warning",
		  showCancelButton: true,
		  confirmButtonColor: "#3085d6",
		  cancelButtonColor: "#d33",
		  confirmButtonText: "삭제",
			cancelButtonText: "취소"
		}).then((result) => {
		  if (result.isConfirmed) {
				const productNum = event.target.getAttribute("data-product-number");
					
				location.href = "delete?productNumber=" + productNum;
		  }
		});
	});
}

if (document.querySelector("#addCartBtn") != null) {
	document.querySelector("#addCartBtn").addEventListener("click", (event) => {
		event.preventDefault();
		
		const productNumber = event.target.getAttribute("data-product-number");
				
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
}

if (document.querySelector("#addLikeBtn") != null) {
	document.querySelector("#addLikeBtn").addEventListener("click", (event) => {
		event.preventDefault();
		
		const productNumber = event.target.getAttribute("data-product-number");
				
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
}