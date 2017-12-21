<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!-- <link href="resources/css/logintest.css" rel="stylesheet"
type="text/css">
<link href="resources/css/bootstrap.min.css" rel="stylesheet"
type="text/css">
<link href="resources/css/bootstrap.css" rel="stylesheet"
type="text/css">
<link href="resources/css/bootstrap.css.map" rel="stylesheet"
type="text/css">
<link href="resources/css/bootstrap.min.css.map" rel="stylesheet"
type="text/css">
<link href="resources/css/bootstrap-theme.css" rel="stylesheet"
type="text/css">
<link href="resources/css/bootstrap-theme.css.map" rel="stylesheet"
type="text/css">
<link href="resources/css/bootstrap-theme.min.css" rel="stylesheet"
type="text/css">
<link href="resources/css/bootstrap-theme.min.css.map" rel="stylesheet"
type="text/css">
<script type="text/javascript" src="resources/js/table.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/Edit.js"></script>
<script type="text/javascript" src="resources/js/Login.js"></script>
<script type="text/javascript" src="resources/js/npm.js"></script -->

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<nav class="navbar" style="background-color:79d4ff;">
		<div class="container-fluid">
			<div class="navbar-header">

				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<p class="navbar navbar-brand">
					<a href="index"><font size="10" color="black">Shopshop</font></a> 
				</p>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"><font size="3.5"
							color="black">SHOP BY<br>category</font><span class="caret"></span></a>

						<ul class="dropdown-menu">

							<li class="active"><c:forEach items="${categoryList}"
									var="cat">
									<a href="ProductByCategory/${cat.categoryId}">${cat.categoryId}<font
										size="3.5" color="black"></font></a>

								</c:forEach></li>

						</ul></li>





				</ul>



				<ul class="nav navbar-nav navbar-right">
					<security:authorize var="loggedIn" access="isAuthenticated()">
						<security:authorize access="hasRole('ROLE_ADMIN')">
						</security:authorize>
						<security:authorize access="hasRole('ROLE_USER')">
						</security:authorize>
					</security:authorize>



					<security:authorize access="hasRole('ROLE_USER')">
					<li style="color: maroon"><font size="2%"><br>Welcome <i>${pageContext.request.userPrincipal.name}</i></font></li>
					
						<li><a href="Cart"><span
								class="glyphicon glyphicon-shopping-cart"></span>CART</a></li>
					</security:authorize>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<li><a
							href="${pageContext.request.contextPath}/admin"><span
								class="glyphicon glyphicon-user"></span>ADMIN</a></li>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>

					</security:authorize>
					<security:authorize access="isAnonymous()">
						<li><a href="${pageContext.request.contextPath}/login"><span
								class="glyphicon glyphicon-log-in"></span><font size="3.5" color="black">
									Log In</font></a></li>
						<li><a href="${pageContext.request.contextPath}/signup"><span
								class="glyphicon glyphicon-user"></span><font size="3.5" color="black">
									Sign Up</font></a></li>
					</security:authorize>
				</ul>




			</div>
		</div>
	</nav>



</body>
</html>