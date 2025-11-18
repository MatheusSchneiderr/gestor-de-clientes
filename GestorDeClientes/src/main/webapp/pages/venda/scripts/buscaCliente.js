document.addEventListener("DOMContentLoaded", () => {
	const box = document.getElementById("idClienteInput");
	
	box.addEventListener("input", () => {
		addCliente();
	});	
});


function addCliente(){
	const box = document.getElementById("idClienteInput");
	const clienteNameBox = document.getElementById("clienteName");
		
	const codigo = box.value.trim();

		    // opcional: evita consultas muito curtas
	if (codigo.length < 1) return;

	fetch("ConCliente", {
	    method: "POST",
	    headers: {
	    	"Content-Type": "application/x-www-form-urlencoded"
	    },
		body: "codigo=" + encodeURIComponent(codigo)
	})
	.then(res => res.json())
	.then(data => {

	    if (data == null) {
	        clienteNameBox.value = "Nenhum cliente encontrado";
	        return;
	    }

	    clienteNameBox.value = `${data.nome}`;

	})
    //.catch(err => console.log(err));
}