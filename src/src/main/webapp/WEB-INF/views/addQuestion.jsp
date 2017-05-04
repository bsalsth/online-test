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
								<h5>Edit User</h5>
								<div class="toolbar">
									<ul class="nav">
										<li><a href="#">Link</a></li>
										<li class="dropdown"><a data-toggle="dropdown"
											class="dropdown-toggle" href="#"> <i
												class="icon-th-large"></i>
										</a>
											<ul class="dropdown-menu">
												<li><a href="#">Demo Link</a></li>
												<li><a href="#">Demo Link</a></li>
												<li><a href="#">Demo Link</a></li>
											</ul></li>
										<li><a class="accordion-toggle minimize-box"
											data-toggle="collapse" href="#div-1"> <i
												class="icon-chevron-up"></i>
										</a></li>
									</ul>
								</div>
							</header>
							<div id="div-1" class="accordion-body collapse in body">
								<form class="form-horizontal">

									<div class="form-group">
										<label class="control-label col-lg-4">Select Category</label>
										<div class="col-lg-8">
											<select class="form-control">
												<option value="1">Java</option>
												<option>Dot Net</option>
											</select>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-lg-4">Select Sub
											Category</label>
										<div class="col-lg-8">
											<select class="form-control">
												<option value="1">J2EE</option>
												<option>Dot Net</option>
											</select>
										</div>
									</div>

									<div class="form-group">
										<label for="text1" class="control-label col-lg-4">Question</label>
										<div class="col-lg-8">
											<textarea class="form-control" rows=""></textarea>

										</div>
									</div>


									<div class="form-group">
										<label for="text1" class="control-label col-lg-4">1. <input
											type="radio" name="answer" value="" />

										</label>

										<div class="col-lg-8">
											<input type="text" id="text1" placeholder="Option"
												class="form-control" />
										</div>
									</div>

									<div class="form-group">
										<label for="text1" class="control-label col-lg-4">2. <input
											type="radio" name="answer" value="" />


										</label>

										<div class="col-lg-8">
											<input type="text" id="text1" placeholder="Option"
												class="form-control" />
										</div>
									</div>

									<div class="form-group">
										<label for="text1" class="control-label col-lg-4">3. <input
											type="radio" name="answer" value="" />

										</label>

										<div class="col-lg-8">
											<input type="text" id="text1" placeholder="Option"
												class="form-control" />
										</div>
									</div>

									<div class="form-group">
										<label for="text1" class="control-label col-lg-4">4. <input
											type="radio" name="answer" value="" />

										</label>

										<div class="col-lg-8">
											<input type="text" id="text1" placeholder="Option"
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
