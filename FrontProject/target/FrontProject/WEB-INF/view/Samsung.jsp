<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="pc"%>

<%@include file="Header.jsp"%>

<pc:url value="/resources/images/" var="image"/>
 

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
	
	
	

<title>${productData.productname} Phone</title>



</head>
<body>
	
	<div class="container">
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">
						
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="${image}/${productData.productId}.jpg"  alt="${productData.productname}" /></div>
					</div>
					</div>
					<div class="details col-md-6">
						<h3 class="product-title">${productData.productname}</h3>
						<p class="product-description">${productData.productdescriptionfield1}</p>
						<h4 class="price">current price: <i class="fa fa-rupee"> ${productData.productprice}</i></h4>
						<p class="vote"><strong>Many</strong> of buyers enjoyed this product!</p>
						
						<div class="action">
						 <a href='<pc:url value="/addCart/${productData.productId}"/>'>Add To Cart </a>
						</div>
				</div>
				<table>
		      <div style="width:100%;border-top:1px solid silver">
                        <p style="padding:50px;">
                            <small>
				        Many Users already Buy.  ${productData.productname}		
						    </small>
                        </p>
                        
                        <ul>
                            <li>${productData.productdescriptionfield1}</li>
                            <li>${productData.productdescriptionfield2}</li>
                            <li>${productData.productdescriptionfield3}</li>
                        </ul>  
                       
                    </div>
                    </table>
                </div>
		</div>
	</div>
	</div>
</body>
</html>