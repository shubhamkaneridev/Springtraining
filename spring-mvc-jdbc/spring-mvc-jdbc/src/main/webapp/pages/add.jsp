<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<title>Spring MVC and JDBC CRUD Example</title>


<style>
.error {
	color: red
}
</style>
<body>
	<h2>Spring MVC and JDBC CRUD Example</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<h3>Add User</h3>
	
	
	<form:form  method="POST" action="add" modelAttribute="userModel">
	
	FirstName:<form:input path="firstName"/><br /><br />
		<form:errors path="firstName" cssClass="error"  />
	LastName:<form:input path="lastName"/>
	<form:errors path="lastName" cssClass="error"  /><br /><br />
	Email:<form:input path="email"/>
	<form:errors path="email" cssClass="error"  /><br /><br />
	Dob:<form:input path="dob"/>
	<form:errors path="dob" cssClass="error"  /><br /><br />
	
	 <input value="Add User" type="submit" />
	</form:form>
	
	
	
	
	
	
	
<%-- 	
	
	
	
	<form method="POST" name="add_user" action="">
		Name: <input name="fname" value="${firstName}" type="text" class="error" /> <br />
			
		<br /> Last Name: <input name="lname" value="${lastName}" type="text" />
				<form:errors path="lastName" cssClass="error" />
		<br /> <br /> Email: <input name="email" value="${email}"
			type="text" /><br /> <br /> DOB: <input name="dob" value="${dob}"
			type="text" /><br /> <br />
	</form> --%>
</body>
</html>