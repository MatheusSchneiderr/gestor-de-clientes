<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String textoBotao = request.getParameter("texto");
	String acaoBotao = request.getParameter("acao");
	String tipoBotao = request.getParameter("tipo");
	String icone = request.getParameter("icone");
%>
<head>
	<style>
		button{
			background-color: #23272b !important;
			border: 1px solid #212529 !important;
		}
		button:hover{
			opacity: 70%;
		}
		
	</style>
</head>
<button class="btn btn-<%= tipoBotao%>" onclick="window.location.href='<%= acaoBotao%>'">
    <% if (icone != null && !icone.isEmpty()) { %>
    	<i class="<%= icone%> fw-bold"></i>
    <% } %>
	<b><%= textoBotao%></b>
</button>