<%@page import="com.billingdemo.model.ItemDTO"%>
<%@page import="com.billingdemo.service.ItemServiceImpl"%>
<%@page import="com.billingdemo.service.ItemService"%>
<%@page import="java.util.List"%>

<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ADMIN | Stocks</title>
<link rel="stylesheet" href="https://bootswatch.com/4/slate/bootstrap.min.css">



<style>
.grow ,.animated{ transition: all .2s ease-in-out; }
.grow:hover { transform: scale(1.05); }
.anim {

-webkit-animation: fadeinout .5s ease-in;
    animation: fadeinout .5s ease-in;
}
@-webkit-keyframes fadeinout {

    0% {
      opacity: 0;
    transform: translateY(-10px);
    }

    100% {
      opacity: 1;
       transform: translateY(0);
    }
  }

  @keyframes fadeinout {

    0% {
      opacity: 0;
      transform: translateY(-10px);
    }

    100% {
      opacity: 1;
      transform: translateY(0);
    }
  }



</style>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary d-flex justify-content-between">
  <a class="navbar-brand" href="#">Online Store</a>
 <div >
    
   <a href="<c:url value='/logout' />"><button class="btn btn-danger">LOGOUT</button></a>
    
  </div>
</nav>
<a href="<c:url value='/admin' />"><button class="badge badge-info badge-pill mt-2 ml-2"> Go Back</button></a>
<hr>
<br>
<div class="container">
<h1> available Stocks</h1>


<div class="container-fluid">
	<div class="row">
		 <c:forEach items="${itemsObj}" var="item">
		<div class="col col-md-3 anim">
		 
		 <div class="card mb-3 text-white grow ">
  <h3 class="card-header">${item.itemname}-${item.itemno}</h3>
  <div class="card-body text-center">
    <img src="data:image/jpg;base64,${item.base64Image}" width="100px" height="100px">
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Unit: ${item.unit}</li>
    <li class="list-group-item">Rs. <span class="badge badge-pill badge-success">${item.price}</span></li>
    <li class="list-group-item">ShopNO: ${item.shopno}</li>
  </ul>
  
   <a class="card-footer bg-danger text-center" href="<c:url value='/item/delete-${item.itemno}' />"><h3>DELETE<h3></h3></a>
  
</div>
		  
		</div>
		 </c:forEach>
	</div>
</div>

</div>




<%-- <table id="table-1" class="table table-hover">
	<thead>
		<tr>
			<th>Item No</th>
			<th>Item</th>
			<th>unit</th>
			<th>Price</th>
			<th>Shopid</th>
			<th>IMAGE</th>
			<th>Delete?</th>
		</tr>
	</thead>
	
	<tbody>
	<c:forEach items="${itemsObj}" var="item">
            <tr class="table-light">
            <td>${item.itemno}</td>
            <td>${item.itemname}</td>
             <td>${item.unit}</td>
            <td>${item.price}</td>
            <td>${item.shopno}</td>
            <td><img src="data:image/jpg;base64,${item.base64Image}" width="100" height="100"></td>
            <td><a href="<c:url value='/item/delete-${item.itemno}' />"><button class="badge badge-pill badge-danger">X</button></a></td>
            </tr>
        </c:forEach>
	</tbody>
</table> --%>

</body>
</html>