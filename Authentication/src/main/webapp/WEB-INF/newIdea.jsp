<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New Idea</h1>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ page isErrorPage="true" %>    
	<form:form action="/newIdea" method="post" modelAttribute="obj">
    <p>
        <form:label path="idea">idea</form:label>
        <form:errors path="idea"/>
        <form:input type="text" path="idea"/>
    </p>
    <form:input type="hidden" path="user" value="${user.id}"/>
  
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>