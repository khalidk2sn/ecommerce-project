<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>


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
	background-image: url("resources/images/SupplierBack.png");	
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


    
.container input
{
height: 40px;
width: 250px;
font-size: 18px;
margin-bottom: 10px;
margin-top: 40px;
padding-left: 20px;	
padding-right: 60px;
}

.container label
{
font-size: 18px;	
margin-top: 45px;
}

.container button 
{
margin-top: 10px;
}

h2 
{
margin-left: 100px;	
}

h5 
{
margin-top: 15px;	
}
    
</style>

</head>

<title> Supplier </title>

<body>


	${msg}

<div class="container">
	<fm:form action="${pageContext.request.contextPath}/addSup"
		commandName="supplier">




			    <div class="row">
		        <div class="form-group">
				<s:if test="${not empty supplier.suppliername }">
				<label class="control-label col-sm-3" > Supplier Id : </label>
				<div class="col-sm-9">
				<fm:input path="supplierId" disabled="true"	readonly="true" />
				<fm:hidden path="supplierId" />
			    </div>
			    </s:if>
			    </div>
			    </div>

                
                
                <div class="row">
		    	<div class="form-group">
				<label class="control-label col-sm-3" >Supplier Name : </label>
				<div class="col-sm-9">
				<fm:input path="suppliername" placeholder="Enter Name"/>
                </div>
                </div>
                </div>

				
				
				<div class="row">
		    	<div class="form-group">
				<label class="control-label col-sm-3" >Supplier City : </label>
				<div class="col-sm-9">
				<fm:input path="suppliercity" placeholder="Enter City"/>
				</div>
                </div>
                </div>
		
				<s:if test="${empty supplier.suppliername }">
  				<button type="submit" class="btn btn-success" value="Add"> Submit </button>
				</s:if>

				<s:if test="${not empty supplier.suppliername }">
				<button type="submit" class="btn btn-primary" value="Update" >Update Category</button>
				<h5><font color="#663300"> You Can Change Only Supplier Name Or City. </font></h5>
			    </s:if>

	</fm:form>
</div>

	<s:if test="${not empty supplierList}">

		<center>
			<h1>
				<font color="gold">SupplierLIST</font>
			</h1>
		</center>

		<table class="table table-hover">

			<thead>
				<tr>
					<th>Supplier Name</th>
					<th>Supplier City</th>
					<th>Change</th>
					<th>Delete</th>
				</tr>
			</thead>


			<tbody>

				<s:forEach items="${supplierList}" var="sup">

					<tr>
						<td>${sup.suppliername}</td>
						<td>${sup.suppliercity}</td>
						<td><a href="updateSupplier/${sup.supplierId}">Update</a></td>
						<td><a href="deleteSupplier/${sup.supplierId}">Delete</a></td>
					</tr>

				</s:forEach>
			</tbody>


		</table>

	</s:if>

</body>
</html>