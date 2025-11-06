<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style>
		input:focus{
			box-shadow: none !important;
			border-color: #212529 !important;
		}
		button{
			background-color: #23272b !important;
			border: 1px solid #212529 !important;
		}
		button:hover{
			opacity: 70%;
		}
</style>

<h2>Novo Cliente</h2>
<form action="ManCliente" method="post">
	<div class="card w-100 p-3">
		<div class="mb-3">
		    <label for="name" class="form-label fw-semibold">Nome:</label><br>
		    <input class="form-control" type="text" name="nome" required>
		</div>
		<div class="mb-3">
		    <label for="cpf" class="form-label fw-semibold">Cpf:</label><br>
    		<input class="form-control" type="text" name="cpf" required>
		</div>
		<div class="mb-3">
		    <label for="rg" class="form-label fw-semibold">Rg:</label><br>
		    <input class="form-control" type="text" name="rg" required>			
		</div>
		<div class="mb-3">
		    <label for="email" class="form-label fw-semibold">Email:</label><br>
		    <input class="form-control" type="email" name="email" required> 		
		</div>
		<div class="mb-3">
		    <label for="telefone" class="form-label fw-semibold">Telefone:</label><br>
		    <input class="form-control" type="tel" name="telefone" required>		
		</div>		
		<button class="btn btn-primary w-100" type="submit">Send</button>		
	</div>
</form>