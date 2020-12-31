<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<h1>Report Has Been Generated..</h1>
<p>Please Find File At C:\Excels\file</p>
<a href="<c:url value='/admin' />">Continue</a>
</body>
</html>