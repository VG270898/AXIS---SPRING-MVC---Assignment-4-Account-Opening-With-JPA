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
				<th>Account No</th>
				<th>Opening Date</th>
				<th>Account Type</th>
				<th>Client Id</th>
			</tr>
		</thead>
		<tbody style="border: solid 1px black">
			<c:forEach items="${list}" var="e">
				<tr>
					<td>${e.accountNo}</td>
					<td>${e.openingDate}</td>
					<td>${e.accountType}</td>
					<td>${e.clientId}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>