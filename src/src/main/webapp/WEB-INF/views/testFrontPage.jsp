<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- BEGIN HEAD -->
<head>
<meta charset="UTF-8" />
<title>MUM Student</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
<!-- GLOBAL STYLES -->
<!-- PAGE LEVEL STYLES -->
<link rel="stylesheet" href="resources/css/bootstrap.css" />
<link rel="stylesheet" href="resources/css/login.css" />
<link rel="stylesheet" href="resources/css/magic.css" />
<!-- END PAGE LEVEL STYLES -->
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->
<body>

	<!-- PAGE CONTENT -->
	<div class="container">
		<div class="text-center">
			<img style="width: 180px; height: 150px;" src="resources/img/mum.png" id="logoimg" alt=" Logo" />
		</div>
		<div class="tab-content">
			<div id="login" class="tab-pane active">
				<form:form action="${pageContext.request.contextPath}/test/testStatus"
					class="form-signin" modelAttribute="userTestModel">
					<p class="text-muted text-center btn-block btn btn-primary btn-rect">
						Enter your access id:</p>
					<form:input type="text" path="accessKey" placeholder="Access ID"
						class="form-control" />
					<br/>
					<button class="btn text-muted text-center btn-success" type="submit">Submit</button>
				</form:form>
			</div>
		</div>
	</div>

	<!--END PAGE CONTENT -->

	<!-- PAGE LEVEL SCRIPTS -->
	<script src="resources/js/jquery-2.0.3.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/login.js"></script>
	<!--END PAGE LEVEL SCRIPTS -->

</body>
<!-- END BODY -->
</html>
