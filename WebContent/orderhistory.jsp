<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="HandheldFriendly" content="true">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyShop Online Grocery System</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/styleone.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="js/myshopjs.js" type="text/javascript"></script>
</head>
<body>
	<%@include file="Header.jsp"%>
	<%@include file="Header1.jsp"%>
	<jsp:include page ="sidenav.jsp"/>

<!--  <table cellpadding="2" cellspacing="2" border="1" align="center" >
	  
 <tr>
 <th>Image</th>
    <th>Name</th>
    <th>ProductPrice</th>
    <th>Quantity</th>
    <th>Total_price</th>
    <th>Remove</th>
  </tr>   -->
	<c:if test="${empty CartDeatils}">
		<p><center>No Order History Available </center>
		</p>
		
	</c:if>
 
	<!--  <table cellpadding="2" cellspacing="2" border="1" align="center" >
	  
 <tr>
 <th>Image</th>
    <th>Name</th>
    <th>ProductPrice</th>
    <th>Quantity</th>
    <th>Total_price</th>
    <th>Remove</th>
  </tr>   -->

    <%-- <c:set var="s" value="${0}" ></c:set>
	<c:forEach items="${CartDeatils}" var="CartDeatils">
	<c:set var="s" value="${s+ CartDeatils.getTotal_price()}"></c:set>
 
			<tr>
				<td><img  width="100" height="80" src="${CartDeatils.getProductImageURL()}"/></td>
                <td>${CartDeatils.getProductName()}</td>
				<td>${CartDeatils.getProductPrice()}</td>
				<td>${CartDeatils.getQuantity()}</td>
				<td>${CartDeatils.getTotal_price()}</td>
				<td><a href="DeleteProductServlet?ProductName=${CartDeatils.getProductName()}">
			    <button type="button">DeleteProduct</button>
				</a></td>
		  </tr>
				
   </c:forEach>
				<tr>
				      <td colspan="5" align="right">Sum</td>
				      <td>${s}</td>
				</tr>
			<!-- </table> -->
		<!-- 	<div class="checkoutrow ">
			
		         <tr class="checkoutrow" > -->
		          <td colspan="5"  align="left" >
			                               
		                                  <a href="http://localhost:8080/ongs/index.jsp">Continue Shopping</a> 
		                                  </td>
			                              <td colspan="5"  align="right" >
			                               
			                                <a href="CheckoutServlet">
	                                       <button id="submitbtn">Checkout Now!</button>
	                                      
			                               </a></td>
		      <!--   </tr> 
		
		</div> -->
		</table> --%>
<%@include file="Footer.jsp"%>
</body>
</html>