<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Hello"method="POST">
		First Name: <input type="text" name="first_name"><br/>
		Last Name: <input type="text" name="last_name"/><br/>

		<input type="checkbox" name="subject" value="maths" checked="checked"/> Maths
		<input type="checkbox" name="subject" value="physics"/> Physics
		<input type="checkbox" name="subject" value="chemistry" checked="checked"/>Chemistry
		
		<input type="submit"value="Submit"/>
	</form>
	
	<form action="main.jsp"method="GET">
	<input type="submit" value="get test"/>
	</form>
</body>
</html>