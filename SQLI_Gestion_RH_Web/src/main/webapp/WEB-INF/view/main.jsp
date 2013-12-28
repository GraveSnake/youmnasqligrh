<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta charset="utf-8" />
<script src="http://code.jquery.com/jquery-1.4.min.js" type="text/javascript"></script>
<script type="text/javascript">
function load(jsp_path) {
    $("#bodydiv").load(jsp_path);
}
</script>

<title><spring:message code="menu.home"/></title>
<link href="${pageContext.request.contextPath}/resources/css/main_style.css" rel="stylesheet" />

</head>
<body>
<nav>
	<ul>
		<li><a href="#" onclick="load('home')"><spring:message code="menu.home"/></a></li>
		<sec:authorize ifAllGranted='ROLE_ADMIN'>
		<li><a href="#" onclick="load('managers')"><spring:message code="menu.man"/></a></li>
		</sec:authorize>
		<li><a href="#" onclick="load('collaborators')"><spring:message code="menu.collaborators"/></a></li>
		<li><a href="#" onclick="load('reporting')"><spring:message code="menu.report"/></a></li>
		<sec:authorize ifAllGranted='ROLE_ADMIN'>
		<li><a href="#" onclick="load('administration')"><spring:message code="menu.admin"/></a></li>
		</sec:authorize>
		<li><a href="#" onclick="load('account')"><spring:message code="menu.account"/></a></li>
	</ul>
</nav>

<div id="bodydiv">
	<%@include file="home.jsp" %>
</div>

</body>
</html>