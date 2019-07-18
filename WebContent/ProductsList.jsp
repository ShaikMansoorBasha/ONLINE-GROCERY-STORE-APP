<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ page import = "java.io.*" %>
 <%@ page import = "java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="HandheldFriendly" content="true">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyShop Online Grocery System</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/myshopjs.js" type="text/javascript"></script>
</head>
<body>
<%@include file="Header.jsp" %>
<%@include file="Header1.jsp" %>
<jsp:include page ="sidenav.jsp"/>
	<div class=prodcontainer>
	<div class="row">
 <br>
 <c:if test="${empty productsList}">
  <br> No Products found...
 </c:if>
 
 
  <c:forEach items="${productsList}" var="productsList">
   <div class="gallery">
   <a href="ProductDetailsServlet?ProductName=${productsList.getProductName()}">
          <img src="${productsList.getProductImageURL()}" width="250" height="250"/> 
        <div class="desc">${productsList.getProductName()}</div> </a> 
       
        
        
    </div>   
  
  </c:forEach> 
  <br>
  <br>
  <br> 
</div></div>
<%@include file="Footer.jsp" %>
</body>
</html>