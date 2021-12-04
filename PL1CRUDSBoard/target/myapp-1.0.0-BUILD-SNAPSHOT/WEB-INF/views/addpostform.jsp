<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="liststyle.css">
</head>
<body>
<form action="addok" method="post">
	<table id="edit">
		<tr><td>Title:</td><td><input type="text" name="title"/></td></tr>
		<tr><td>Category:</td><td><input type="text" name="category"/></td></tr>
		<tr><td>Writer:</td><td><input type="text" name="writer"/></td></tr>
		<tr><td>Content:</td><td><textarea cols="50" rows="5" name="content"></textarea></td>
	</table>
	<button type="button" onclick="location.href='list'">view list</button>
	<button type="submit">upload</button>
</form>
</body>
</html>