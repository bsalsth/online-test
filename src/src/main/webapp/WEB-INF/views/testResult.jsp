<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<script src="../resources/js/jquery-2.0.3.min.js"></script>
!-- BEGIN BODY -->
<body class="padTop53 ">

	<!-- MAIN WRAPPER -->
	<div id="wrap">
		<!-- HEADER SECTION -->
		<%@ include file="/WEB-INF/views/common/headerMenu.jsp"%>
		<!-- END HEADER SECTION -->

		<!-- MENU SECTION -->
		<%@ include file="/WEB-INF/views/common/menu.jsp"%>
		<!--END MENU SECTION -->

		<!--PAGE CONTENT -->
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
									<div class="panel-heading">
										<i class="icon-table"></i> Select Category & Sub Category for your test
									</div>
									<div class="panel-body">
										<ul class="chat">
											<li class="left clearfix">
												<div class="chat-body clearfix">
													<div class="header">
														<ul>
															<li><strong class="primary-font"> Name: </strong> <strong
																class="primary-font"> Bishal Shrestha </strong></li>
															<li><strong class="primary-font"> Category:
															</strong> <strong class="primary-font"> JAVA </strong></li>
															<li><strong class="primary-font"> Correct
																	Answers: </strong> <strong class="primary-font"> 90/100
															</strong></li>
														</ul>
													</div>
													<br /> <span class="chat-img pull-right"> <strong
														class="primary-font "> GRADE: &nbsp </strong> <strong
														class="mg-circle primary-font"> A- </strong>
													</span> <span class=" primary-font pull-right"> </br>

													</span>
												</div>
											</li>
										</ul>
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
	<script src="resources/plugins/jquery-2.0.3.min.js"></script>
	<script src="resources/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="resources/plugins/modernizr-2.6.2-respond-1.1.0.min.js"></script>
	<!-- END GLOBAL SCRIPTS -->
</body>
<!-- END BODY -->
</html>
