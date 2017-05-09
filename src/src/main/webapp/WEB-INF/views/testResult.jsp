<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<script src="../resources/js/jquery-2.0.3.min.js"></script>
<!-- BEGIN BODY -->
<body class="padTop53 ">

	<!-- MAIN WRAPPER -->
	<div id="wrap">
		<!-- HEADER SECTION -->
		<%@ include file="/WEB-INF/views/common/headerMenu.jsp"%>
		<!-- END HEADER SECTION -->

		<!-- MENU SECTION -->
		<!--END MENU SECTION -->

		<!--PAGE CONTENT -->
		<div id="content">
			<div class="inner">

				<!-- Main body container -->
				<div class="row">
					<div class="col-lg-12">
						<div class="box">
							<header>
								<h5>Test Result</h5>
								<div class="toolbar">
									<span class="label">label</span>

								</div>
							</header>
							<div class="body">
								<div class="panel panel-success">

									<div class="panel-body">

										<div class="chat-body clearfix">
											<div class="header">
												<ul class="chat">
													<li class="left clearfix"><strong class="primary-font">Student
															Name: </strong> <strong class="primary-font">${beanTestResult.studentName}</strong></li>
													<li><strong class="primary-font">Category: </strong> <strong
														class="primary-font">${beanTestResult.catNameOfTest}</strong></li>
													<ul>
														<c:forEach items="${beanTestResult.listGradeForTest}" var="result">
															<li>
																<strong class="primary-font">${result.key}: </strong>
																<strong class="primary-font">${result.value}</strong></li>
														</c:forEach>
													</ul>
												</ul>
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
	</div>
	<!--END PAGE CONTENT -->

	<!--END MAIN WRAPPER -->

	<!-- FOOTER -->
	<div id="footer">
		<p>&copy; binarytheme &nbsp;2014 &nbsp;</p>
	</div>
	<!--END FOOTER -->


	<!-- GLOBAL SCRIPTS -->
	<!-- END GLOBAL SCRIPTS -->
</body>
<!-- END BODY -->
</html>
