<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Selecione um modulo</h1>
<div class="d-flex flex-column align-items-center ">
	<div class="card p-3 w-100 mb-3">
		<div class="d-flex justify-content-between align-items-center">
			<h2>Gestao de Clientes</h2>
			<p>vence em 12/12/2323</p>
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
</div>

