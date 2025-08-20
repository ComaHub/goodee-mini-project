document.querySelector("#updateBtn").addEventListener("click", (event) => {
	const animalNum = event.target.getAttribute("data-animal-number");
	
	location.href = "update?num=" + animalNum;
});