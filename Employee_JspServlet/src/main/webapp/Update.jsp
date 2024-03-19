<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Enter the details to update name</h4>

	<form action="update" method="post">
		<label>Enter id</label> <input type="number" name="id"> <label>Enter
			new name</label> <input type="text" name="name">
			<button>submit</button>
	</form>
	
	<%String message=(String)request.getAttribute("message");
	if(message!=null){%>
	<h4><%=message %>
	<%}%>
	
	
	
</body>
</html>