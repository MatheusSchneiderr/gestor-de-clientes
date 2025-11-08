<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<style>
		input:focus{
			box-shadow: none !important;
			border-color: #212529 !important;
		}
		.btn-primary{
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
				<div>
					<h2 class="fw-bold mt-4 mb-4">Cliente código: ${cliente.getCodigo()}</h2>
				</div>
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
			    <input <c:if test="${isEdit}">value="${cliente.getNome()}"</c:if> maxlength="255" class="form-control" type="text" name="nome" required>
			</div>
			<div class="mb-3">
			    <label for="cpf" class="form-label fw-semibold">Cpf:</label><br>
	    		<input <c:if test="${isEdit}">value="${cliente.getCpf()}"</c:if> maxlength="20" class="form-control" type="text" name="cpf" required>
			</div>
			<div class="mb-3">
			    <label for="rg" class="form-label fw-semibold">Rg:</label><br>
			    <input <c:if test="${isEdit}">value="${cliente.getRg()}"</c:if> maxlength="20" class="form-control" type="text" name="rg" required>			
			</div>
			<div class="mb-3">
			    <label for="email" class="form-label fw-semibold">Email:</label><br>
			    <input <c:if test="${isEdit}">value="${cliente.getEmail()}"</c:if> maxlength="80" class="form-control" type="email" name="email" required> 		
			</div>
			<div class="mb-4">
			    <label for="telefone" class="form-label fw-semibold">Telefone:</label><br>
			    <input <c:if test="${isEdit}">value="${cliente.getTelefone()}"</c:if> maxlength="20" class="form-control" type="tel" name="telefone" required>		
			</div>
			<div class="d-flex justify-content-start gap-3">
				<button class="btn btn-success w-40 ps-3 pe-3" type="submit">
					<div class="d-flex align-items-center gap-1">
						<i class="ph ph-upload-simple fw-bolder"></i><b>Salvar</b>
					</div>
				</button>		
				<c:if test="${isEdit}">
					<button class="btn btn-danger w-40 ps-3 pe-3" name="action" value="delete" type="submit">
						<div class="d-flex align-items-center gap-1">
							<i class="ph ph-x fw-bolder"></i><b>Excluir</b>
						</div>
					</button>
				</c:if>				
			</div>		
		</form>
	</div>	
</div>
