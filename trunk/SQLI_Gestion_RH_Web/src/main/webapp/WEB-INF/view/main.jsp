<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> 
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta charset="utf-8" />
<title>Control Panel</title>
<link href="${pageContext.request.contextPath}/resources/css/main_style.css" rel="stylesheet" />

</head>
<body>
<nav>
	<ul>
		<li><a href="#"><spring:message code="menu.home"/></a></li>
		<li><a href="#"><spring:message code="menu.man"/></a></li>
		<li><a href="#"><spring:message code="menu.collaborators"/></a></li>
		<li><a href="#"><spring:message code="menu.report"/></a></li>
		<li><a href="#"><spring:message code="menu.admin"/></a></li>
		<li><a href="#"><spring:message code="menu.account"/></a></li>
	</ul>
</nav>

<div id="bodydiv">
    <h2>Bienvenue : <sec:authentication property="principal.username"/></h2><br/>
  <sec:authorize ifAllGranted='ROLE_ADMIN'>
    <h3>Admin access !</h3><br/>  
  </sec:authorize>
    <sec:authorize ifAllGranted='ROLE_USER'>  
    <h3>Manager access !</h3><br/>  
  </sec:authorize>
<p>
	<a href="j_spring_security_logout">Logout</a>
</p>
</div>

</body>
</html>