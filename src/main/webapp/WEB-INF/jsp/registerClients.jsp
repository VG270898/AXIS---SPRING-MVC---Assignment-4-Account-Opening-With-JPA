<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>

    <c:choose>
    <c:when test="${mode=='MODE_HOME'}">
    <h1> This is Home Page </h1>

    </c:when>
    </c:choose>

	<form action="register" method="POST">
	<label>Enter Client Name:</label><input type="text" id="cname" name="cname" value="${client.clientName}"><br>
	<label>Enter Client Mobile:</label><input type="text" id="cmobile" name="cmobile" value="${client.clientMobile}"><br>
	<label>Enter Client Age:</label><input type="text" id="cage" name="cage" value="${client.clientAge}"><br>
	<input type="submit" value="Register">
	</form>


</body>
</html>