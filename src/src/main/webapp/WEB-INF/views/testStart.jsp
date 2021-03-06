<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- BEGIN HEAD -->
<head>
<meta charset="UTF-8" />
<title>Tesing</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->


<!-- GLOBAL SCRIPTS -->
<script src="../resources/js/jquery-2.0.3.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<script src="../resources/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<!-- END GLOBAL SCRIPTS -->

<!-- GLOBAL STYLES -->
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
<link rel="stylesheet" href="../resources/css/main.css" />
<link rel="stylesheet" href="../resources/css/theme.css" />
<link rel="stylesheet" href="../resources/css/MoneAdmin.css" />
<link rel="stylesheet" href="../resources/css/font-awesome.css" />
<!--END GLOBAL STYLES -->


<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="padTop53 ">
	<form:form action="${pageContext.request.contextPath}/test/start" modelAttribute="beanTesting" method="POST" onsubmit="return validateForm()">
		<!-- MAIN WRAPPER -->
		<div id="wrap">
			<div class="row">
				<div class="col-lg-12">
					<h3>Test part for ${beanTesting.curSubcatName}</h3><i>You still have ${beanTesting.totalSubcat - beanTesting.curSubcatPos - 1} more test part(s).</i>
					<div class="box">
						<header>
							<div class="icons">
								<i class="icon-th"></i>
							</div>
							<h5>Question ${beanTesting.curQuesPos + 1}/${beanTesting.totalQuesInCurSubcat}</h5>

							<div class="toolbar" style="vertical-align:middle">
									<p id="timerCountDown" class="text-success"></p>
							</div>
						</header>
							<form:hidden path="timeLeft"/>
						<div id="div-5" class="">
							<!-- INDIVIDUAL QUESTIONS HERE -->
							<div class="panel panel-default ">
								<div class="panel-heading" style="background: #5bded8;">
									<h4 class="text-info">${beanTesting.curQues.description}</h4>
								</div>

								<!-- ANSWERS SECTION  -->
								<div id="question3">
									<div class="panel-body">
								<c:forEach items="${beanTesting.curQues.answerCollection}" var="answ">
										<div class="panel panel-default">
											<div class="panel-heading ">
												<h4 class="panel-title">
													<label class="radio-inline"> 
														<form:radiobutton path="ans4Ques" value='${answ.answerId}'/>${answ.description}												
													</label>
												</h4>
											</div>
										</div>
								</c:forEach>
									</div>
								</div>
								<!-- ANSWERS SECTION  -->
							</div>
							<!-- INDIVIDUAL QUESTIONS  ENDS HERE -->
							<button class="btn text-muted text-center btn-danger" type="submit">Submit</button>
						</div>
					</div>
				</div>
			</div>

		</div>

		<!--END MAIN WRAPPER -->
	</form:form>
	
	<!-- FOOTER -->
	<div id="footer">
		<p>&copy; MUM ONLINE &nbsp;TEST &nbsp;</p>
	</div>
	<!--END FOOTER -->


<script>
// Set the date we're counting down to
var countDownDate = ${beanTesting.timeLeft};

// Update the count down every 1 second
var x = setInterval(function() {

    var now = new Date().getTime();
    
    // Find the distance between now an the count down date
    var distance = countDownDate - now;
    
    // Time calculations for days, hours, minutes and seconds
    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
    $("#timerCountDown").html(hours != 0 ? hours + "h " : "" + minutes + "m " + seconds + "s");
    
    if (minutes <= ${beanTesting.dangerTime}) {
    	document.getElementById("timerCountDown").style.color = "red";
    	document.getElementById("timerCountDown").style.fontWeight = "bold"
    	document.getElementById("timerCountDown").style.textDecoration = "blink";
    } else if (minutes <= ${beanTesting.warningTime}) {
    	document.getElementById("timerCountDown").style.color  = "orange";
    	document.getElementById("timerCountDown").style.fontWeight = "bold"
    } 
    $("#timeLeft").val($("#timeLeft").val() - 1000);
    // If the count down is over, write some text 
    if (distance < 0) {
        clearInterval(x);
        var form = document.getElementById("beanTesting");
        form.action = "${pageContext.request.contextPath}/test/end";
        form.submit();
    }
}, 1000);

var countChecked = function () {
	return $("input[type='radio']:checked").val();
};
	
function validateForm() {
	isChecked = countChecked();
	if (typeof isChecked == 'undefined') {
		alert("You have to select an answer to continue to the next question.");
		return false;
	}
	return true;
}
</script>

</body>
<!-- END BODY -->
</html>
