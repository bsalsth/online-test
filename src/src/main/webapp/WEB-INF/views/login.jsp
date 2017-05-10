<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<!-- BEGIN HEAD -->
<head>
<meta charset="UTF-8" />
<title>MUM ADMIN</title>
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
			<img style="width: 180px; height: 150px;" src="resources/img/mum.png"
				id="logoimg" alt=" Logo" />
		</div>
		<div class="tab-content">
			<div id="login" class="tab-pane active">
				<form action="<c:url value='/postLogin'/>"
					class="form-signin" method="post">
					<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
						<font color="red"> Your login attempt was not successful
							due to <br /> <br /> <c:out
								value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
						</font>
					</c:if>

					<%
						String errorString = (String) request.getAttribute("error");
						if (errorString != null && errorString.trim().equals("true")) {
							out.println("<span class=\"dark\">Incorrect login name or password. Please try again");
						}
					%>
					<p
						class="text-muted text-center btn-block btn btn-primary btn-rect">
						Enter your username and password</p>
					<input type="text" placeholder="Username" class="form-control"  name="username"/>
					<input type="password" placeholder="Password" class="form-control"  name="password"/>
					<button class="btn text-muted text-center btn-danger">Sign
						in</button>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
			</div>
			<div id="forgot" class="tab-pane">
				<form action="index.html" class="form-signin">
					<p
						class="text-muted text-center btn-block btn btn-primary btn-rect">Enter
						your valid e-mail</p>
					<input type="email" required="required" placeholder="Your E-mail"
						class="form-control" /> <br />
					<button class="btn text-muted text-center btn-success"
						type="submit">Recover Password</button>
				</form>
			</div>
			<div class="text-center">
				<ul class="list-inline">
					<!--  <li><a class="text-muted" href="#login" data-toggle="tab">Login</a></li> -->
					<li><a class="text-muted" href="#forgot" data-toggle="tab">Forgot
							Password</a></li>
				</ul>
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
