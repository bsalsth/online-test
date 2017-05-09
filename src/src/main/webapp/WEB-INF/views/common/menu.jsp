
<div id="left">
	<div class="media user-media well-small">
		<a class="user-link" href="#"> <img
			class="media-object img-thumbnail user-img" alt="User Picture"
			src="${pageContext.request.contextPath}/resources/img/user.gif" />
		</a> <br />
		<div class="media-body">
			<h5 class="media-heading">Joe Romlin</h5>

		</div>
		<br />
	</div>

	<ul id="menu" class="collapse">


		<li class="panel active"><a href="index.html"> <i
				class="icon-table"></i> Dashboard
		</a></li>

		<!-- // COACH MENU -->
		<li class="panel"><a href="#" data-parent="#menu"
			data-toggle="collapse" class="accordion-toggle"
			data-target="#coach-menu"> <i class="icon-user"></i> Coach <span
				class="pull-right"> <i class="icon-angle-left"></i>
			</span> &nbsp; <span class="label label-warning">5</span>&nbsp;
		</a>
			<ul class="collapse" id="coach-menu">
				<li><a href="addCoachDemo"><i class="icon-angle-right"></i>
						Add Coach </a></li>
				<li><a href="coachDemo"><i class="icon-angle-right"></i>
						List Coach </a></li>
			</ul></li>
		<!-- // STUDENTS MENU -->
		<li class="panel"><a href="#" data-parent="#menu"
			data-toggle="collapse" class="accordion-toggle"
			data-target="#students-menu"> <i class="icon-user"></i> Student <span
				class="pull-right"> <i class="icon-angle-left"></i>
			</span> &nbsp; <span class="label label-warning">5</span>&nbsp;
		</a>
			<ul class="collapse" id="students-menu">
				<li><a href="studentDemo"><i class="icon-angle-right"></i>
						List Students </a></li>
				<li><a href="addStudentDemo"><i class="icon-angle-right"></i>
						Add Student </a></li>
			</ul></li>
		<!-- // Data Entry MENU -->
		<li class="panel"><a href="#" data-parent="#menu"
			data-toggle="collapse" class="accordion-toggle"
			data-target="#manager-menu"> <i class="icon-user"></i> Data
				Manager <span class="pull-right"> <i class="icon-angle-left"></i>
			</span> &nbsp; <span class="label label-warning">5</span>&nbsp;
		</a>
			<ul class="collapse" id="manager-menu">
				<li><a href="dataManagerDemo"><i class="icon-angle-right"></i>
						List Data Manager </a></li>
				<li><a href="addDataManagerDemo"><i
						class="icon-angle-right"></i> Add Data Manager </a></li>
			</ul></li>

		<!-- questions -->
		<li class="panel"><a href="#" data-parent="#menu"
			data-toggle="collapse" class="accordion-toggle"
			data-target="#qn-menu"> <i class="icon-user"></i> Questions<span
				class="pull-right"> <i class="icon-angle-left"></i>
			</span> &nbsp; <span class="label label-warning">5</span>&nbsp;
		</a>
			<ul class="collapse" id="qn-menu">
				<li><a href="questionsDemo"><i class="icon-angle-right"></i>
						List Questions </a></li>
				<li><a href="addQuestionDemo"><i
						class="icon-angle-right"></i> Add Question </a></li>
				<li><a href="${pageContext.request.contextPath}/file"><i
						class="icon-angle-right"></i> Load File Questions </a></li>
			</ul></li>
		<!-- reports -->
		<li class="panel"><a href="${pageContext.request.contextPath}/report/list"> <i
				class="icon-folder-open-alt"></i> Reports
		</a></li>
		<!-- test menu -->
		<li class="panel"><a href="test_result.html"> <i
				class="icon-folder-open-alt"></i> Test Page
		</a></li>
		<li class="panel"><a href="editUser.html"> <i
				class="icon-folder-open-alt"></i> Add Question
		</a></li>
		<li class="panel"><a href="test_frontend.html"> <i
				class="icon-folder-open-alt"></i> TEST UI
		</a></li>

		<li><a href="login.html"><i class="icon-signin"></i> Login </a></li>

	</ul>

</div>