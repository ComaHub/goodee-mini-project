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