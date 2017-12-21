<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order</title>
</head>
<body>
<div class="space"></div>
<div class="container">
	<h2 class="heading-one">Manage Orders</h2>
	<c:if test="${empty orderList }">
		<div class="alert alert-warning">No data available in database</div>
	</c:if>
	<c:if test="${not empty error }">
		<div class="alert alert-danger">${error }</div>
	</c:if>
	<c:if test="${not empty success }">
		<div class="alert alert-success">${success }</div>
	</c:if>
	<c:if test="${not empty orderList}">
		<table class="table table-bordered">
			<tr>
				<th>Order ID</th>
				<th>Customer Name</th>
				<th>Status</th>
				<th width="270">Change Status</th>
			</tr>
			<c:forEach items="${orderList}" var="order">
				<tr>
					<td>${order.id}</td>
					<td>${order.customer.name}</td>
					<td>${order.orderStatus }</td>
					<td>
						<form class="form-inline"
							action="<c:url value="/admin/changeOrderStatus/${order.id}?${_csrf.parameterName}=${_csrf.token}" />"
							method="POST">
							<select class="custom-select" name="status" required="true">
								<option value="">Select</option>
								<option value="Dispatched">Dispatched</option>
								<option value="Canceled">Canceled</option>
								<option value="Completed">Completed</option>
							</select>&nbsp;
							<button type="submit" class="btn btn-primary">Go!</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</div>
</body>
</html>

<%@include file="Footer.jsp"%>