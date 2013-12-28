<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<html>
<head>

<!--META-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="index.header" /></title>

<!--STYLESHEETS-->
<link
	href="${pageContext.request.contextPath}/resources/css/login_style.css"
	rel="stylesheet" type="text/css" />

<!--SCRIPTS-->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<!--Slider-in icons-->
<script type="text/javascript">
	$(document).ready(function() {
		$(".username").focus(function() {
			$(".user-icon").css("left", "-48px");
		});
		$(".username").blur(function() {
			$(".user-icon").css("left", "0px");
		});

		$(".password").focus(function() {
			$(".pass-icon").css("left", "-48px");
		});
		$(".password").blur(function() {
			$(".pass-icon").css("left", "0px");
		});
	});
</script>

</head>
<body>

	<!--WRAPPER-->
	<div id="wrapper">

		<!--SLIDE-IN ICONS-->
		<div class="user-icon"></div>
		<div class="pass-icon"></div>
		<!--END SLIDE-IN ICONS-->

		<!--LOGIN FORM-->

		<form name="login-form" class="login-form"
			action='<c:url value='/j_spring_security_check'/>' method="post">

			<!--HEADER-->
			<div class="header">
				<h1>
					<a href="http://www.sqli.com/"> <img
						src="${pageContext.request.contextPath}/resources/images/logo.png"
						align="right" alt="SQLI Group" />
					</a>
				</h1>
				<!--TITLE-->
				<h1>Login</h1>
				<!--END TITLE-->
				<c:choose>
					<c:when test='${not empty param.error}'>
						<span> <font color='red'> Login Error
						</font>
						</span>
					</c:when>
					<c:otherwise>
						<span><spring:message code="index.pleaselogin"></spring:message>
							:</span>
					</c:otherwise>
				</c:choose>
			</div>

			<!--END HEADER-->

			<!--CONTENT-->
			<div class="content">
				<!--USERNAME-->
				<input name="j_username" type="text" class="input username"
					value="Username" onfocus="this.value=''" />
				<!--END USERNAME-->
				<!--PASSWORD-->
				<input name="j_password" type="password" class="input password"
					value="Password" onfocus="this.value=''" />
				<!--END PASSWORD-->
				<br>
				<br> <span class="rememberme">Remember me</span> <input
					type="checkbox" name="_spring_security_remember_me">
				<!--END CONTENT-->
			</div>
			<!--FOOTER-->
			<div class="footer">
				<!--LOGIN BUTTON-->
				<input type="submit" name="submit" value="Login" class="button" />
				<!--END LOGIN BUTTON-->
				<!--REGISTER BUTTON<input type="submit" name="submit" value="Register" class="register" /><!--END REGISTER BUTTON-->
			</div>
			<!--END FOOTER-->

		</form>
		<!--END LOGIN FORM-->

	</div>
	<!--END WRAPPER-->

	<!--GRADIENT-->
	<div class="gradient"></div>
	<!--END GRADIENT-->
	<section class="about">
		<p class="about-author">
			&copy; 2013&ndash;2014 <a href="http://www.sqli.com/">SQLI Group
				- Rabat</a><br> Devoleped by NAJAH Mustapha & OUAFTOUH Yasser
		</p>
	</section>

</body>
</html>