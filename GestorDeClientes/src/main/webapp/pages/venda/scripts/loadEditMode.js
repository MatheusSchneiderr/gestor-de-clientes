/**
 * 
 */
document.addEventListener("DOMContentLoaded", () => {
	const rows = document.querySelectorAll(".produtoItem");

	rows.forEach(row => {
		const qtdInput = row.querySelector(".quantidade");
		qtdInput.addEventListener("input", alterarTotal);
	});

	prepareJson();
	addCliente();	
});
