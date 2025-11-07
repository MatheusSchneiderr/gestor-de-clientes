<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Clientes</h2>
<div class="d-flex flex-column align-items-center">
	<c:forEach var="c" items="${clientes}">
		<div class="card p-3 w-100 mb-3">
			<div class="d-flex justify-content-between align-items-center">
				<div>
					<div class="fw-bold">${c.getNome()}</div>
					<div>${c.getCpf()}</div>
				</div>
				<jsp:include page="/components/botao.jsp">
					<jsp:param name="texto" value="Ver"/>
					<jsp:param name="acao" value="${pageContext.request.contextPath}/ManCliente?action=view&cod=${c.getCodigo()}" />
					<jsp:param name="tipo" value="primary" />
					<jsp:param name="icone" value="ph ph-magnifying-glass" />
				</jsp:include>
			</div>
		</div>
    </c:forEach>
</div>

