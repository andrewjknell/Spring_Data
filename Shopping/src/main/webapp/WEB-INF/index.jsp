<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New Product</h1>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ page isErrorPage="true" %>    
	<form:form action="/newProduct" method="post" modelAttribute="product">
    <p>
        <form:label path="name">name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="description">description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <p>
    	<form:label path="price">price</form:label>
        <form:errors path="price"/>
        <form:input type="number" path="price"/>
    </p>  

    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>