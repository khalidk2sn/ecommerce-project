<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ page isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="pc"%>
<%@include file="Header.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style type="text/css">
img 
{
width: 45%;
height: 40%;
margin: auto;
}
</style>
<title></title>
</head>
<body>
	<pc:url value="/resources/images/" var="image" />
	<center>

		<pc:forEach items="${listCategoryProduct}" var="cp">
			<div class="col-sm-3">
				
				<div class="photo">
					<a href="${pageContext.request.contextPath}/More/${cp.productId}">
						<img class="card-img-top" src="${image}${cp.productId}.jpg"
						alt="${cp.productname}" class="img-responsive" alt="Product Image">
					</a>
				</div>
				<div class="info">
					<div class="row">
						<div class="price-details col-md-6">
							<p class="details">${cp.productdescriptionfield2}  ${cp.productdescriptionfield3} <br> ${cp.productdescriptionfield1}
							</p>
							<h1>${cp.productname}</h1>
							<span class="price-new">Rs.${cp.productprice}</span>
						</div>
					</div>
					<div class="separator clear-left">
						<p class="btn-add">
							<i class="fa fa-shopping-cart"></i> <a
								class="icon-shopping-cart" href='<pc:url value="/addCart/${cp.productId}"/>'
								class="img-responsive" alt="Product Image">Add To Cart </a>
						</p>
					</div>
				</div>

			</div>
		</pc:forEach>
	</center>


</body>
</html>