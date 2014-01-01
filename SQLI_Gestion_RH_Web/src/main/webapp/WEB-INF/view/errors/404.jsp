<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<HTML>

<HEAD>
<TITLE><spring:message code="error.notfound" /></TITLE>
</HEAD>

<BODY>

	<BR>
	<BR>
	<BR>
	<BR>
	<BR>
	<BR>
	<BR>
	<BR>
	<BR>
	<BR>

	<table align="center">
		<tr>
			<td align="center"><img
				src="${pageContext.request.contextPath}/resources/images/logo.png"
				align="middle" alt="SQLI Group" /></td>
		</tr>
		<tr>
			<td align="center">
			<span>
			 <br><spring:message code="error.pagenotfound"/>
					<br> <br> <br>
			</span> 
			</td>
		</tr>
		<tr>
			<td align="center"><a href="index"><spring:message code="error.back"/></a></td>
		</tr>
	</table>

</BODY>

</HTML>
