<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b> First name: </b>
	<% out.println(" " + request.getParameter("first_name")); %>
	<br/>
	<b> Last name: </b>
	<% out.println(" " + request.getParameter("last_name")); %>
</body>
</html>