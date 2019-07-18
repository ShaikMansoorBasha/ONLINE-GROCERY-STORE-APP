<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import = "java.io.*" %>
 <%@ page import = "java.util.*"%>

 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="HandheldFriendly" content="true">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyShop Online Grocery System</title>
<link href="css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
<%@include file="Header.jsp" %>
<%@include file="Header1.jsp" %>
<%-- <jsp:include page ="sidenav.jsp"/> --%>
	<br>
	
<div class=prodcontainer>
<div class="row">
	<c:forEach items="${productsCatList}" var="productsCatList">
	
		<div class="gallery">
  			<a href="ProductsListServlet?ProdCat=${productsCatList.getProductCategoryName()}">
    			<img src="${productsCatList.getProductCategoryImageURL()}" alt="${productsCatList.getProductCategoryName()}" width="250" height="250">
  			</a>
  			<div class="desc">${productsCatList.getProductCategoryName()}</div>
  		</div>  	
    	  	
	  		
	</c:forEach>
</div>
</div>


<%@include file="Footer.jsp" %>
</body></html>