<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- BEGIN HEAD -->
<head>
<meta charset="UTF-8" />
<title>Tesing</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->


<!-- GLOBAL SCRIPTS -->
<script src="../resources/js/jquery-2.0.3.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<script src="../resources/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<!-- END GLOBAL SCRIPTS -->

<!-- GLOBAL STYLES -->
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
<link rel="stylesheet" href="../resources/css/main.css" />
<link rel="stylesheet" href="../resources/css/theme.css" />
<link rel="stylesheet" href="../resources/css/MoneAdmin.css" />
<link rel="stylesheet" href="../resources/css/font-awesome.css" />
<!--END GLOBAL STYLES -->
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="padTop53 ">
	<form:form action="${pageContext.request.contextPath}/test/start" modelAttribute="beanTesting" method="POST">
		<!-- MAIN WRAPPER -->
		<div id="wrap">
			<div class="row">
				<div class="col-lg-12">
					<h3>Test part for ${beanTesting.curSubcatName}</h3><i>You still have ${beanTesting.totalSubcat - beanTesting.curSubcatPos - 1} more test part(s).</i>
					<div class="box">
						<header>
							<div class="icons">
								<i class="icon-th"></i>
							</div>
							<h5>Question ${beanTesting.curQuesPos + 1}/${beanTesting.totalQuesInCurSubcat}</h5>

							<div class="toolbar">
								<ul class="nav pull-right">
									<li><i>(Time: 1:27 sec)</i></li>
								</ul>
							</div>
						</header>
						<div id="div-5" class="">
							<!-- INDIVIDUAL QUESTIONS HERE -->
							<div class="panel panel-default ">
								<div class="panel-heading" style="background: #5bded8;">
									<h4 class="text-info">${beanTesting.curQues.description}</h4>
								</div>

								<!-- ANSWERS SECTION  -->
								<div id="question3">
									<div class="panel-body">
								<c:forEach items="${beanTesting.curQues.answerCollection}" var="answ">
										<div class="panel panel-default">
											<div class="panel-heading ">
												<h4 class="panel-title">
													<label class="radio-inline"> 
														<form:radiobutton path="ans4Ques" value='${answ.answerId}'/>${answ.description}												
													</label>
												</h4>
											</div>
										</div>
								</c:forEach>
									</div>
								</div>
								<!-- ANSWERS SECTION  -->
							</div>
							<!-- INDIVIDUAL QUESTIONS  ENDS HERE -->
							<button class="btn text-muted text-center btn-danger" type="submit">Submit</button>
						</div>
					</div>
				</div>
			</div>

		</div>

		<!--END MAIN WRAPPER -->
	</form:form>
	
	<!-- FOOTER -->
	<div id="footer">
		<p>&copy; MUM ONLINE &nbsp;TEST &nbsp;</p>
	</div>
	<!--END FOOTER -->


</body>
<!-- END BODY -->
</html>
