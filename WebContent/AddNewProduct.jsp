<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="HandheldFriendly" content="true">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyShop Online Grocery System</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body >
<%@include file="Header.jsp" %>
<%@include file="Header1.jsp" %>

<h1>Add New Product</h1>
<form action="ProductSaveServlet" method="post">
 <div style="color:red">${Success}</div>   
<table>

<tr><td>Product_Name:</td><td><input type="text" name="productname"/></td></tr>
<tr><td>Manufacturer:</td><td><input type="text" name="manufacturer"/></td></tr>
<tr><td>Product_Image_url:</td><td><input type="text" name="productimageurl"/></td></tr>
<tr><td>Product_Category_ID:</td><td><input type="number" name="productcategoryid"/></td></tr>
<tr><td>Product_price:</td><td><input type="number" name="productprice"/></td></tr>

<tr><td colspan="2"><input type="submit" value="Save Product"/></td></tr>
</table>
</form>

<br/>
<a href="ViewServlet">view Products</a>
<%@include file="Footer.jsp" %>
</body>
</html>