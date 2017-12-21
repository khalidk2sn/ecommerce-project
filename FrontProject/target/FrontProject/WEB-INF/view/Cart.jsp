<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@include file="Header.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>

<div class="space"></div>
<div class="container">
	<h2 class="heading-one">Cart</h2>
	<c:if test="${not empty success }">
		<div class="alert alert-success">${success }</div>
	</c:if>
	<c:if test="${empty cartList }">
		<div class="alert alert-warning">You have not added any product
			into cart.</div>
	</c:if>
	<c:if test="${not empty error }">
		<div class="alert alert-danger">${error }</div>
	</c:if>
	<c:if test="${not empty cartList}">
		<table class="table table-bordered">
			<tr>
				<th>Product Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th width="135">Action</th>
			</tr>
			<c:forEach items="${cartList}" var="cart">
				<tr>
					<td>${cart.productName}</td>
					<td>${cart.price}</td>
					<td>${cart.quantity}</td>
					<td><a href="${pageContext.request.contextPath}/removeCart/${cart.id}" class="btn btn-danger">Remove</a></td>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<div class="pull-right">
			Total Amount: <em><b class="text-success">Rs ${totalAmount}</b></em>
			&nbsp; <a href="${pageContext.request.contextPath}/Ord"
				class="btn btn-outline-primary">Checkout</a>
		</div>
		<a href="<c:url value='/clearCart' />"
			class="btn btn-outline-danger">Clear Cart</a>
	</c:if>
</div>

</body>
</html>
<%@include file="Footer.jsp"%>