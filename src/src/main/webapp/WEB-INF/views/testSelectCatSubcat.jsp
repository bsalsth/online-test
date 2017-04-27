<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Category & Sub Category</title>
</head>
<body>
	Tada, you have reached to select Category & Sub Category page for your test.
	
	<form:form action="${pageContext.request.contextPath}/test/start" modelAttribute="testModel" method="POST">
		<h3>I'm done for selecting Category and Subcategory for the test. Send me to the test questions page.</h3>
		<br />
		<input type="submit" value="Yes, take me to the test" />
	</form:form>
</body>
</html>