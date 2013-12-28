<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

  <sec:authorize ifAllGranted='ROLE_ADMIN'>
    <h3>Admin access only to manage Managers!</h3><br/>  
  </sec:authorize>
<p>
	<a href="j_spring_security_logout">Logout</a>
</p>