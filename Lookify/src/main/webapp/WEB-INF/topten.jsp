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
<a href="/show">show</a>
	<c:forEach items="${sorted}" var="song">
	<h3>Song name: ${song.name}</h3>
	<p>Rating: ${song.rating}</p>
	</c:forEach>
</body>
</html>