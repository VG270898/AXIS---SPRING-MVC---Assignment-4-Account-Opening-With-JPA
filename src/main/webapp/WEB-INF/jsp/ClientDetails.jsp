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
	<table style="border: solid 2px red">
		<thead style="border: solid 1px red">
			<tr style="border: solid 1px red">
				<th>Client Id</th>
				<th>Client Name</th>
				<th>Client Mobile</th>
				<th>Client Age</th>
			</tr>
		</thead>
		<tbody style="border: solid 1px black">
			<c:forEach items="${list}" var="e">
				<tr>
					<td>${e.clientId}</td>
					<td>${e.clientName}</td>
					<td>${e.clientMobile}</td>
					<td>${e.clientAge}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>