<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/songs"> back to dash</a>
<h1>name: <c:out value="${song.name}"/></h1>
	
	<p>Artist: <c:out value="${song.artist}"/></p>
	<p>Rating: <c:out value="${song.rating}"/></p>
	
	<a href="/delete/${song.id}">delete</a>
	
</body>
</html>