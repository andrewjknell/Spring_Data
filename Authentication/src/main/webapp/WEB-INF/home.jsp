<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<link rel="stylesheet" type="text/css" href="css/style.css">

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<h1>Welcome  ${user.firstName}</h1>
	<h2>Ideas</h2>
	<div class="container">
    	<table>
	    	<thead>
		    	<tr>
			    	<th>Ideas</th>
			    	<th>Created By</th>
			    	<th>Likes</th>
			    	<th>Action</th>
		    	</tr>
	    	</thead>
    	<tbody>
	    	<c:forEach items="${ideas}" var = "idea">
	    	<tr>
		    	<td>
		    	<a href="/viewidea/${idea.id}">${idea.idea}</a>
		    	</td>
		    	
		    	<td>${idea.user.firstName }</td>
		    	
		    	<td>
    				<c:if test="${idea.likers.contains(user) == false }">
	    		<td>
	    			<a href="/like/${idea.id }">Like</a>
	    		</td>
    				</c:if>
    				<c:if test="${idea.likers.contains(user) == true }">
	    		<td>
	    			<a href="/unlike/${idea.id }">Unlike</a>
	    		</td>
			    	</c:if>
		    	</td>
		    	

	    	</tr>
	    	</c:forEach>
    	</tbody>
    	</table>  
    	<a href="/addIdea">Post a new idea</a>
    	<a href="/logout">logout</a>
    	
    </div>
   
</body>
</html>