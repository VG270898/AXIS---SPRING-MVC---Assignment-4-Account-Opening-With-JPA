<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BankingSystem-Account</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
   <style>
       body{background-color: wheat;
       }
   </style>
</head>
<body>
    <a href="Home"><button class="btn m-lg-3 btn-dark">Back</button></a>
    <h1 class="row justify-content-center align-items-center" style="margin-top: 3%;">Account Details</h1>


<div class="container-fluid w-50 mt-5">
    <table class="table table-dark table-sm text-center">
        <thead>
            <tr>
				<th>Account No</th>
				<th>Opening Date</th>
				<th>Account Type</th>
				<th>Client Id</th>
            </tr>
        </thead>
        <tbody>
            <tr>
			<c:forEach items="${list}" var="e">
				<tr>
					<td>${e.accountNo}</td>
					<td>${e.openingDate}</td>
					<td>${e.accountType}</td>
					<td>${e.clientId}</td>
				</tr>
			</c:forEach>
            </tr>
        </tbody>
    </table>
</div>

</body>
</html>


