/**
 * 
 */

const dropOut = document.getElementById('dropOut');
const modal = document.getElementById('modal');

dropOut.addEventListener('click', function(e) {
	modal.classList.add('d-block');
});