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
                            <div class="panel-heading"><strong class="primary-font">Student Tests</strong></div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover"
                                        id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th>First Name</th>
                                                <th>Last Name</th>
                                                <th>Test Date</th>
                                                <th>View</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${test.list}" var="test">
                                            <tr>
                                                <td>${test.user.firstName}</td>
                                                <td>${test.user.lastName}</td>
                                                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${test.testDate}"/></td>
                                                <td><a href="${pageContext.request.contextPath}/report?userId=${test.user.userId}&sessionKey=${test.sessionKey}"><i class="icon-eye-open"></i></a></td>
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
