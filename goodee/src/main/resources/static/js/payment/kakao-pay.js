/**
 * 
 */

const SJPayBtnArr = document.querySelectorAll('.SJPayBtn');

SJPayBtnArr.forEach(function(payBtn) {
	payBtn.addEventListener('click', function() {
		
		const productNumber = payBtn.dataset.productNumber;
		
		const data = {
			"productNumber": productNumber,
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
		"productNumberArr": productNumberArr,
		"create": {
			"mode": "development",
			"clientId": "",
			"chainId": "",
			"openType": "popup"
		},
		"open": {
			"merchantPayKey": "${ logined.accountNumber }-${ productDTO.productNumber }",
			"productName": "${ productDTO.name }",
			"productCount": "1",
			"totalPayAmount": "${ productDTO.price }",
			"taxScopeAmount": "${ productDTO.price }",
			"taxExScopeAmount": "0",
			"returnUrl": "",
		}
	}

	fetch("/naverPay/purchaseCart", {
		method: 'post',
		headers : {"Content-Type" : "application/json"},
		body: JSON.stringify(data)
	})
	.then(r => r.json())
	.then(r => {
		console.log(r);
		const oPay = Naver.Pay.create(r.create);
		oPay.open(r.open);
	});
	
});



