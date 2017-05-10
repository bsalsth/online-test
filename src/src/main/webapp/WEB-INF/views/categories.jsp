<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- BEGIN BODY -->
<body class="padTop53 ">

	<!-- MAIN WRAPPER -->
	<div id="wrap">


		<!-- HEADER SECTION -->
		<%-- 		<%@ include file="/WEB-INF/views/common/headerMenu.jsp"%> --%>
		<!-- END HEADER SECTION -->



		<!-- MENU SECTION -->
		<%-- 		<%@ include file="/WEB-INF/views/common/menu.jsp"%> --%>
		<!--END MENU SECTION -->



		<!--PAGE CONTENT -->
		<div id="content">
			<div class="inner">
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Category</div>
							<div class="panel-body">
								<form:form method="post" modelAttribute="categoryAdd"
									action="${pageContext.request.contextPath}/category/saveACategory">
									<div class="panel panel-primary">
										<div class="panel-heading">Add New Category</div>
										<div class="table-responsive">
											<table class="table table-striped table-bordered table-hover">
												<tbody>
													<tr>
														<td>Name: <form:input path="description" />  <input type="submit" value="Save" /></td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</form:form>

								<div class="panel panel-primary">
									<div class="panel-heading">Category List</div>
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th width="10%">Category Id</th>
													<th>Category Name</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="category" items="${categoryView}">
													<tr>
														<td>${category.catId}</td>
														<td>${category.description}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--END PAGE CONTENT -->



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
