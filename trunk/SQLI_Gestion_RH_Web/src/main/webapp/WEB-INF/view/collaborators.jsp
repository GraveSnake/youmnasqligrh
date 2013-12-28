<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

  <sec:authorize ifAllGranted='ROLE_USER'>  
    <h3>All access !</h3><br/>
    Editing Collaborators without 3 persistent fields : salary etc ...
  </sec:authorize>
  <br />
  <sec:authorize ifAllGranted='ROLE_ADMIN'>
    <h3>Admin zone !</h3><br/>  
    <%@include file="collab_admin.jsp" %>
  </sec:authorize>

<p>
	<a href="j_spring_security_logout">Logout</a>
</p>