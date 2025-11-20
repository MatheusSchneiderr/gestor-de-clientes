<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
    <title>My App</title>
    <meta charset="UTF-8">
    
	<link 
	  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
	  rel="stylesheet">
	
	<script 
	  src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" >
	</script>
	
	<link
      rel="stylesheet"
      type="text/css"
      href="https://cdn.jsdelivr.net/npm/@phosphor-icons/web@2.1.1/src/regular/style.css"
    />
    <link
      rel="stylesheet"
      type="text/css"
      href="https://cdn.jsdelivr.net/npm/@phosphor-icons/web@2.1.1/src/fill/style.css"
    />
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/styles.css"
    />	
    <style>
        body { font-family: Arial;}
    </style>
</head>
	<body>
		<jsp:include page="components/navbar.jsp"/> 
		<c:set var="pageSafe" value="${(not empty pageSafe) ? pageSafe : 'modules'}"></c:set>
		<div class="container d-flex justify-content-center mt-4 card-container">
		    <jsp:include page="pages/${pageSafe}.jsp" />
		</div>
	
	</body>
</html>