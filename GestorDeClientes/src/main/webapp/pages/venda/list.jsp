<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="w-100 module-card">
	<div  class="d-flex flex-column align-items-left w-100">
		<div class="d-flex align-items-center gap-1">
			<i class="ph ph-arrow-left fw-bold"></i>
			<a class="nav-link" href="${pageContext.request.contextPath}/"> Voltar </a>
		</div>
		<div>
			<h2 class="fw-bold mt-4 mb-4">Vendas</h2>
		</div>
	</div>
	<c:forEach var="v" items="${vendas}">
		<div class="card p-3 w-100 mb-3">
			<div class="d-flex justify-content-between align-items-center">
				<div>
					<div class="fw-bold">venda com ${v.getNomeCliente(clientes)}</div>
					<div>realizada em ${v.getDataVenda().toString()}, venda cód ${v.getIdVenda()}, cliente cód ${v.getIdCliente()}</div>
					<div>Total: R$ ${String.format("%.2f",v.getValorTotal())}</div>
				</div>
				<div>
					<jsp:include page="/components/botao.jsp">
						<jsp:param name="texto" value="Ver"/>
						<jsp:param name="acao" value="${pageContext.request.contextPath}/ManVenda?action=view&cod=${v.getIdVenda()}" />
						<jsp:param name="tipo" value="primary" />
						<jsp:param name="icone" value="ph ph-magnifying-glass" />
					</jsp:include>
				</div>
			</div>
		</div>
    </c:forEach>
</div>