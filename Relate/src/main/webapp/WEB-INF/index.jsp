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
	<form:form action="/newPerson" method="post" modelAttribute="person">
    <p>
        <form:label path="firstName">first name</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">last name</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>  

    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>