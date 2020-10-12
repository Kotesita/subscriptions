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
	<h1 class="text-center">Admin Dashboard</h1>
	
	<h2>Customers</h2>
	
	<table class="table">
    <thead>
        <tr>
            <th class="h4">Name</th>
            <th class="h4">Next Due Date</th>
            <th class="h4">Amount Due</th>
            <th class="h4">Package Type</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${user}" var="user">
        <tr>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.createdAt}"/></td>
            <td></td>
            <td></td>
        </tr>
        </c:forEach>
    </tbody>
	</table>
	
	<h2>Packages</h2>
	
	<table class="table">
    <thead>
        <tr>
            <th class="h4">Package name</th>
            <th class="h4">Package cost</th>
            <th class="h4">Available</th>
            <th class="h4">Users</th>
            <th class="h4">Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${pack}" var="package">
        <tr>
            <td><c:out value="${package.name}"/></td>
            <td><c:out value="${package.cost}"/></td>
            <td><c:out value="${package.available}"/></td>
            <td></td>
            <td><a href= <c:url value="/pack/${package.id}/edit"/>>edit</a></td> 
        </tr>
        </c:forEach>
    </tbody>
	</table>
	
	<a class="btn btn-primary" href="/pack/new">Create new package</a>
	
</div>
</body>
</html>