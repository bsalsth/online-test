<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!-- BEGIN BODY -->
<body class="padTop53 ">

	<!-- MAIN WRAPPER -->
	<div id="wrap">


		<!-- HEADER SECTION -->
		<%@ include file="/WEB-INF/views/common/headerMenu.jsp"%>
		<!-- END HEADER SECTION -->



		<!-- MENU SECTION -->
		<%@ include file="/WEB-INF/views/common/Admin/menu.jsp"%>
		<!--END MENU SECTION -->



		<!--PAGE CONTENT -->
		<div id="content" class="col-lg-12">

			<div class="inner col-lg-12" style="min-height: 700px;">
				<div class="row">
					<div class="col-lg-12">
						<h1>Admin Dashboard</h1>
					</div>
				</div>
				<hr />
				<!--BLOCK SECTION -->
				<div class="row">
					<div class="col-lg-12">
						<div style="text-align: center;">

							<a class="quick-btn" href="#"> <i class="icon-check icon-2x"></i>
								<span> Coach</span> <span class="label label-danger">2</span>
							</a> <a class="quick-btn" href="#"> <i
								class="icon-envelope icon-2x"></i> <span>Student</span> <span
								class="label label-success">456</span>
							</a> <a class="quick-btn" href="#"> <i
								class="icon-signal icon-2x"></i> <span>Test</span> <span
								class="label label-warning">+25</span>
							</a>
						</div>

					</div>

				</div>
				<!--END BLOCK SECTION -->
				<hr />




				<!--TABLE, PANEL, ACCORDION AND MODAL  -->
				<div class="row">
					<div class="col-lg-12">
						<div class="box">
							<header>
								<h5>Recent Test</h5>
								<div class="toolbar">
									<div class="btn-group">
										<a href="#sortableTable" data-toggle="collapse"
											class="btn btn-default btn-sm accordion-toggle minimize-box">
											<i class="icon-chevron-up"></i>
										</a>
									</div>
								</div>
							</header>
							<div id="sortableTable" class="body collapse in">
								<table
									class="table table-bordered sortableTable responsive-table">
									<thead>
										<tr>
											<th>#<i class="icon-sort"></i><i class="icon-sort-down"></i>
												<i class="icon-sort-up"></i></th>
											<th>Category<i class="icon-sort"></i><i
												class="icon-sort-down"></i> <i class="icon-sort-up"></i></th>
											<th>First Name<i class="icon-sort"></i><i
												class="icon-sort-down"></i> <i class="icon-sort-up"></i></th>
											<th>Last Name<i class="icon-sort"></i><i
												class="icon-sort-down"></i> <i class="icon-sort-up"></i></th>
											<th>Score<i class="icon-sort"></i><i
												class="icon-sort-down"></i> <i class="icon-sort-up"></i></th>
										</tr>
									</thead>
									<tbody>


										<tr>
											<td>1</td>
											<td>Java</td>
											<td>Jill</td>
											<td>Smith</td>
											<td>50</td>
										</tr>

										<tr>
											<td>2</td>
											<td>Java</td>
											<td>Eve</td>
											<td>Jackson</td>
											<td>94</td>
										</tr>

										<tr>
											<td>3</td>
											<td>Java</td>
											<td>John</td>
											<td>Doe</td>
											<td>80</td>
										</tr>

										<tr>
											<td>4</td>
											<td>Java</td>
											<td>Adam</td>
											<td>Johnson</td>
											<td>67</td>
										</tr>


									</tbody>
								</table>
							</div>
						</div>

					</div>
					<div class="col-lg-12">
						<div class="panel panel-primary">
							<div class="panel-heading">Short Info</div>
							<div class="panel-body">
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Vestibulum tincidunt est vitae ultrices accumsan. Aliquam
									ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
							</div>
							<div class="panel-footer">Panel Footer</div>
						</div>
					</div>

				</div>
				<!--TABLE, PANEL, ACCORDION AND MODAL  -->


			</div>

		</div>
		<!--END PAGE CONTENT -->


	</div>

	<!--END MAIN WRAPPER -->

	<!-- FOOTER -->
	<div id="footer">
		<p>&copy; MUM &nbsp;2017 &nbsp;</p>
	</div>
	<!--END FOOTER -->


	<!-- GLOBAL SCRIPTS -->
	<script src="resources/plugins/jquery-2.0.3.min.js"></script>
	<script src="resources/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="resources/plugins/modernizr-2.6.2-respond-1.1.0.min.js"></script>
	<!-- END GLOBAL SCRIPTS -->

	<!-- PAGE LEVEL SCRIPTS -->
	<script src="resources/plugins/flot/jquery.flot.js"></script>
	<script src="resources/plugins/flot/jquery.flot.resize.js"></script>
	<script src="resources/plugins/flot/jquery.flot.time.js"></script>
	<script src="resources/plugins/flot/jquery.flot.stack.js"></script>
	<script src="resources/js/for_index.js"></script>

	<!-- END PAGE LEVEL SCRIPTS -->


</body>

<!-- END BODY -->
</html>
