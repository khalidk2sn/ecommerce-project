

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="Header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	
	<style>
	
	body
	{
	background-image: url("resources/images/CategoryBack.jpg");	
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
	<title>Category</title>
</head>
<body>

	${msg}
	
	<h2> Enter The Product Category Name And Category Description.  </h2>
	 <h5> Automatically category name save as in category id. </h5>
	 
<div class="container">
	<fm:form action="${pageContext.request.contextPath}/addCat" commandName="Category">

		<div class="row">
		    <div class="form-group">
		    <c:if test="${not empty Category.categoryname }">
            <label class="control-label col-sm-3" > Id :</label>
		    <div class="col-sm-9">
            <fm:input path="categoryId" disabled="true" readonly="true" />
            <fm:hidden path="categoryId" />
		    </div>
            </c:if>
	        </div>
        </div>
        
		<div class="row">
			<div class="form-group">
			<label class="control-label col-sm-3" > Name :</label>
			<div class="col-sm-9">
		    <fm:input path="categoryname" placeholder="Enter Name"/>
			</div>
            </div>
            </div>

<div class="row">
            <div class="form-group"><br>
			<label class="control-label col-sm-3"  > Description :</label>
			<div class="col-sm-9">
		    <fm:input path="categorydescription" placeholder="Enter Description"/>
		    </div>
		    </div>
</div>			
			

			<c:if test="${empty Category.categoryname }">
			<button type="submit" class="btn btn-success" value="Add">Submit</button>
		    </c:if>
		
            
            <c:if test="${not empty Category.categoryname }">
            <button type="submit" class="btn btn-primary" value="Update">Update Category</button>
	        <h5><font color="#663300"> You can change only catgeory name or description. </font></h5>
	        </c:if>
        

	</fm:form>
</div>	

	<c:if test="${not empty categoryList}">

		<center>
			<h1>
				<font color="gold">CategoryLIST</font>
			</h1>
		</center>

		<table class="table table-bordered">

			<thead>
				<tr>
					<th>CategoryName</th>
					<th>CategoryDescription</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>


			<tbody>

				<c:forEach items="${categoryList}" var="usr">

					<tr>
						<td>${usr.categoryname}</td>
						<td>${usr.categorydescription}</td>
						<td><a href="updateCategory/${usr.categoryId}">Update</a></td>
						<td><a href="deleteCategory/${usr.categoryId}">Delete</a></td>
					</tr>
		
		    	</c:forEach>
			
			</tbody>

			

		</table>

	</c:if>


</body>
</html>