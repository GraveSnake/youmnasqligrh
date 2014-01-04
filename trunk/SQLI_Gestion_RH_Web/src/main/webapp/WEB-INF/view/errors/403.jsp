<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<HTML>

<HEAD>
	<TITLE><spring:message code="error.accessdenied" /></TITLE>
</HEAD>

<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>

<BODY>
<table align="center">
	<tr>
		<td align="center">
		<img src="${pageContext.request.contextPath}/resources/images/logo.png" align="middle" alt="SQLI Group" />
		</td>
	</tr>
	<tr>
		<td align="center">
			<span>
			<br>
			<spring:message code="error.noright" />
					<br> <br> <br>
			</span>
		</td>
	</tr>
	<tr>
		<td align="center">
			<a href="${pageContext.request.contextPath}/index"><spring:message code="error.back"/></a>
		</td>
	</tr>
</table>

</BODY>

</HTML>
