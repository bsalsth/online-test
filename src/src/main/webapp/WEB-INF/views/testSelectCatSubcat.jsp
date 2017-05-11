<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<script src="../resources/js/jquery-2.0.3.min.js"></script>
<script>
	var categories = eval('(' + '${categoriesJSON}' + ')');

	$(document).ready(
		function() {
			$('#catId').on('change', function() {
				var selectedIndex = $("#catId option:selected").index();
				if (selectedIndex != 0) {
					listSubCat = categories[selectedIndex - 1].listSubcat
					$('#subCatCheckBox').html(
						listSubCat.map(function(subCat) {
							return '<input type="checkbox" id="subCatId" name="subCatId" class="panel panel-default" value="' 
								+ subCat["subCatId"] + '"/>' + subCat["description"] + '<br/>'
						}));
				} else {
					$('#subCatCheckBox').html("");
				}
			});
	});

	var countChecked = function () {
		return $( "input[type='checkbox'].panel-default:checked" ).length;
	};
		
	function validateForm() {
		totalCubCatSelected = countChecked();
		if (totalCubCatSelected >= ${minSubcat} && totalCubCatSelected <= ${maxSubcat}){
			return true;
		}
		alert("You have to select " + ${minSubcat} + " to " + ${maxSubcat} + " sub category to test.");
	    return false;
	}
</script>
<!-- BEGIN BODY -->
<body>
	<!-- MAIN WRAPPER -->
		<div class="text-center">
			<img style="width: 180px; height: 150px;" src="../resources/img/mum.png"
				id="logoimg" alt=" Logo" />
		</div>
		<!--PAGE CONTENT -->
		<div id="tab-content">
			<div class="inner">

				<!-- Main body container -->
					<div class="col-lg-12">
						<div class="box">
							<header>
								<h5>Student Test Page</h5>
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
										<div class="tab-content">
											<div id="login" class="tab-pane active">
												<form:form action="${pageContext.request.contextPath}/test/selectCatSubcat"
													modelAttribute="selectCatSubcat" method="POST" class="form-horizontal"
													 onsubmit="return validateForm()">
													<div class="form-group">
														<label class="control-label col-lg-4">Category</label>
														<div class="col-lg-6">
															<form:select type="text" path="catId" class="form-control">
																<form:option value="0">--------Select Category------</form:option>
																<form:options items="${categoriesModel}" itemLabel="description"	itemValue="catId" />
															</form:select>
														</div>
														<label class="control-label col-lg-4">SubCategory</label>
														<div class="col-lg-6">
															<div class="panel-heading" id="subCatCheckBox"></div>
														</div>
															<div class="col-lg-3 pull-right">
																<button class="btn text-center btn-danger" type="submit">Next</button>
															</div>
													</div>
												</form:form>
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
	<!--END MAIN WRAPPER -->

	<!-- FOOTER -->
	<div id="footer">
		<p>&copy; MUM ONLINE &nbsp;TEST &nbsp;</p>
	</div>
	<!--END FOOTER -->


	<!-- GLOBAL SCRIPTS -->
	<script src="../resources/js/bootstrap.min.js"></script>
	<script src="../resources/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
	<!-- END GLOBAL SCRIPTS -->
</body>
<!-- END BODY -->
</html>
