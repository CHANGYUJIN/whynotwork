<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="liststyle.css">
</head>
<body>
<form:form commandName="boardVO" method="POST" action="../editok">
	<form:hidden path="seq"/>
	<table id="edit">
		<tr><td>Title:</td><td><form:input path="title"/></td></tr>
		<tr><td>Category:</td><td><form:input path="category"/></td></tr>
		<tr><td>Writer:</td><td><form:input path="writer" /></td></tr>
		<tr><td>Content:</td><td><form:textarea cols="50" rows="5" path="content" /></td></tr>
	</table>
	<input type="submit" value="edit"/>
	<input type="button" value="Cancel" onclick="history.back()"/>
</form:form>
</body>
</html>