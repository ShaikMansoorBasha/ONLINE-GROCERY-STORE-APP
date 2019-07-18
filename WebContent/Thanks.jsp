<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="refresh" content="5" >
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
	<div class="jumbotron text-xs-center">
		<center>
		<img src="images/thankyou.jpg" alt="Trulli" width="400" height="222">
		<!-- 	<h1 class="display-3">Thank You!</h1> -->
			<!-- <p class="lead">
				<strong> for your purchase</strong>,Your order has been placed
			</p>


			<p class="lead"> -->
			<%
session.invalidate();
						/* response.setIntHeader("Refresh", 1); */
%>
			<h3>for your purchase</h3>
			<h4>Your order has been placed</h4>
				<a class="btn btn-primary btn-sm" href="index.jsp" role="button">Continue
					to homepage</a>
			</p>
		</center>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>