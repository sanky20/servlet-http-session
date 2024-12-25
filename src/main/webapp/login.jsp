<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<style>
  fieldset{
  width: 250px;
  }
</style>
</head>
<body>

	<%
	String msg = (String) request.getAttribute("msg");

	if (msg != null) {
	%>

	<h4 style="color:red;">
		<%=msg%>
	</h4>

	<%
	}
	%>



	<form action="loginUser" method="post">
		<fieldset>
		  <legend align="center">Login Page</legend>
			<label>Email</label> <br> <input type="email"
				placeholder="enter email" name="email"> <br> <label>Password</label>
			<br> <input type="password" placeholder="enter password"
				name="password"> <br> <input type="submit"
				value="login">
		</fieldset>
	</form>

</body>
</html>