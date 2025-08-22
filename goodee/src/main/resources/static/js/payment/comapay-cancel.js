let totalPrice = 0;

document.querySelectorAll(".productPrice").forEach((price) => {
	totalPrice += parseInt(price.getAttribute("data-product-price"));
});

document.querySelector("#totalPrice").append(totalPrice);

