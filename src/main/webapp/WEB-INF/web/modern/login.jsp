<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DMS</title>
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>

<link rel="shortcut icon" type="image/x-icon" href="${ctx}/common/images/favicon.ico" />
<!-- Bootstrap Core CSS -->
<link href="${ctx}/modern/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="${ctx}/modern/css/style.css" rel='stylesheet' type='text/css' />
<link href="${ctx}/modern/css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<script src="${ctx}/modern/js/jquery.min.js"></script>
<script src="${ctx}/modern/js/jquery.validate.min.js"></script>
<!----webfonts--->
<link href="${ctx}/modern/css/fonts_useso.css" rel='stylesheet' type='text/css' />
<!---//webfonts--->
<!-- Bootstrap Core JavaScript -->
<script src="${ctx}/modern/js/bootstrap.min.js"></script>

<!-- 自定义 -->
<script src="${ctx}/modern/custom/login.js"></script>
</head>
<body id="login">
	<div class="login-logo">
		<a href="index.html"><img src="${ctx}/modern/images/logo.png" alt="" /></a>
	</div>
	<h2 class="form-heading">login</h2>
	<div class="app-cam">
		<form id="form" name="form" action="login" method="post">
			<input type="text" class="text" id="email" name="email" value="E-mail address"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'E-mail address';}">
			<input type="password" value="Password" id="password" name="password" onfocus="this.value = '';">
			<div class="submit">
				<input type="submit"  value="Login">
			</div>
			<div class="login-social-link">
				<a href="index.html" class="facebook"> Facebook </a> <a
					href="index.html" class="twitter"> Twitter </a>
			</div>
			<ul class="new">
				<li class="new_left"><p>
						<a href="#">Forgot Password ?</a>
					</p></li>
				<li class="new_right"><p class="sign">
						New here ?<a href="register.html"> Sign Up</a>
					</p></li>
				<div class="clearfix"></div>
			</ul>
		</form>
	</div>
	<div class="copy_layout login">
		<p>
			Copyright &copy; 2016.Company name All rights reserved.
			<a href="https://github.com/ZHAO807824" target="_blank" title="ZHAO807824">ZHAO807824</a>
		</p>
	</div>
</body>
</html>