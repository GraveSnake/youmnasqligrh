<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta charset="utf-8" />
<title><spring:message code="menu.home" /></title>
<link
	href="${pageContext.request.contextPath}/resources/css/main_style.css"
	rel="stylesheet" />

</head>
<body>
	<%@include file="header"%>
	<div id="bodydiv">
		<sec:authorize ifAllGranted='ROLE_ADMIN'>
			<h3>Admin access only to manage Managers!</h3>
			<br />
			<c:choose>
				<c:when test="${VIEW=='show'}">
					<input type="button" value="add new manager"
						onclick="go('newManager');" />
					<br />
					<br />
					<%@include file="showManager.jsp"%><br />

				</c:when>
				<c:when test="${VIEW=='new'}">
					<%@include file="newManager.jsp"%><br />
				</c:when>
				<c:when test="${VIEW=='edit'}"><%@include
						file="editManager.jsp"%><br />
				</c:when>
				<c:when test="${VIEW=='view'}"><%@include
						file="viewManager.jsp"%><br />
				</c:when>
				<c:otherwise>Default</c:otherwise>
			</c:choose>
		</sec:authorize>
	</div>

</body>
</html>