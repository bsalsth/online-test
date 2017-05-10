
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
			</ul></li>

	</ul>

</div>