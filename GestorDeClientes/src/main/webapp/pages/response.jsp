<%@ page import="jakarta.servlet.http.HttpSession" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HttpSession Session = request.getSession(false);
	String user = (session != null) ?  (String) session.getAttribute("userName") : null;
%>
<!DOCTYPE html>
<html>
<head>
  <title>Response</title>
</head>
<body>
  <h2>Servlet says:</h2>
  <p style="font-size: 20px;">
    <!-- ${greeting} -->
	welcome, <%= user %>!
  </p>
  <a href="home.jsp">Back</a>
</body>
</html>