<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Student Test Page</title>

<!-- PAGE LEVEL STYLES -->
<link rel="stylesheet" href="resources/css/bootstrap.css" />
<link rel="stylesheet" href="resources/css/login.css" />
<link rel="stylesheet" href="resources/css/magic.css" />
<!-- END PAGE LEVEL STYLES -->

</head>
<body>
	<h1>Welcome to Student Test Page</h1>

	<P>The time on the server is ${serverTime}.</P>
<!-- 
	<table border=1>
		<tr>
			<td>Session Key</td>
			<td>Test Date</td>
		</tr>
		<c:forEach items="${testModel}" var="test">
			<tr>
				<td>${test.sessionKey}</td>
				<td>${test.testDate}</td>
			</tr>
		</c:forEach>
	</table>
-->
	<!-- PAGE CONTENT -->
	<div class="tab-content">
		<div id="login" class="tab-pane active">
			<form:form action="${pageContext.request.contextPath}/test/testStatus" modelAttribute="userTestModel">
				<p class="text-muted text-center btn-block btn btn-primary btn-rect">
					Enter your Student ID and Test ID</p>
					
				<form:input type="text" path="userId" placeholder="Student ID" class="form-control"/>
				<form:input type="text" path="testId" placeholder="Test ID" class="form-control"/>
				<br/>
				<button class="btn text-muted text-center btn-danger" type="submit">Sign in</button>
			</form:form>
		</div>
	</div>

	<!--END PAGE CONTENT -->

	<!-- PAGE LEVEL SCRIPTS -->
	<script src="resources/js/jquery-2.0.3.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>

	<!--END PAGE LEVEL SCRIPTS -->
</body>
</html>
