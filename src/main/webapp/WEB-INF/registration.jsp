<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Registration Page</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
 
</head>
<body>
 
    
    <p><form:errors path="user.*"/></p>
    <div class="container"> 
    <div class="row">
    <div class="col-6">
    <h1  class="text-center">Register!</h1>
    <form:form method="POST" action="/registration" modelAttribute="user">
     <p>
            <form:label path="name">Name:</form:label>
            <form:input class="form-control" type="text" path="name"/>
        </p>
        <p>
            <form:label path="email">Email:</form:label>
            <form:input class="form-control" type="email" path="email"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password class="form-control" path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password class="form-control" path="passwordConfirmation"/>
        </p>
        <input class="btn btn-primary" type="submit" value="Register!"/>
    </form:form>
      </div>
    
    <div class="col-6">
     <h1  class="text-center">Login</h1>
    <p><c:out value="${error}" /></p>
    <form  method="POST" action="/loginUser">
        <p>
            <label for="email">Email</label>
            <input class="form-control" type="text" id="email" name="email"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input class="form-control" type="password" id="password" name="password"/>
        </p>
        <input class="btn btn-primary" type="submit" value="Login!"/>
    </form>  
    </div>  
    </div>
    </div>
</body>
</html>