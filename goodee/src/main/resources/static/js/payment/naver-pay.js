/**
 * 
 */

const payBtn = document.getElementById('');

payBtn.addEventListener('click', function() {
	const data = {
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
			"returnUrl": "./detail?productNumber=${ productDTO.productNumber }",
		}
	}
	
	fetch("/url", {
		method: post,
		body: JSON.stringify(data)
	})
	.then(r => r.json)
	.then(r => {
		console.log(r);
		const oPay = Naver.Pay.create(r.create);
		oPay.open(r.open);
	});
});