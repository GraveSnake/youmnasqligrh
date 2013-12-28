<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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