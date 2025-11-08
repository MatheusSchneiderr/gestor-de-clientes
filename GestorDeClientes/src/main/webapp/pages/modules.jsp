<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="d-flex flex-column align-items-center w-100">
	<div class="w-100">
		<h2 class="fw-bold mt-4 mb-4 text-center">Selecione um modulo</h2>
	</div>
		<div class="card p-3 w-100 mb-3 module-card">
			<div class="d-flex justify-content-between align-items-center">
				<h3>Gestao de Clientes</h3>
			</div>
			<div class="d-flex justify-content-left align-items-center gap-3">
				<div class="d-flex align-items-center gap-3">
					<i class="ph ph-arrow-elbow-down-right fw-bold"></i>
					<a class="nav-link" href="<c:url value='/ManCliente'><c:param name='action' value='form'/></c:url>">Cadastro</a>
				</div>
				<div class="d-flex align-items-center gap-3">
					<i class="ph ph-arrow-elbow-down-right fw-bold"></i>
					<a class="nav-link" href="<c:url value='/ManCliente'><c:param name='action' value='list'/></c:url>">Consulta</a>	
				</div>
			</div>
		</div>	
		<div class="card p-3 w-100 mb-3 module-card">
			<div class="d-flex justify-content-between align-items-center">
				<h3>Gestao de Produtos</h3>
			</div>
			<div class="d-flex justify-content-left align-items-center gap-3">
				<div class="d-flex align-items-center gap-3">
					<i class="ph ph-arrow-elbow-down-right fw-bold"></i>
					<a class="nav-link" href="<c:url value='/ManProduto'><c:param name='action' value='form'/></c:url>">Cadastro</a>
				</div>
				<div class="d-flex align-items-center gap-3">
					<i class="ph ph-arrow-elbow-down-right fw-bold"></i>
					<a class="nav-link" href="<c:url value='/ManProduto'><c:param name='action' value='list'/></c:url>">Consulta</a>	
				</div>
			</div>
		</div>			
</div>

