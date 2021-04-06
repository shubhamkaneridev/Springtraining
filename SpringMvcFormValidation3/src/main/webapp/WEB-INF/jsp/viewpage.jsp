<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<style>
.error{color:red}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

<script type="text/javascript">

$(document).ready(function() {
	$(function() {
	$("#expenseDate").datepicker();
	});
	});


</script>


</head>
<body>
<form:form action="helloagain" modelAttribute="emp">
Username: <form:input path="name"/> <br><br>
<form:errors path="name" cssClass="error"/><br><br>


Email: <form:input path="email"/> <br><br>
<form:errors path="email" cssClass="error"/><br><br>



<%-- 
DOB: <form:input path="date"  id="expenseDate"/> <br><br>
<form:errors path="date" cssClass="error"/><br><br>
 --%>
Password(*): <form:password path="pass"/>  
<form:errors path="pass" cssClass="error"/><br><br>
<input type="submit" value="submit">
</form:form>
</body>
</html>