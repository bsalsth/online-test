<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
						<h1 class="page-header"></h1>
					</div>
				</div>



				<div class="row">
					<div class="col-lg-12">
						<div class="box dark">
							<header>
								<div class="icons">
									<i class="icon-edit"></i>
								</div>
								<h5>Add Question</h5>
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

								<form:form modelAttribute="question"
									action="/group2/question/saveQuestion" method="post"
									class="form-horizontal">
									<div class="form-group">
										<label class="control-label col-lg-4">Select Category</label>
										<div class="col-lg-8">

											<select id="category" name="category"
												style="padding: 5px 30px;">
												<option value="0">--Select Category--</option>
												<c:forEach var="item" items="${categoryList}">
													<option value="${item.catId}">${item.description}</option>
												</c:forEach>
											</select>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-lg-4">Select Sub
											Category</label>
										<div class="col-lg-8">
											<form:select path="subcategory.subCatId" id="subcategory"
												style="padding: 5px 30px;">

											</form:select>
										</div>
									</div>

									<div class="form-group">
										<label for="text1" class="control-label col-lg-4">Question</label>
										<div class="col-lg-8">
											<form:textarea path="description" class="form-control"
												placeholder="Please enter your question" />
										</div>
									</div>

<!-- 
									<c:forEach items="${question.answers}" varStatus="vs">
										<div class="form-group">
											<label for="text1" class="control-label col-lg-4">
												<form:radiobutton path="answerCollection[${vs.index}]"></form:radiobutton>

											</label>

											<div class="col-lg-8">
												<form:input type="text" path="answerCollection[${vs.index}]"
													class="form-control" placeholder="Option" />
											</div>

										</div>
									</c:forEach>
-->
										<div class="form-group">
											<label for="text1" class="control-label col-lg-4">
												<input type="radio"/>
											</label>

											<div class="col-lg-8">
												<input type="text"  placeholder="Answer"/>
											</div>
										</div>										<div class="form-group">
											<label for="text1" class="control-label col-lg-4">
												<input type="radio"/>
											</label>

											<div class="col-lg-8">
												<input type="text"  placeholder="Answer"/>
											</div>
										</div>										<div class="form-group">
											<label for="text1" class="control-label col-lg-4">
												<input type="radio"/>
											</label>

											<div class="col-lg-8">
												<input type="text"  placeholder="Answer"/>
											</div>
										</div>										<div class="form-group">
											<label for="text1" class="control-label col-lg-4">
												<input type="radio"/>
											</label>

											<div class="col-lg-8">
												<input type="text"  placeholder="Answer"/>
											</div>
										</div>

									<div class="form-group pull-right">
										<div class="col-lg-8">
											<a href="#" class="btn btn-primary">Add</a>
										</div>
									</div>
								</form:form>
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

	<script
		src='<spring:url value="/resources/plugins/jquery-2.0.3.min.js"></spring:url>'></script>


	<script
		src='<spring:url value="/resources/plugins/bootstrap/js/bootstrap.min.js"></spring:url>'></script>

	<script
		src='<spring:url value="/resources/plugins/modernizr-2.6.2-respond-1.1.0.min.js"></spring:url>'></script>

	<script>
	var categories = eval('(' + '${categoriesJSON}' + ')');
	
	$(document).ready(
			function() {
				$('#category').on('change', function() {
					var selectedIndex = $("#category option:selected").index();
					if (selectedIndex != 0) {
						listSubCat = categories[selectedIndex - 1].listSubcat
						$('#subcategory').html(
							listSubCat.map(function(subCat) {
								return '<option value="'+ subCat["subCatId"] + '">' + subCat["description"] + '</option>';
							}));
					} else {
						$('#subCatCheckBox').html("");
					}
				});
		});
	</script>

<%-- 	<script	src='<spring:url value="/resources/js/categorySelectEvent.js"></spring:url>'></script> --%>


	<!-- END GLOBAL SCRIPTS -->

</body>
<!-- END BODY -->
</html>
