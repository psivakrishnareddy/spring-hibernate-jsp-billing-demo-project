<%@page import="com.billingdemo.pojo.ActionMsg"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.billingdemo.pojo.ActionMsgs"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ADMIN | Add Items</title>
<link rel="stylesheet" href="https://bootswatch.com/4/slate/bootstrap.min.css">
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary d-flex justify-content-between">
  <a class="navbar-brand" href="#">Online Store</a>
 <div >
    
   <a href="<c:url value='/logout' />"><button class="btn btn-danger">LOGOUT</button></a>
    
  </div>
</nav>


<a href="<c:url value='/admin' />"><button class="badge badge-pill badge-info mt-3 ml-3">< Go Back</button></a>
<hr>
<br>

<div class="container">
<h1 class="text-white">Add ITems toInventory</h1>
<div class="card text-white bg-primary mb-3 p-2" >
<form action="add" method="post" enctype="multipart/form-data">
<input type="hidden" name="formid" value="additem">

<c:if test="${message!=null}">
<div class="alert  alert-success" id="ismsg">
<c:out value="${message}"/>
  </div>
</c:if>

<!-- ITEM NO:<input type="number" name="itemno" class="form-control" required><br><br> -->
ITEM NAME: <input type="text" name="itemname" class="form-control" required><br><br>
ITEM UNIT: <input type="text" name="itemunit" class="form-control" required><br><br>
ITEM PRICE: <input type="text" name="itemprice" class="form-control" required><br><br>

<!-- SHOPID : <select name="itemshopid">
   <option value="110"> Ration Shop</option>
     <option value="111">Snacks Shop</option> 
     <option value="112"> Stationay shop</option>    
     
   </select><br><br> -->
   
       <div class="form-group">
      <label for="shopSelect">SHOP NO:</label>
      <select class="form-control" id="shopSelect" name="itemshopid">
        <option value="110"> Ration Shop</option>
     <option value="111">Snacks Shop</option> 
     <option value="112"> Stationay shop</option> 
      </select>
    </div>
   
   
   <input type="file" name="fileUpload" size="50" class="form-control-file" /><br><br>
<input type="submit" value="Add Item" class="btn btn-secondary"><br>
</form>
</div>

<br>

</div>
<script>
	setTimeout(function() {
		document.getElementById("ismsg").style.display="none";
	}, 1000)
        
    </script>
</body>
</html>