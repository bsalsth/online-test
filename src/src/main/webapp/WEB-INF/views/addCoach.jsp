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
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Grid</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="box dark">
							<header>
								<div class="icons">
									<i class="icon-edit"></i>
								</div>
								<h5>Add Coach</h5>
							</header>
							<div id="div-1" class="accordion-body collapse in body">
								<form class="form-horizontal">

									<div class="form-group">
										<label for="text1" class="control-label col-lg-4">First
											Name</label>

										<div class="col-lg-8">
											<input type="text" id="text1" placeholder="Email"
												class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label for="text1" class="control-label col-lg-4">Last
											Name</label>

										<div class="col-lg-8">
											<input type="text" id="text1" placeholder="Email"
												class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label for="text1" class="control-label col-lg-4">Password</label>

										<div class="col-lg-8">
											<input type="text" id="text1" placeholder="Email"
												class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label for="text1" class="control-label col-lg-4">Confirm
											Password</label>

										<div class="col-lg-8">
											<input type="text" id="text1" placeholder="Email"
												class="form-control" />
										</div>
									</div>
									<div class="form-group pull-right">
										<div class="col-lg-8">
											<a href="#" class="btn btn-primary">Add</a>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<!--END PAGE CONTENT -->


	</div>

	<!--END MAIN WRAPPER -->

	<!-- FOOTER -->
	<div id="footer">
		<p>&copy; Mum &nbsp;2017 &nbsp;</p>
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
