<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ page isErrorPage="true" %>    
<h1>New Ninja</h1>
	<form:form action="/newNinja" method="post" modelAttribute="ninja">
    <p>
        <form:label path="dojo">person</form:label>
        <form:select path="dojo">
        <c:forEach items="${dojos}" var="dojo">
        	<form:option value="${dojo.id}">${dojo.name}</form:option>
        </c:forEach>
        </form:select>
    </p>
    <p>
        <form:label path="firstName">first name</form:label>
        <form:errors path="firstName"/>
        <form:input type="text" path="firstName"/>
    </p>
    <p>
    <form:label path="lastName">last name</form:label> 
		<form:errors path="lastName"/>
		<form:input type="text" path="lastName"/>
	</p>
	    <p>
        <form:label path="age">age</form:label>
        <form:errors path="age"/>
        <form:input type="number" path="age"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>