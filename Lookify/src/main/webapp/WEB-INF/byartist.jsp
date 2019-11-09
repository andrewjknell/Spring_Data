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
<h1>Songs by </h1>
	<c:forEach items="${songsby}" var="song">
	<h3>Song name: ${song.name}</h3>
	<p>Artist: ${song.artist}</p>
	</c:forEach>
</body>
</html>