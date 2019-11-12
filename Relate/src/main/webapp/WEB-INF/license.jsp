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
	<form:form action="/newLicense" method="post" modelAttribute="license">
    <p>
        <form:label path="person">person</form:label>
        <form:select path="person">
        <c:forEach items="${users}" var="user">
        	<form:option value="${user.id}">${user.firstName} ${user.lastName}</form:option>
        </c:forEach>
        </form:select>
    </p>
    <p>
        <form:label path="state">state</form:label>
        <form:errors path="state"/>
        <form:input type="text" path="state"/>
    </p>
    <p>
    <form:label path="expirationDate">Expiration Date: 
		<form:errors path="expirationDate"/>
		<form:input type="date" path="expirationDate"/>
	</form:label>  
	</p>
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>