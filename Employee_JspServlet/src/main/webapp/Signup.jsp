<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String register = (String) request.getAttribute("register");
	if (register != null) {
	%>
	<h2><%=register%></h2>
	<%
	}
	%>
	<form action="signup" method="post">
		<fieldset>
			<legend>Student Registration Form</legend>
			<label>Id</label> <input type="number" name="id"><br> <br>
			<label>Name</label> <input type="text" name="name"><br>
			<br> <label>Branch</label> <input type="text" name="branch"><br>
			<br> <label>Phone</label> <input type="number" name="phone"><br>
			<br> <label>Email Id</label> <input type="text" name="email"><br>
			<br> <label>Password</label> <input type="password"
				name="password"><br> <br>
			<button>Register</button>
		</fieldset>
	</form>

</body>
</html>