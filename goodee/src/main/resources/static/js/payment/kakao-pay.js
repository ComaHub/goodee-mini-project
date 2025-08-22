/**
 * 
 */

const SJPayBtnArr = document.querySelectorAll('.SJPayBtn');

SJPayBtnArr.forEach(function(payBtn) {
	payBtn.addEventListener('click', function() {
		const productNumberArr = [];
		
		const productNumber = payBtn.dataset.productNumber;
		productNumberArr.push(productNumber);
		
		const data = {
			"productNumberArr": productNumberArr
		}
		
		fetch("/kakaoPay/purchase", {
			method: 'post',
			headers : {"Content-Type" : "application/json"},
			body: JSON.stringify(data)
		})
		.then(r => r.json())
		.then(r => {
			console.log(r);
			location.href=r.next_redirect_pc_url;
		});
	});
})


const SJPayAllBtn = document.getElementById('SJPayAllBtn');

SJPayAllBtn.addEventListener('click', function() {
	const checkArr = document.querySelectorAll('.checkedProduct');
	const productNumberArr = [];
	
	checkArr.forEach(function(c) {
		if (c.checked == true)
			productNumberArr.push(c.value);
	});

	const data = {
		"productNumberArr": productNumberArr
	}

	fetch("/kakaoPay/purchase", {
		method: 'post',
		headers : {"Content-Type" : "application/json"},
		body: JSON.stringify(data)
	})
	.then(r => r.json())
	.then(r => {
		console.log(r);
		location.href=r.next_redirect_pc_url;
	});
	
});



