
// Esse array vai segurar os itens para mandar pro servlet.
let itens = [];

function alterarTotal(){
	let val = 0.0;
	
	const rows = document.querySelectorAll(".produtoItem");

	rows.forEach(row => {
		if(row.querySelector(".quantidade").value <= 0){
			row.querySelector(".quantidade").value = 1;
		}
	    const quantidade = row.querySelector(".quantidade").value;
		
		const valor_un = row.querySelector(".valor").value;
		val += parseFloat(valor_un) * parseFloat(quantidade)
	});
	
	document.getElementById("totalProdutos").value = val.toFixed(2);
}


function addProduto() {
    const container = document.getElementById("produtosContainer");
	
	const idProdutoText = document.getElementById("queryBox");
	const idProduto = Number(idProdutoText.value.trim());
	
	if (!itens.some(item => item.idProduto === idProduto)){
		const qtdBox = document.getElementById("qtdProdutoBox");
		if(qtdBox.value <= 0){
			qtdBox.value = 1;
		}
		const qtd = qtdBox.value;
		
		const nameBox = document.getElementById("descProdutoBox");
		const name = nameBox.value;
		
		const valorBox = document.getElementById("valorProdutoBox");
		const valor = valorBox.value;

		const div = document.createElement("div");
		div.classList.add("produtoItem");

		div.innerHTML = `
		<div class="d-flex justify-content-start gap-3">
			<div class="">
				<label for="name" class="form-label fw-semibold">Código Produto:</label><br>
				<input value="${idProduto}" maxlength="255" class="form-control idProduto" type="number" disabled required>								
			</div>
			<div class="">
				<label for="name" class="form-label fw-semibold">Nome Produto:</label><br>
				<input value="${name}" maxlength="255" class="form-control nomeProduto" type="text" disabled required>								
			</div>			
			<div class="">
				<label for="name" class="form-label fw-semibold">Quantidade:</label><br>
				<input value="${qtd}" maxlength="255" class="form-control quantidade" id="qtdBox" min="1" type="number" required>						    						
			</div>
			<div class="">
				<label for="name" class="form-label fw-semibold">Preço</label><br>
				<input value="${valor}" class="form-control valor" type="number" max="99999999.99" min="0.01" step="0.01" disabled required>
			</div>				
			<div class="d-flex align-items-end">
				<button class="btn btn-danger fw-bold" type="button" onclick="removeProduto(this)">X</button>
			</div>				
		</div>
		`;

		const qtdInput = div.querySelector(".quantidade");
		qtdInput.addEventListener("input", alterarTotal);
		
		container.appendChild(div);
		
		
		
		prepareJson();
	}

	document.getElementById("btnAddProduto").disabled = true;
	document.getElementById("queryBox").value = "";
	document.getElementById("qtdProdutoBox").value = "";
	document.getElementById("descProdutoBox").value = "";
	document.getElementById("valorProdutoBox").value = "";

}

function removeProduto(button) {
    button.closest(".produtoItem").remove();
	prepareJson();
}

// Convert the dynamic inputs into JSON when form is submitted
function prepareJson() {
    itens = []; // reset

	let val = 0.0;
	
    const rows = document.querySelectorAll(".produtoItem");

    rows.forEach(row => {
        const idProduto = row.querySelector(".idProduto").value;
        const quantidade = row.querySelector(".quantidade").value;
		
		const valor_un = row.querySelector(".valor").value;
		val += parseFloat(valor_un) * parseFloat(quantidade);
					
        itens.push({
            idProduto: parseInt(idProduto),
            quantidade: parseInt(quantidade),
			valorUn: parseFloat(valor_un)
        });
    });
	
	document.getElementById("totalProdutos").value = val.toFixed(2);

    // Insert JSON into hidden field
    document.getElementById("itensJson").value = JSON.stringify(itens);
}