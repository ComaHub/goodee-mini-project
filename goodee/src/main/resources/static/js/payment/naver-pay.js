/**
 * 
 */

const payBtn = document.getElementById('');


const oPay = Naver.Pay.create({
	"mode": "development",
	"clientId": "",
	"chainId": "",
	"openType": "popup"
})


payBtn.addEventListener('click', function() {
	const data = {
		"merchantPayKey": "${ logined.accountNumber }-${ productDTO.productNumber }",
		"productName": "${ productDTO.name }",
		"productCount": "1",
		"totalPayAmount": "${ productDTO.price }",
		"taxScopeAmount": "${ productDTO.price }",
		"taxExScopeAmount": "0",
		"returnUrl": "./detail?productNumber=${ productDTO.productNumber }",
	}
	
	fetch("/url", {
		method: post,
		body: JSON.stringify(data)
	})
	.then(r => r.text)
	.then(r => {
		console.log(r);
	});
});