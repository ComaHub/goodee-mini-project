/**
 * 
 */

const authorities = document.querySelectorAll('.auth');

authorities.forEach(function (a) {
	a.addEventListener('change', function () {
		number = a.dataset.number;
		admin = a.value;
		
		const params = new URLSearchParams();
		params.append('number', number);
		params.append('admin', admin);
		
		fetch('./list', {
			method: 'POST',
			body: params
		})
		.then(r => text())
		.then(r => {
			r = r.trim();
			console.log(r);
		});
	});
});