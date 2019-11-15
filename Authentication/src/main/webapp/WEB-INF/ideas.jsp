<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<link rel="stylesheet" type="text/css" href="css/style.css">
<style>
table{
	border: 1px black solid;
	width: 40%;
}
tr, th, td{
	border:1px black solid;
}
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${idea.idea}</h1>
	
	<h3>Created by:  ${idea.user.firstName}</h3>
	
	<h2>Users who liked your post</h2>
	<table>
		<tr>
			<td> Name: </td>
		</tr>
		<c:forEach items="${idea.likers}" var = "user">
		<tr>
			<td>${user.firstName }</td>
		</tr>
		</c:forEach>
	</table>
	
	<c:if test="${idea.user.id == user.id }">
		<a href="edit/${idea.id}">edit</a>
	</c:if>
</body>
</html>