<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!-- BEGIN BODY -->
<body class="padTop53 ">

	<!-- MAIN WRAPPER -->
	<div id="wrap">


		<!-- HEADER SECTION -->
		<%@ include file="/WEB-INF/views/common/headerMenu.jsp"%>
		<!-- END HEADER SECTION -->



	<!-- MENU SECTION -->
		<c:if test="${sessionScope.currentRole == 'Coach'}">
		<%@ include file="/WEB-INF/views/common/Coach/menu.jsp"%>
		</c:if>
		<c:if test="${sessionScope.currentRole == 'Admin'}">
		<%@ include file="/WEB-INF/views/common/Admin/menu.jsp"%>
		</c:if>
		<c:if test="${sessionScope.currentRole == 'DataManager'}">
		<%@ include file="/WEB-INF/views/common/DataManager/menu.jsp"%>
		</c:if>
		<!--END MENU SECTION -->


		<!--PAGE CONTENT -->
		<div id="content">
			<div class="inner">
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Coaches</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>Id</th>
												<th>Name</th>
												<th>Edit</th>
												<th>Delete</th>
											</tr>
										</thead>
										<tbody>
											<tr class="odd gradeX">
												<td>1</td>

												<td>Hacky Tack</td>
												<td class="center"><a class="center" href="#question3">
														<i class="icon-edit"></i>
												</a></td>
												<td class="center"><a class="center" href="#question3">
														<i class="icon-remove"></i>
												</a></td>

											</tr>
											<tr class="even gradeC">
												<td>2</td>

												<td>Mr x</td>
												<td class="center"><a class="center" href="#question3">
														<i class="icon-edit"></i>
												</a></td>
												<td class="center"><a class="center" href="#question3">
														<i class="icon-remove"></i>
												</a></td>
											</tr>
										</tbody>
									</table>
								</div>

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
		<p>&copy; MUM &nbsp;2014 &nbsp;</p>
	</div>
	<!--END FOOTER -->

	<!-- GLOBAL SCRIPTS -->
	<script src="resources/plugins/jquery-2.0.3.min.js"></script>
	<script src="resources/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="resources/plugins/modernizr-2.6.2-respond-1.1.0.min.js"></script>
	<!-- END GLOBAL SCRIPTS -->
	<!-- PAGE LEVEL SCRIPTS -->
	<script src="resources/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="resources/plugins/dataTables/dataTables.bootstrap.js"></script>
	<script>
		$(document).ready(function() {
			$('#dataTables-example').dataTable();
		});
	</script>
	<!-- END PAGE LEVEL SCRIPTS -->
</body>
<!-- END BODY -->
</html>
