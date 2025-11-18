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
		textarea:focus{
			box-shadow: none !important;
			border-color: #212529 !important;
		}
		.botaoAdd{
			padding-top: 30px;
			padding-bottom: 2px;
		}
</style>

<c:set var="isEdit" value="${not empty venda}"/>


<div class="module-card w-100">
	<c:choose>
		<c:when test="${isEdit}">
			<div  class="d-flex flex-column align-items-left w-100">
				<div class="d-flex align-items-center gap-1">
					<i class="ph ph-arrow-left fw-bold"></i>
					<a class="nav-link" href="${pageContext.request.contextPath}/ManVenda?action=list"> Voltar </a>
				</div>	
				<div>
					<h2 class="fw-bold mt-4 mb-4">Venda código: ${venda.getIdVenda()}</h2>
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
				<h2 class="fw-bold mt-4 mb-4">Nova Venda</h2>
			</div>
		</div>
	
		</c:otherwise>
	</c:choose>
	<div class="card p-3 w-100 mb-3">
		<form id="form" action="ManVenda" method="post">
			<c:if test="${isEdit}">	
				<input type="hidden" name="codigo" value="${venda.getIdVenda()}">
			</c:if>			
		    <input type="hidden" name="itens" id="itensJson">
		    <div class="mb-3">
				<label for="idCliente" class="form-label fw-semibold">Código do Cliente:</label><br>
				<div class="d-flex justify-content-start gap-2">
					<input <c:if test="${isEdit}">value="${venda.getIdCliente()}"</c:if> maxlength="255" class="form-control w-25" type="number" name="idCliente" id="idClienteInput" required><br>
					<input id="clienteName" maxlength="255" class="form-control w-75" type="text" disabled>		    		    
				</div>		    
		    </div>
		    <div class="card p-3 mb-3">
			    			<!-- ADICIONAR PROUTO -->
				<div class="">
				    <label for="name" class="form-label fw-semibold">Adicionar Produtos:</label><br>
					<div class="d-flex justify-content-start gap-3 mb-2">		    	
				    	<div class="">
				    		<label for="name" class="form-label fw-semibold">Cód:</label><br>
				    		<textarea rows="1" class="form-control" id="queryBox" placeholder="Cód. Produto"></textarea>
				    	</div>
				    	<div class="">
				    		<label for="name" class="form-label fw-semibold">Descrição:</label><br>
				    		<textarea rows="1" class="form-control idProduto" disabled id="descProdutoBox" placeholder="Nome Produto"></textarea>
				    	</div>
				    	<div class="">
				    		<label for="name" class="form-label fw-semibold">Qtd.</label><br>
				    		<textarea rows="1" class="form-control quantidade" id="qtdProdutoBox" placeholder="1,2,3,4..."></textarea>
				    	</div>
				    	<div class="">
				    		<label for="name" class="form-label fw-semibold">Preço</label><br>
				    		<textarea rows="1" class="form-control valor" id="valorProdutoBox" placeholder="0,00" disabled></textarea>
				    	</div>						    					
				    	<div class="d-flex align-items-end">
							<button class="btn btn-success" id="btnAddProduto" type="button" onclick="addProduto()" disabled>Adicionar</button>
				    	</div>		    	
				    </div>
				    <!--  FIM ADICIONAR PRODUTO -->
				</div>
				<hr class="mb-3">
				<label for="name" class="form-label fw-semibold">Produtos adicionados:</label><br>
				<div class="d-flex flex-column mb-3" id="produtosContainer">
					<c:if test="${isEdit}">
						<c:forEach var="i" items="${venda.getProdutos()}">
							<div class="produtoItem">
								<div class="d-flex justify-content-start gap-3">
									<div class="">
									    <label for="name" class="form-label fw-semibold">Código Produto:</label><br>
									    <input value="${i.getIdProduto()}" maxlength="255" class="form-control idProduto" type="number" required>								
									</div>
									<div class="">
									    <label for="name" class="form-label fw-semibold">Quantidade:</label><br>
									    <input value="${i.getQuantidade()}" maxlength="255" class="form-control quantidade" type="number" required>						    						
									</div>
									<div class="">
									    <label for="name" class="form-label fw-semibold">Preço:</label><br>
									    <input value="${i.getValorUn()}" maxlength="255" class="form-control valor" type="number" max="99999999.99" min="0" step="0.01" required disabled>						    						
									</div>									
									<div class="d-flex align-items-end">
										<button class="btn btn-danger fw-bold" type="button" onclick="removeProduto(this)">X</button>
									</div>				
								</div>
							</div>
						</c:forEach>
					</c:if>
				</div>
				<div class="mb-3">
					<label class="form-label fw-semibold">Total:</label><br>
					<input id="totalProdutos" class="form-control" type="number" max="99999999.99" min="0" step="0.01" disabled>
				</div>
		    </div>

						
			<div class="d-flex justify-content-start gap-3">
				<button class="btn btn-success w-40 ps-3 pe-3" type="submit" onclick="prepareJson()">
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


<script src="pages/venda/scripts/scripts.js"></script>
<script src="pages/venda/scripts/buscaProduto.js"></script>
<script src="pages/venda/scripts/buscaCliente.js"></script>
<c:if test="${isEdit}"><script src="pages/venda/scripts/loadEditMode.js"></script></c:if>


