<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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


<c:set var="isEdit" value="${not empty cliente}"/>


<div class="module-card w-100">
	<c:choose>
		<c:when test="${isEdit}">
			<div  class="d-flex flex-column align-items-left w-100">
				<div class="d-flex align-items-center gap-1">
					<i class="ph ph-arrow-left fw-bold"></i>
					<a class="nav-link" href="${pageContext.request.contextPath}/ManCliente?action=list"> Voltar </a>
				</div>	
				<h2 class="fw-bold mt-4 mb-4">Cliente código: ${cliente.getCodigo()}</h2>
			</div>
		</c:when>
		<c:otherwise>
		<div  class="d-flex flex-column align-items-left w-100">
			<div class="d-flex align-items-center gap-1">
				<i class="ph ph-arrow-left fw-bold"></i>
				<a class="nav-link" href="${pageContext.request.contextPath}/"> Voltar </a>
			</div>
			<div>
				<h2 class="fw-bold mt-4 mb-4">Novo Cliente</h2>
			</div>
		</div>
	
		</c:otherwise>
	</c:choose>
	<div class="card p-3 w-100 mb-3">
		<form id="form" action="ManCliente" method="post">
			<c:if test="${isEdit}">
				<input type="hidden" name="codigo" value="${cliente.getCodigo()}">
			</c:if>
			<div class="mb-3">
			    <label for="name" class="form-label fw-semibold">Nome:</label><br>
			    <input <c:if test="${isEdit}">value="${cliente.getNome()}"</c:if> class="form-control" type="text" name="nome" required>
			</div>
			<div class="mb-3">
			    <label for="cpf" class="form-label fw-semibold">Cpf:</label><br>
	    		<input <c:if test="${isEdit}">value="${cliente.getCpf()}"</c:if> value="" class="form-control" type="text" name="cpf" required>
			</div>
			<div class="mb-3">
			    <label for="rg" class="form-label fw-semibold">Rg:</label><br>
			    <input <c:if test="${isEdit}">value="${cliente.getRg()}"</c:if> class="form-control" type="text" name="rg" required>			
			</div>
			<div class="mb-3">
			    <label for="email" class="form-label fw-semibold">Email:</label><br>
			    <input <c:if test="${isEdit}">value="${cliente.getEmail()}"</c:if> class="form-control" type="email" name="email" required> 		
			</div>
			<div class="mb-3">
			    <label for="telefone" class="form-label fw-semibold">Telefone:</label><br>
			    <input <c:if test="${isEdit}">value="${cliente.getTelefone()}"</c:if> class="form-control" type="tel" name="telefone" required>		
			</div>		
		<button class="btn btn-primary w-100" type="submit">Salvar</button>		
		</form>
	</div>	
</div>
