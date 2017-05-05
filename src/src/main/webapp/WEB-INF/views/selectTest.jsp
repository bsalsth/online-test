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


    <!-- BEGIN BODY -->
<body class=" " >

   <!-- PAGE CONTENT --> 
    <div class="container">
    <div class="text-center">
        <img style="width: 180px; height: 150px;" src="resources/img/mum.png" id="logoimg" alt=" Logo" />
    </div>
    <div class="tab-content">
        <div id="login" class="tab-pane active">
        <form class="form-horizontal">

                               <div class="form-group">    
                                        <label  class="control-label col-lg-4">Select Category</label>
                                        <div class="col-lg-6">
                                            <select class="form-control">
                                                <option value="1">Java</option>
                                                <option>Dot Net</option>
                                            </select>
                                        </div>
                                    </div>

                                             <div class="form-group">    
                                        <label  class="control-label col-lg-4">Select Sub Category</label>
                                        <div class="col-lg-6">
                                            <select class="form-control">
                                                <option value="1">J2EE</option>
                                                <option>Dot Net</option>
                                            </select>
                                        </div>
                                    </div>
                <div class="form-group pull-right">
                    <div class="col-lg-8">
                         <a href="#" class="btn btn-primary">Next</a>
                    </div>
                </div>
            </form>
        </div>



</div>
</div>

     <!--END MAIN WRAPPER -->

   <!-- FOOTER -->
    <div id="footer">
        <p>&copy;  MUM ONLINE  &nbsp;TEST &nbsp;</p>
    </div>
    <!--END FOOTER -->


     <!-- GLOBAL SCRIPTS -->
    <script src="resources/plugins/jquery-2.0.3.min.js"></script>
     <script src="resources/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/plugins/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <!-- END GLOBAL SCRIPTS -->
     
</body>
    <!-- END BODY -->
</html>
