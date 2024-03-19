<%@page import="jspservlet.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit</h1>
	<%
	Student student = (Student) request.getAttribute("message");
	%>
	<form action="edit" method="post">
		<fieldset>
			<legend>Student Registration Form</legend>
			<label>Id</label> <input type="number" name="id" value=<%=student.getId()%> readonly><br> <br>
			<label>Name</label> <input type="text" name="name" value=<%=student.getName()%>><br>
			<br> <label>Branch</label> <input type="text" name="branch" value=<%=student.getBranch()%>><br>
			<br> <label>Phone</label> <input type="number" name="phone" value=<%=student.getPhone()%>><br>
			<br> <label>Email Id</label> <input type="text" name="email" value=<%=student.getEmail()%>><br>
			<br> <label>Password</label> <input type="password" name="password" value=<%=student.getPassword()%>><br> <br>
			<button>Save Details</button>
		</fieldset>
	</form>



</body>
</html>