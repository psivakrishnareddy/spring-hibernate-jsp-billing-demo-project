<%@page import="com.billingdemo.pojo.ActionMsg"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.billingdemo.pojo.ActionMsgs"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>RegisterPage</title>
<link rel="stylesheet" href="https://bootswatch.com/4/slate/bootstrap.min.css">
</head>
<%
	ActionMsgs errors = (ActionMsgs) request.getAttribute("errors");
%>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary d-flex justify-content-between">
  <a class="navbar-brand" href="#">Online Store</a>
</nav>
<a href="<c:url value="/login"/>"><button class="badge badge-info m-2 p-1">Back</button></a>
<hr>
<div class="container ">
<div class="card border-success mt-5 p-2 mx-auto" style="max-width: 400px">
  <div class="card-header"><h1>Register page...</h1></div>
  <div class="card-body p-5 m-3">
  <form method="post" action="register/user">
	<input type="hidden" name="formid" value="register">
	
		UserName:<input type="text" name="uname" placeholder="username" class="form-control form-control-sm mt-1" required><br>
		PassWord:<input type="password" name="upass" placeholder="password" class="form-control form-control-sm mt-1" required><br>
		User city: <input type="text" name="ucity" placeholder="city" class="form-control form-control-sm mt-1" required><br>
		<input type="submit" value="Signup" class="btn btn-info mt-2">
	
	</form>
		<%

if(errors!=null){
	Iterator<ActionMsg> iter = errors.getErrors().iterator();
	while(iter.hasNext()){
		
%>		
		<p class="badge badge-danger">  <%=iter.next().getMsg()%> <p>
<%	} 
 }
%>
  </div></div>


<!-- <h1>Register page...</h1>
	<h2>Customer Registration.....</h2>
		<form method="post" action="register/user">
	<input type="hidden" name="formid" value="register">
	
		UserName:<input type="text" name="uname" placeholder="username" class="form-control-sm mt-1" required><br>
		PassWord:<input type="password" name="upass" placeholder="password" class="form-control-sm mt-1" required><br>
		User city: <input type="text" name="ucity" placeholder="city" class="form-control-sm mt-1" required><br>
		<input type="submit" value="Signup" class="btn btn-success mt-2">
	
	</form><br> -->

</div>	
</body>
</html>