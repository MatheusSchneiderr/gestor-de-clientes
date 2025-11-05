<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Selecione um modulo</h2>
<div>
    <label>Cliente:</label><br>
    <a href="<c:url value='/ManCliente'><c:param name='action' value='form'/></c:url>">Cadastro</a><br><br>
    <a href="<c:url value='/ManCliente'><c:param name='action' value='list'/></c:url>">Consulta</a><br><br>
</div>