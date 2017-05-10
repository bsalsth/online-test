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
	<%@ include file="/WEB-INF/views/common/headerMenu.jsp"%>
	
	<div id="content">
		<div class="inner">

			<!-- Main body container -->
			<div class="row">
				<div class="col-lg-12">
					<div class="box">
						<header>
							<h5></h5>
							<div class="toolbar">
								<span class="label">label</span>

							</div>
						</header>
						<div class="body">
							<div class="panel panel-success">

								<div class="panel-body">

									<div class="chat-body clearfix">
										<div class="header">
											<c:if test="${testModel != null}">
												<h3>Hi ${testModel.user.firstName}
													${testModel.user.lastName} (${testModel.user.userName})</h3>
												<br />
												<form:form
													action="${pageContext.request.contextPath}/test/selectCatSubcat"
													modelAttribute="testModel" method="GET">
													<h4>You are assigned to the test. Click the button
														below when you are ready</h4>
													<br />
													<input type="submit" value="Yes, take me to the test" class="btn text-center btn-success" />
												</form:form>
											</c:if>

											<c:if test="${testModel == null}">
												<form:form action="${pageContext.request.contextPath}/test"
													modelAttribute="testModel" method="GET">
													<h3>Wrong access key!!!</h3>
													<br />
													<input type="submit" value="Re-enter access key" class="btn text-muted text-center btn-danger"/>
												</form:form>
											</c:if>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Main body container -->
		</div>
	</div>




	<!--END PAGE CONTENT -->

	<!-- PAGE LEVEL SCRIPTS -->


	<!--END PAGE LEVEL SCRIPTS -->
</body>
</html>
