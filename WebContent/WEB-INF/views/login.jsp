 <%@page import="com.pojo.ActionMsg"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.pojo.ActionMsgs"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>

<link rel="stylesheet" href="https://bootswatch.com/4/slate/bootstrap.min.css">

</head>
<%
	ActionMsgs errors = (ActionMsgs) request.getAttribute("errors");
%>
<body>
<div class="container">


<div class="card border-success mt-5 p-2 mx-auto" style="max-width: 400px">
  <div class="card-header"><h1>Please Login Here</h1></div>
  <div class="card-body p-5 m-3">
    <form method="post" action="checklogin">
	<input type="hidden" name="formid" value="login">
	
		Username: <input class="form-control form-control-sm mt-1" type="text" name="uname" placeholder="username"  required><br>
		Password: <input class="form-control form-control-sm mt-1" type="password" name="upass" placeholder="password" required><br>
		
		<input type="submit" value="login.." class="btn btn-danger m-1">
	    
	</form>
	<a href="register"><button class="btn btn-success ">Register</button></a>
	 <a href="adminregister"><button class="btn btn-info">Admin-Register</button></a><br>
    
    
  </div>
  
  <%

if(errors!=null){
	Iterator<ActionMsg> iter = errors.getErrors().iterator();
	while(iter.hasNext()){
		
%>		
		<p class="badge badge-danger">  <%=iter.next().getMsg()%> <p>
<%	} 
 }
%>
</div>





	
</div>

</body>
</html>