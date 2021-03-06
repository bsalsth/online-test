<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                        <div class="panel panel-default">
                            <div class="panel-heading"><strong class="primary-font">Test Report</strong></div>
                            <div class="panel-body">
                                
                                <div class="header">
                                    <strong class="primary-font">
                                        Test Results for: ${report.user.firstName} ${report.user.lastName}<br>
                                        Test Date: <fmt:formatDate pattern="yyyy-MM-dd" value="${report.test.testDate}"/>
                                    </strong>    
                                </div>
                                
                                <br>
                                <div class="panel panel-primary">
                                    <div class="panel-heading">Test Summary</div>
                                    <c:forEach items="${report.score}" var="category">
                                       <div class="table-responsive">
                                       <table class="table table-striped table-bordered table-hover">
                                               <thead>
                                                <tr><th colspan="6">Category: ${category.key.description}</th></tr>
                                                <tr>
                                                    <th>Subcategory</th>
                                                    <th>Number of Correct</th>
                                                    <th>Number of Wrong</th>
                                                    <th>Number of Questions</th>
                                                    <th>Percentage</th>
                                                    <th>Grade</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${category.value}" var="subcategory">
                                                <tr>
                                                    <td>${subcategory.key.description}</td>
                                                    <td>${subcategory.value.CORRECT}</td>
                                                    <td>${subcategory.value.WRONG}</td>
                                                    <td>${subcategory.value.TOTAL}</td>
                                                    <td>${subcategory.value.PERCENTAGE}</td>
                                                    <td>${subcategory.value.GRADE}</td>
                                                </tr>
                                                </c:forEach>
                                                <tr>
                                                    <th>TOTAL</th>
                                                    <td>${report.categoryScoreMap[category.key.description].CORRECT}</td>
                                                    <td>${report.categoryScoreMap[category.key.description].WRONG}</td>
                                                    <td>${report.categoryScoreMap[category.key.description].TOTAL}</td>
                                                    <td>${report.categoryScoreMap[category.key.description].PERCENTAGE}</td>
                                                    <th>${report.categoryScoreMap[category.key.description].GRADE}</th>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    </c:forEach>
                                </div>
                                                                
                                <br>
                                <div class="panel panel-primary">
                                    <div class="panel-heading">Test Questions</div>
                                    <br>
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                            <thead>
                                                <tr>
                                                    <th>Subcategory</th>
                                                    <th>Question</th>
                                                    <th>Result</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${report.test.testQuestions}" var="testQuestion">
                                                <tr>
                                                    <td>${testQuestion.question.subcategory.description}</td>
                                                    <td>${testQuestion.question.description}</td>
                                                    <td><c:out value="${testQuestion.result ? 'Correct': 'Wrong'}"/></td>
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
        <!--END PAGE CONTENT -->


    </div>

    <!--END MAIN WRAPPER -->

    <!-- FOOTER -->
    <div id="footer">
        <p>&copy; MUM &nbsp;2014 &nbsp;</p>
    </div>
    <!--END FOOTER -->

    <!-- GLOBAL SCRIPTS -->
    <script src="${pageContext.request.contextPath}/resources/plugins/jquery-2.0.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <!-- END GLOBAL SCRIPTS -->
    <!-- PAGE LEVEL SCRIPTS -->
    <script src="${pageContext.request.contextPath}/resources/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/dataTables/dataTables.bootstrap.js"></script>
    <script>
        $(document).ready(function() {
            $('#dataTables-example').dataTable();
        });
    </script>
    <!-- END PAGE LEVEL SCRIPTS -->
</body>
<!-- END BODY -->
</html>
