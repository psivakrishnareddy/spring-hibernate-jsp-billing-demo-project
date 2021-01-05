
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
<hr>
	<a href="<c:url value='/shop/shop-110' />"><button class="badge badge-pill badge-danger">Go Back</button></a>
<hr>


<div class="container">
	<h1> Snack SHOP</h1>
	<form action="shop-112" method="post">
<!-- 	<input type="hidden" name="formid" value="shop">
	<input type="hidden" name="shopid" value="shop1"> -->

	
<table id="table-1" class="table table-hover">
	<thead>
		<tr>
			<th>Item No</th>
			<th>Item</th>
			<th>unit</th>
			<th>Price</th>
			<th>Shopid</th>
			<th>Image</th>
			<th>Qty</th>
			<th>Add To cart</th>
		</tr>
	</thead>
	
	<tbody>
	<c:forEach items="${itemsObj}" var="item">
            <tr class="table-secondary">
            <td>${item.itemno}</td>
            <td>${item.itemname}</td>
             <td>${item.unit}</td>
            <td><span class="badge badge-pill badge-success">Rs. ${item.price}</span> </td>
            <td>${item.shopno}</td>
            <td><img src="data:image/jpg;base64,${item.base64Image}" width="100" height="100"></td>
            <td><input type="number" name="${item.itemno}-qty" min="1" max="5" value=1 class="form-control form-control-sm"/></td>
            <td><input type="checkbox" name="${item.itemname}" value="${item.itemno}"></td>
            </tr>
        </c:forEach>
	</tbody>
</table>
		<input type="submit" value="NextShop.." class="btn btn-warning">
	</form></div>
</body>
</html>