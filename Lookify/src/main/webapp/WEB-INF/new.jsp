<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ page isErrorPage="true" %>    
<a href="/songs"> back to dash</a>
<h1>Add New Song</h1>
<form:form action="/newSong" method="post" modelAttribute="song">
    <p>
        <form:label path="name">name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="artist">artist</form:label>
        <form:errors path="artist"/>
        <form:input path="artist"/>
    </p>  
    <p>
        <form:label path="rating">rating</form:label>
        <form:errors path="rating"/>
        <form:input path="rating"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>