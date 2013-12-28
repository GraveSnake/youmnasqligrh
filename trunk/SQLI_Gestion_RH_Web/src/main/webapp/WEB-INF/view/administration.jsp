<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

  <sec:authorize ifAllGranted='ROLE_ADMIN'>
    <h2>Admin access only To administrate things around !</h2><br/>  
  </sec:authorize>
<p>
	<a href="j_spring_security_logout">Logout</a>
</p>