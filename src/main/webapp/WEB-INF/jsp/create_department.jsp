<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<h2>HTML Forms</h2>
<form:form action="savedepartmentSubmitpath" modelAttribute="department" method="POST" >
  <label for="fname">Dep name:</label><br>
   <form:input  type="text" id="depName" ath="depName" name="depName" /><br>
  <label for="lname">Dep Desc:</label><br>
  <form:input  type="text" id="depDesc" ath="depDesc" name="depDesc" /><br><br><br>
 <input type="submit" name="save"
              value="Save"/>
         
</form:form>

<p>If you click the "Submit" button, the form-data will be sent to a page called "/action_page.php".</p>

</body>
</html>
html>