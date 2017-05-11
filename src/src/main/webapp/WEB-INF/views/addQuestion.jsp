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

											<select id="category" name="category"
												style="padding: 5px 30px;">
												<option value="">--Select Category--</option>
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
											<select id="subcategory" name="subcategory"
												style="padding: 5px 30px;">

											</select>
										</div>
									</div>

									<div class="form-group">
										<label for="text1" class="control-label col-lg-4">Question</label>
										<div class="col-lg-8">
											<form:textarea path="question.description" class="form-control"
												id="question" name="question"
												placeholder="Please enter your question" />
										</div>
									</div>


									<c:forEach items="${question.answers}" varStatus="vs">
										<div class="form-group">
											<div class="col-sm-1"></div>
											<div class="col-sm-9">
												<form:input type="text" path="question.answers[${vs.index}]"
													class="form-control" id="answer" name="question"
													placeholder="Enter option here" />
												<form:radiobutton path="question.answers[${vs.index}]"
													id="checkbox_ans" name="checkbox_ans" class="checkbox_ans"></form:radiobutton>

											</div>
										</div>
										<br />
									</c:forEach>


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

	<script
		src='<spring:url value="/resources/plugins/jquery-2.0.3.min.js"></spring:url>'></script>


	<script
		src='<spring:url value="/resources/plugins/bootstrap/js/bootstrap.min.js"></spring:url>'></script>

	<script
		src='<spring:url value="/resources/plugins/modernizr-2.6.2-respond-1.1.0.min.js"></spring:url>'></script>

	<script
		src='<spring:url value="/resources/js/categorySelectEvent.js"></spring:url>'></script>


	<!-- END GLOBAL SCRIPTS -->

</body>
<!-- END BODY -->
</html>
