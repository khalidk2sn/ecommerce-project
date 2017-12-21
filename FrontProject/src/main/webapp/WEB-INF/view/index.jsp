<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Header.jsp"%>


<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}
</style>

<title>Shopshop</title>
</head>

<body>

	<div class="container-fluid">
		<br>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="resources/images/Carosel/CaroselLaptop.jpg" alt="..."
						width="460" height="345">
				</div>

				<div class="item">
					<img src="resources/images/Carosel/Headphone.jpg" alt="..."
						width="460" height="345">
				</div>

				<div class="item">
					<img src="resources/images/Carosel/Samsung.jpg" alt="..."
						width="460" height="345">
				</div>

				<div class="item">
					<img src="resources/images/Carosel/CaroselLaptop2.jpg" alt="..."
						width="460" height="345">
				</div>

				<div class="item">
					<img src="resources/images/Carosel/phones.jpg" alt="..."
						width="460" height="345">
				</div>

			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>














	<div class="container-fluid" align="center">
		<div class="row grid-divider">

			<div class="col-sm-4">
				<div class="col-padding">
					<h3>Laptop</h3>
					<img src="resources/images/Carosel/Laptop 1.jpg" alt="Dell Laptop"
						style="width: 100px; height: 100px;">
					<p>Dell Laptop</p>
				</div>
			</div>

			<div class="col-sm-4">
				<div class="col-padding">
					<h3>Data Storage</h3>
					<img src="resources/images/Carosel/PenDrive2.jpg"
						alt="SanDisk PenDrive" style="width: 100px; height: 100px;">
					<p>SanDisk, 16GB USB 2.0 Pen Drive</p>
				</div>
			</div>

			<div class="col-sm-4">
				<div class="col-padding">
					<h3>Phone</h3>
					<img src="resources/images/Carosel/Redmi.jpg" alt="Redmi"
						style="width: 50px; height: 100px;">
					<p>Redmi 4A (Gold, 16GB)</p>
				</div>
			</div>
		</div>



	</div>





</body>
</html>
<%@ include file="Footer.jsp"%>