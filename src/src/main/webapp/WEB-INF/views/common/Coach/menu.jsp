
<div id="left">
	<div class="media user-media well-small">
		<a class="user-link" href="#"> <img
			class="media-object img-thumbnail user-img" alt="User Picture"
			src="${pageContext.request.contextPath}/resources/img/mum.png" />
		</a> <br />
		<div class="media-body">
			<h5 class="media-heading">
			<%= session.getAttribute( "currentUserName" ) %>
			</h5>
		</div>
		<br />
	</div>

	<ul id="menu" class="collapse">


		<li class="panel active"><a href="index.html"> <i
				class="icon-table"></i> Dashboard
		</a></li>


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
				<!-- <li><a href="addStudentDemo"><i class="icon-angle-right"></i>
						Add Student </a></li> -->
			</ul></li>
		<!-- reports -->
		<li class="panel"><a
			href="${pageContext.request.contextPath}/report/list"> <i
				class="icon-folder-open-alt"></i> Reports
		</a></li>
		<!-- test menu -->
		<li><a href="login.html"><i class="icon-signin"></i> Login </a></li>

	</ul>

</div>