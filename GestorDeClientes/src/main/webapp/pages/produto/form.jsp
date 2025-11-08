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
		input::-webkit-outer-spin-button,
		input::-webkit-inner-spin-button {
		  -webkit-appearance: none;
		  margin: 0;
		}
		
		input[type=number] {
		  -moz-appearance: textfield;
		}
</style>


<c:set var="isEdit" value="${not empty produto}"/>


<div class="module-card w-100">
	<c:choose>
		<c:when test="${isEdit}">
			<div  class="d-flex flex-column align-items-left w-100">
				<div class="d-flex align-items-center gap-1">
					<i class="ph ph-arrow-left fw-bold"></i>
					<a class="nav-link" href="${pageContext.request.contextPath}/ManProduto?action=list"> Voltar </a>
				</div>	
				<div>
					<h2 class="fw-bold mt-4 mb-4">Produto código: ${produto.getCodigo()}</h2>
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
				<h2 class="fw-bold mt-4 mb-4">Novo Produto</h2>
			</div>
		</div>
	
		</c:otherwise>
	</c:choose>
	<div class="card p-3 w-100 mb-3">
		<form id="form" action="ManProduto" method="post">
			<c:if test="${isEdit}">	
				<input type="hidden" name="codigo" value="${produto.getCodigo()}">
			</c:if>
			<div class="mb-3">
			    <label for="name" class="form-label fw-semibold">Nome:</label><br>
			    <input <c:if test="${isEdit}">value="${produto.getNome()}"</c:if> maxlength="255" class="form-control" type="text" name="nome" required>
			</div>
			<div class="mb-3">
			    <label for="preco" class="form-label fw-semibold">Preço:</label><br>
	    		<input <c:if test="${isEdit}">value="${String.format("%.2f",produto.getPreco())}"</c:if> max="99999999.99" class="form-control" type="number" min="0" step="0.01" name="preco" required>
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
