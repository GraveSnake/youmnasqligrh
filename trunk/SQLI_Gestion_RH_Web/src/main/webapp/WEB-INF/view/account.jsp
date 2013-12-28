<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

    <sec:authorize ifAllGranted='ROLE_USER'>  
    <h2>Everyone access My Account To manage their account :)</h2><br/>  
  </sec:authorize>
<p>
	<a href="j_spring_security_logout">Logout</a>
</p>