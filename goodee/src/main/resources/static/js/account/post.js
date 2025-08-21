/**
 * 
 */

const postBtn = document.querySelector('#postBtn');
const postcode = document.querySelector('#postcode');
const address = document.querySelector('#address');

postBtn.addEventListener('click', function() {
	new daum.Postcode({
	    oncomplete: function(data) {
			postcode.value = data.zonecode;
			address.value = data.address
	    }
	}).open();
});

document.querySelector("#attach").addEventListener("change", (event) => {
	if (event.target.files && event.target.files[0]) {
			const reader = new FileReader();
			
			reader.onload = function (event) {
				document.querySelector("#preview").src = event.target.result;
			};
			
			reader.readAsDataURL(event.target.files[0]);
		} else {
			document.querySelector("#preview").src = "";
		}
})