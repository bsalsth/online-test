<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Student Test Page</title>

<!-- PAGE LEVEL STYLES -->
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
<link rel="stylesheet" href="../resources/css/login.css" />
<link rel="stylesheet" href="../resources/css/magic.css" />
<!-- END PAGE LEVEL STYLES -->

</head>
<body>
	<h1>Student Test Page Information</h1>

	<!-- PAGE CONTENT -->
	<c:if test="${testModel != null}">
		<h2>Hi ${testModel.user.firstName} ${testModel.user.lastName}
			(${testModel.user.userName})</h2>
		<br />
		<form:form action="${pageContext.request.contextPath}/test/selectCatSubcat" modelAttribute="testModel" method="GET">
			<h3>You are assigned to the test. Click the button below when you are ready</h3>
			<br />
			<input type="submit" value="Yes, take me to the test" />
		</form:form>
	</c:if>

	<c:if test="${testModel == null}">
		<form:form action="${pageContext.request.contextPath}/test" modelAttribute="testModel" method="GET">
			<h3>Wrong access key!!!</h3>
			<br />
			<input type="submit" value="Re-enter access key" />
		</form:form>
	</c:if>

	<!--END PAGE CONTENT -->

	<!-- PAGE LEVEL SCRIPTS -->


	<!--END PAGE LEVEL SCRIPTS -->
</body>
</html>
