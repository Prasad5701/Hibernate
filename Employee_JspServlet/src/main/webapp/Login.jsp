<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	<% String message=(String)request.getAttribute("message"); 
	if(message!=null){%>
	<h2><%=message%></h2>
	<%} %>
	<form action="login" method="post">
		<fieldset style="width: 300px;">
			<label>Email  </label>
			<input type="text" name="email"><br><br>
			<label>Password</label>
			<input type="password" name="password"><br><br>
			<button>Login</button>
		</fieldset>
	</form>
	<%String invalid= (String)request.getAttribute("invalid");
	if(invalid!=null){
	%>
	<h3><%=invalid %></h3>
	<%} %>
</body>
</html>