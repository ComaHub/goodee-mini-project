document.querySelector("#updateBtn").addEventListener("click", (event) => {
	const animalNum = event.target.getAttribute("data-animal-number");
	
	location.href = "update?num=" + animalNum;
});

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
			const animalNum = event.target.getAttribute("data-animal-number");
				
			location.href = "delete?num=" + animalNum;
	  }
	});
});