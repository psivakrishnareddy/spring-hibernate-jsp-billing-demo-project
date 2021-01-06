<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Reg</title>
<link rel="stylesheet" href="https://bootswatch.com/4/slate/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary d-flex justify-content-between">
  <a class="navbar-brand" href="#">Online Store</a>
</nav>
<a href="<c:url value="/login"/>"><button class="badge badge-pill badge-info m-2 p-1">Back</button></a>
<hr>
<div class="container">

<div class="card border-success mt-5 p-2 mx-auto" style="max-width: 400px">
  <div class="card-header"><h1>Administration Registration.....</h1></div>
  <div class="card-body p-5 m-3">
  
  <form method="post" action="register/admin">
	<input type="hidden" name="formid" value="register">
	
		UserName:<input type="text" name="uname" placeholder="username"  class="form-control form-control-sm mt-1" required><br>
		PassWord:<input type="password" name="upass" placeholder="password" class="form-control form-control-sm mt-1" required><br>
		secret Code:<input type="password" name="secret" placeholder="code" class="form-control form-control-sm mt-1" required><br>
		<input type="submit" value="AdminSignup" class="btn btn-warning mt-2">
	</form>
  </div></div>


<!-- <h1>Register page...</h1>
	<h2>Administration Registration.....</h2>
		<form method="post" action="register/admin">
	<input type="hidden" name="formid" value="register">
	
		UserName:<input type="text" name="uname" placeholder="username"  class="form-control-sm mt-1" required><br>
		PassWord:<input type="password" name="upass" placeholder="password" class="form-control-sm mt-1" required><br>
		secret Code:<input type="text" name="secret" placeholder="code" class="form-control-sm mt-1" required><br>
		<input type="submit" value="Signup" class="btn btn-warning mt-2">
	
	</form> -->
	</div>
	
</body>
</html>