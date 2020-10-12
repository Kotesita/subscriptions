<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit package</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>

	<h1>Package: </h1> ${pack.name}
    
    <p><form:errors path="pack.*"/></p>
    
    <form:form method="POST" action="/pack/${pack.id}/edit/" modelAttribute="pack">
         <p>
            <form:label path="cost">Cost:</form:label>
            <form:input class="form-control" type="text" path="cost"/>
        </p>
        <input class="btn btn-primary" type="submit" value="Edit"/>
		<a href="/pack/${pack.id}/delete">Delete</a>
        
    </form:form>  
</body>
</html>