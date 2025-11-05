<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
    <title>My App</title>
    <meta charset="UTF-8">
    <style>
        body { font-family: Arial; margin: 40px; }
        nav {
            background: #f3f3f3; padding: 10px; text-align: right;
            border-radius: 10px;
        }
        main {
            margin: 20px 0; padding: 20px;
            border: 1px solid #ccc; border-radius: 10px;
        }
    </style>
</head>
<body>

<div>
	<jsp:include page="components/navbar.jsp"/> 
</div>

<main>
    <jsp:include page="pages/${pageSafe}.jsp" />
</main>

</body>
</html>