<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta charset="utf-8" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/create_user.js">
	
</script>
<title><spring:message code="menu.home" /></title>
<link
	href="${pageContext.request.contextPath}/resources/css/main_style.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

<link
	href="${pageContext.request.contextPath}/resources/css/createUser_style.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<%@include file="header"%>

	<div id="bodydiv">
		<sec:authorize ifAnyGranted='ROLE_USER,ROLE_ADMIN'>
			<h3>All access !</h3>
			<br />
    Editing Collaborators without 3 persistent fields : salary etc ...
  </sec:authorize>
		<br />
		<sec:authorize ifAllGranted='ROLE_ADMIN'>
			<c:choose>
				<c:when test="${VIEW=='show'}">
					<h2>Datatable view</h2>
					<%@include file="showCollab.jsp"%><br />
					<input type="button" value="add new collab"
						onclick="go('newColaborateur');" />
				</c:when>
				<c:when test="${VIEW=='new'}">
					<h2>Add new collaborateur</h2>
					<%@include file="newCollab.jsp"%><br />
					<input type="button" value="edit new collab"
						onclick="go('editColaborateur');" />
				</c:when>
				<c:when test="${VIEW=='edit'}">edit collaborateur</c:when>
				<c:otherwise>Default</c:otherwise>
			</c:choose>
		</sec:authorize>

		<p>
			<a href="j_spring_security_logout">Logout</a>
		</p>
	</div>

</body>
</html>