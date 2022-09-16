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

    <h1>Search Client By Id</h1>
	<form action="clientId" method="GET">
	<label>Enter Client Id:</label><input type="text" id="cid" name="clientId"><br>
	<input type="submit" value="Search">
	</form>


</body>
</html>