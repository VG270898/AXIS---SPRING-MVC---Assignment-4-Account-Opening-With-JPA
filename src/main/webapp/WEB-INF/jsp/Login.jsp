<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Account-Login</title>
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

    <h1 class="row justify-content-center align-items-center" style="margin-top: 2%;">Login Account</h1>

    <div class="container-fluid h-100 mt-5">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3">
                <form method="post">
                    <div class="form-group mb-3">
                        <input class="form-control form-control-lg" placeholder="Client Id" type="text" id="cid" name="clientId">
                    </div>
                    <div class="form-group mb-3">
                        <input class="form-control form-control-lg" placeholder="Password" type="text" id="cpass" name="password">
                    </div>
                    <div class="form-group">
                    <button class="btn btn-primary btn-lg btn-block">Login</button>
                    </div>
                </form>
            </div>
        </div>
        <div>
        <a href="register" class="row justify-content-center align-items-center" style="margin-top: 1%;color:black;font-weight:bold;">New User</a>
        </div>
    </div>


        <div>
        <h4 class="row justify-content-center align-items-center" style="margin-top: 2%;color:blue;">${message}</h4>
        </div>



</body>
</html>