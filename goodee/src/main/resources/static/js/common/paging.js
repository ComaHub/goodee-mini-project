/**
 * 
 */

/* 페이징 */
const paging = document.querySelector('#paging');
const nowPage = document.querySelector('#nowPage');
const pagingBtn = document.querySelectorAll('.page-link');

pagingBtn.forEach(function(p) {
	p.addEventListener('click', function() {
		console.log(p);
		nowPage.value = p.dataset.nowPage;
		paging.submit();
	});
});
/* 페이징 */