<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="https://bootswatch.com/4/slate/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary d-flex justify-content-between">
  <a class="navbar-brand" href="#">Online Store</a>
 <div >
    
   <a href="<c:url value='/logout' />"><button class="btn btn-danger">LOGOUT</button></a>
    
  </div>
</nav>
<a href="<c:url value='/admin' />"><button class="badge badge-pill badge-info"> Go Back</button></a>
<hr>
<br>
<div class="container">
<h1>Click Here For generating Reports</h1>
<form action="admin/reports/dates" method="post">
	<input type="hidden" name="formid" value="report">
	<input type="date" name="fromdate" placeholder="from" required> TO 
	<input type="date" name="todate" placeholder="to" required>
	<input type="submit" value="Generate" class="btn btn-warning">
	</form>
</div>
</body>
</html>