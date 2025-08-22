/**
 * 
 */

const dropOut = document.getElementById('dropOut');
const modal = document.getElementById('modal');
const closeModal = document.getElementById('btn-close');

dropOut.addEventListener('click', function(e) {
	modal.classList.add('d-block');
});

closeModal.addEventListener('click', function(e) {
	modal.classList.remove('d-block');
});