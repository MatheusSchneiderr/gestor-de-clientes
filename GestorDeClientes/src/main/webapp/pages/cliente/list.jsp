<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Clientes</h2>
<table border="1">
    <tr><th>ID</th><th>Nome</th><th>Email</th></tr>
    <c:forEach var="c" items="${clientes}">
        <tr>
            <td>${c.codigo}</td>
            <td>${c.nome}</td>
            <td>${c.email}</td>
        </tr>
    </c:forEach>
</table>