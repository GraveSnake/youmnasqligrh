<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

  <sec:authorize ifAllGranted='ROLE_ADMIN'>
    <h3>Reporting Admin access !</h3><br/>  
  </sec:authorize>
    <sec:authorize ifAllGranted='ROLE_USER'>  
    <h3>Reporting Manager access !</h3><br/>  
  </sec:authorize>
<p>
	<a href="j_spring_security_logout">Logout</a>
</p>