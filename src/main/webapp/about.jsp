<%@page import="jakarta.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> About Page</title>
</head>
<body>

	<%
	HttpSession httpSession = request.getSession();
	String email = (String) httpSession.getAttribute("userEmail");

	if (email != null) {
	%>

	<h5>About Page</h5>
	
	<a href="logoutUser"> LogoutUser </a>

	<%
	} else {

	request.setAttribute("msg", "Your session is expired !!! ");
	request.getRequestDispatcher("login.jsp").forward(request, response);

	}
	%>

</body>
</html>