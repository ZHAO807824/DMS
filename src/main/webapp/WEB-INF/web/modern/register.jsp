<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DMS</title>
<link rel="shortcut icon" type="image/x-icon" href="${ctx}/common/images/favicon.ico"/>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="${ctx}/modern/css/bootstrap.min.css" rel='stylesheet' type='text/css'/>
<!-- Custom CSS -->
<link href="${ctx}/modern/css/style.css" rel='stylesheet' type='text/css'/>
<link href="${ctx}/modern/css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<script src="${ctx}/modern/js/jquery.min.js"></script>
<script src="${ctx}/modern/js/jquery.validate.min.js"></script>
<!----webfonts--->
<link href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
<!---//webfonts--->
<!-- Bootstrap Core JavaScript -->
<script src="${ctx}/modern/js/bootstrap.min.js"></script>
<!-- 自定义 -->
<script src="${ctx}/modern/custom/login.js"></script>
</head>
<body id="login">
<div class="login-logo">
	<a href="index.html"><img src="${ctx}/modern/images/logo.png" alt=""/></a>
</div>
<h2 class="form-heading">Register</h2>
<form id="registerForm"  class="form-signin app-cam" action="register" method="post">
	<p>
		Enter your personal details below
	</p>
	<input type="text" id="fullName" name="fullName" class="form-control1" placeholder="Full Name" autofocus="">
	<input type="text" id="houseName" name="houseName" class="form-control1" placeholder="House Name" autofocus="">
	<div class="radios">
		<label for="radio-01" class="label_radio">
		<input type="radio" name="gender" checked="" value="0"> Male
		</label>
		<label for="radio-02" class="label_radio">
		<input type="radio" name="gender" value="1"> Female
		</label>
	</div>
	<p>
		 Enter your account details below
	</p>
	<input type="text" id="email" name="email" class="form-control1" placeholder="Email" autofocus="">
	<input type="password" id="password" name="password" class="form-control1" placeholder="Password">
	<input type="password" id="confirmPassword" name="confirmPassword" class="form-control1" placeholder="Re-type Password">
	<label class="checkbox-custom check-success">
	<button class="btn btn-lg btn-success1 btn-block" type="submit">Submit</button>
	<div class="registration">
          Already Registered.
		<a class="" href="${ctx}">
              Login
		</a>
	</div>
</form>
<div class="copy_layout login register">
     Copyright &copy; 2016.Company name All rights reserved.
	<a href="https://github.com/ZHAO807824" target="_blank" title="ZHAO807824">ZHAO807824</a>
</div>

<script type="text/javascript">
	$(function(){
		DmsLogin.Register.init();
	});
</script>
</body>
</html>