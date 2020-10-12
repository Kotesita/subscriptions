<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
  <link href="css/registro.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="container">
	<h1 class="text-center"><u>Welcome  <c:out value="${user.name}"/>!</u></h1>
	<a class="btn btn-primary" href="/logout">Logout</a>
	
	<br/>
	<h2>Your current package: </h2> 
	<h2>Package cost: </h2> 
	
	
</div>
</body>
</html>