/**
 * 
 */

const div = document.getElementById('content');

fetch("/kakaoPay/list", {
	method: 'post',
	headers : {"Content-Type" : "application/json"}
})
.then(r => r.text())
.then(r => {
	console.log(r);
	div.textContent = r;
});