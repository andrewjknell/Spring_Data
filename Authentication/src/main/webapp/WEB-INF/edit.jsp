<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<h1>Edit Idea</h1>
<form:form action="/updateidea/${obj.id}" method="post" modelAttribute="obj">
    <p>
        <form:label path="idea">Idea</form:label>
        <form:errors path="idea"/>
        <form:input type="text" path="idea"/>
    </p>
  
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>