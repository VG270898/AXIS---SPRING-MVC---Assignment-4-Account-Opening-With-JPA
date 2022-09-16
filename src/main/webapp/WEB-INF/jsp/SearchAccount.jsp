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

    <h1>Search Account By Id</h1>
	<form action="accountId" method="GET">
	<label>Enter Account No:</label><input type="text" id="accNo" name="accountNo"><br>
	<input type="submit" value="Search">
	</form>


</body>
</html>