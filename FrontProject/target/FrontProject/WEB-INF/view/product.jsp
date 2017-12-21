<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<%@include file="Header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">

body
	{
	background-image: url("resources/images/ProductBack.jpg");	
    background-size: 150% 720px;
	}

.table
	{
    border: 1px solid black;
    margin-top: 10px;
    margin-bottom: 10px;
    margin-right: 60px;
    margin-left: 8px;
    }
    
</style>

<title>Product</title>
</head>
<body>



	${msg}
<table>
<div class="container">
	<fm:form action="${pageContext.request.contextPath}/addPro"
		commandName="product"  enctype="multipart/form-data" method="post">



	    <div class="row">
		        <div class="form-group">
			<p:if test="${not empty product.productname }">
				<label class="control-label col-sm-3" >	Product Id : </label>
				<div class="col-sm-9">
					<fm:input path="productId" disabled="true" readonly="true" />
					<fm:hidden path="productId" />
			    </div>
			    </p:if>
			     </div>
			    </div>
			

			
				<div class="row">
		    	<div class="form-group">
				<label class="control-label col-sm-3" >Product Name : </label>
				<div class="col-sm-9">
				<fm:input path="productname" />
</div></div></div>

			
				<div class="row">
		    	<div class="form-group">
				<label class="control-label col-sm-3" >Product Decription First : </label>
				<div class="col-sm-9">
				<fm:input path="productdescriptionfield1" />
</div></div></div>

				<div class="row">
		    	<div class="form-group">
				<label class="control-label col-sm-3" >Product Decription Second : </label>
				<div class="col-sm-9">
				<fm:input path="productdescriptionfield2" />
</div></div></div>
			
							<div class="row">
		    	<div class="form-group">
				<label class="control-label col-sm-3" >Product Decription Third : </label>
				<div class="col-sm-9">
				<fm:input path="productdescriptionfield3" />
</div></div></div>
			
		<div class="row">
		    	<div class="form-group">
				<label class="control-label col-sm-3" >Product Price : </label>
				<div class="col-sm-9">
				<fm:input path="productprice" />
</div></div></div>
			
<div class="row">
		    	<div class="form-group">
				<label class="control-label col-sm-3" >Category Id : </label>
		      <select name="categoryId">
		         <p:forEach items="${categoryList}" var="catee">
		            <option value="${catee.categoryId}">${catee.categoryId}</option>
		         </p:forEach>
		      </select>
		</div></div>
		
		    
		    
		    <div class="row">
		    	<div class="form-group">
				<label class="control-label col-sm-3" >Supplier Id : </label>
		        <select name="supplierId">
					<p:forEach items="${supplierList}" var="yup">
						<option value="${yup.supplierId}">${yup.supplierId}</option>
					</p:forEach>
			    </select>
		</div></div>
		
	<label class="control-label col-sm-3" >File upload : </label>
				<fm:input type="file" path="image" />
		        		
			
		
			<p:if test="${empty product.productname }">
        			<button type="submit" class="btn btn-success" value="Add"> Submit </button> 
			</p:if>

				<p:if test="${not empty product.productname }">
					<button type="submit" class="btn btn-primary" value="Update">Update Category</button>
			   <h5><font color="#663300"> You Can Change Only Product Name Or City. </font></h5>
			    </p:if>
			</table>

	</fm:form>
</div>

	<p:if test="${not empty productList}">

		<center>
			<h1>
				<font color="gold">ProductLIST</font>
			</h1>
		</center>

		<table class="table table-hover">

			<thead>
				<tr>
					<th>Product Name</th>
					<th>Product Description First</th>
					<th>Product Description Second</th>
					<th>Product Description Third</th>
					<th>Product Price</th>
					<th>Change</th>
					<th>Delete</th>
                    <th>Image</th>
				</tr>
			</thead>


			<tbody>

				<p:forEach items="${productList}" var="sup">

					<tr>
						<td>${sup.productname}</td>
						<td>${sup.productdescriptionfield1}</td>
						<td>${sup.productdescriptionfield2}</td>
						<td>${sup.productdescriptionfield3}</td>
						<td>${sup.productprice}</td>
						<td><a href="updateProduct/${sup.productId}">Update</a></td>
						<td><a href="deleteProduct/${sup.productId}">Delete</a></td>
						<td><img alt="${sup.productname}" src="resources/images/${sup.productId}.jpg" width="20" height="25"></td>
					</tr>


                </p:forEach>
			
			</tbody>


		</table>

	</p:if>
	
	<%-- <table>
	<p:forEach var="product" items="${productList}">
	
	<img alt="${product.productname}" src="resources/images/${product.productId}.jpg">
	
	</p:forEach>
	
	</table> --%>

</body>
</html>