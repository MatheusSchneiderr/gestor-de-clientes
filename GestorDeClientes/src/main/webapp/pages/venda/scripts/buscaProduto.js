document.addEventListener("DOMContentLoaded", () => {	
	const box = document.getElementById("queryBox");
	const descProdutoBox = document.getElementById("descProdutoBox");
	const valorBox = document.getElementById("valorProdutoBox");
	
	box.addEventListener("input", () => {
	    const codigo = box.value.trim();

	    // opcional: evita consultas muito curtas
	    if (codigo.length < 1) return;

	    fetch("ConProduto", {
	        method: "POST",
	        headers: {
	            "Content-Type": "application/x-www-form-urlencoded"
	        },
	        body: "codigo=" + encodeURIComponent(codigo)
	    })
		.then(res => res.json())
		.then(data => {

			const valor = parseFloat(data.preco);

		    // se vier null, trata
		    if (data == null) {
		        descProdutoBox.value = "Nenhum produto encontrado";
				document.getElementById("btnAddProduto").disabled = true;
		        return;
		    }
		    // data é um OBJETO, não uma lista
		    descProdutoBox.value = `${data.nome}`;
			valorBox.value = valor;

			if(!itens.some(item => item.idProduto == codigo)){				
				document.getElementById("btnAddProduto").disabled = false;
			}
			else{
				document.getElementById("btnAddProduto").disabled = true;
			}
		})
	    .catch(err => {
			document.getElementById("btnAddProduto").disabled = true;
			document.getElementById("qtdProdutoBox").value = "";
			document.getElementById("descProdutoBox").value = "Nenhum produto encontrado";
			document.getElementById("valorProdutoBox").value = "";
		});
	});	
});