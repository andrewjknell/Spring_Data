<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<link rel="stylesheet" type="text/css" href="css/style.css">  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ page isErrorPage="true" %>   
<h1>${product.name}</h1>
<p>
	Categories: 
	<c:forEach items="${product.categories}" var="cat">
	<p>${cat.name}</p>
	</c:forEach>
</p>
<br>
<p>
	<form:form action="/catAddToProduct/${product.id}" method="post" modelAttribute="product">
    <p>
       <form:label path="categories">person</form:label>
       <form:select path="categories">
       <c:forEach items="${categories}" var="cat">
       	<form:option value="${cat.id}">${cat.name}</form:option>
       </c:forEach>
       </form:select>
    </p>
  
    <input type="submit" value="Submit"/>
</form:form> 
</p>
</body>
</html>