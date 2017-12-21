<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
        
    <%@ include file="Header.jsp" %>
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
    margin:  0 auto;
    background-image: url("resources/images/login/sinli.jpg");
    background-repeat: no-repeat;
    background-size: 100% 720px;
}

.container
{
width: 425px;
height: 350px;
text-align: center;
background-color: rgba(240,248,255, 0.4);
border-radius: 4px;
margin: 0 auto;
margin-top: 150px;
} 

.container img 
{
width: 220px;
height: 220px;
margin-top: -100px;
margin-bottom: 30px;	
}

.container input[type="text"],input[type="password"] 
{
height: 45px;
width: 300px;
font-size: 18px;
margin-bottom: 30px;
margin-top: -20px;
padding-left: 30px;	
padding-right: 60px;
}

.container span
{
font-size: 35px;
color: #778899;
margin-top: -22px;
}

.container button 
{
height: 35px;
margin-top: -20px;
}

.container a 
{
margin-right: 30px;	
}


</style>
<title>Login</title>
</head>

<body>
<%-- ${msg}
 --%>
<div class="container">
<img alt="error" src="resources/images/login/image1.png">
  <fm:form class="form-horizontal" action="login">

    <div class="form-group">
      <label class="control-label col-sm-2" for="username"><span class="glyphicon glyphicon-user"></span></label>
      <div class="col-sm-7">
        <input type="text" class="form-control" id="username" placeholder="Enter Username" name="username" >
      </div>
    </div>

    <div class="form-group">
      <label class="control-label col-sm-2" for="password"><span class="glyphicon glyphicon-briefcase"></span></label>
      <div class="col-sm-7">          
        <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
      </div>
    </div>

    <div class="form-group">        
      <div class="col-sm-offset-4 col-sm-4">
        <button type="submit" class="btn btn-default">Login
        </button>
      </div>
    </div>
    
    <div class="form-group">
    <div class="col-sm-offset-4 col-sm-5">
    <a href="#">Forget Password?</a>
    </div>
    </div>
  
  
  </fm:form>

</div>

</body>
</html>