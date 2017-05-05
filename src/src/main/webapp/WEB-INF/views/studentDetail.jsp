<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!-- BEGIN BODY -->
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
										<i class="icon-table"></i> Test Result:
									</div>
									<div class="panel-body">
										<ul class="chat">
											<li class="left clearfix">
												<div class="chat-body clearfix">
													<div class="header">
														<ul>
															<li><strong class="primary-font"> Name: </strong> <strong
																class="primary-font"> Bishal Shrestha </strong></li>
															<li><strong class="primary-font"> Student Id:
															</strong> <strong class="primary-font"> 544556 </strong></li>
															<li><strong class="primary-font">Entry</strong> 
															<strong class="primary-font"> April 2016
															</strong></li>
														</ul>
													</div>
													<br /> <span class="chat-img pull-right">
														<button class="btn btn-success" data-toggle="modal"
															data-target="#buttonedModal">Generate Access Key
														</button>
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
					<!-- Main body container -->




				</div>
			</div>
			<!--END PAGE CONTENT -->


			<!-- ACESS KEY MODAL -->
			<div class="col-lg-12">
				<div class="modal fade" id="buttonedModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="H1">Access key</h4>
							</div>
							<div class="modal-body">5435HKJLJKLJKL98</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Send Via Email</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- ACESS KEY MODAL -->
		</div>

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
