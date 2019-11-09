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
<a href="/byartist">Search Artist</a>
<a href="/topten">Top Ten</a>
<a href="/addnew">Add</a>
<h1>Songs</h1>
	<form action="/byartist">
		<input type="text" name="search">
    	<input type="submit">
	</form>
<table>
    <tbody>
    	<tr>
    		<th>Name</th>
    		<th>Rating</th>
    		<th>delete</th>
    		<th>show</th>
    	</tr>
        <c:forEach items="${songs}" var="song">
        <tr>
            <td><c:out value="${song.name}"/></td>
            <td><c:out value="${song.rating}"/></td>
            <td><a href="/delete/${song.id}">delete</a></td> 
            <td><a href="/show/${song.id}">Show</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>