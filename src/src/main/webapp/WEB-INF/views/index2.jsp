<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8" />
    <title>MUM Online Test Conducting System </title>
     <meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
     <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <!-- GLOBAL STYLES -->
    <link rel="stylesheet" href="resources/plugins/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="resources/css/main.css" />
    <link rel="stylesheet" href="resources/css/theme.css" />
    <link rel="stylesheet" href="resources/css/MoneAdmin.css" />
    <link rel="stylesheet" href="resources/plugins/Font-Awesome/css/font-awesome.css" />
    <!--END GLOBAL STYLES -->

    <!-- PAGE LEVEL STYLES -->
    <link href="resources/css/layout2.css" rel="stylesheet" />
       <link href="resources/plugins/flot/examples/examples.css" rel="stylesheet" />
       <link rel="stylesheet" href="resources/plugins/timeline/timeline.css" />
    <!-- END PAGE LEVEL  STYLES -->
     <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

    <!-- END HEAD -->

    <!-- BEGIN BODY -->
<body class="padTop53 " >

    <!-- MAIN WRAPPER -->
    <div id="wrap" >
        

        <!-- HEADER SECTION -->
        <div id="top">

            <nav class="navbar navbar-inverse navbar-fixed-top " style="padding-top: 10px;">
                <a data-original-title="Show/Hide Menu" data-placement="bottom" data-tooltip="tooltip" class="accordion-toggle btn btn-primary btn-sm visible-xs" data-toggle="collapse" href="#menu" id="menu-toggle">
                    <i class="icon-align-justify"></i>
                </a>
                <!-- LOGO SECTION -->
                <header class="navbar-header">

                    <a href="index.html" class="navbar-brand">
                    <img style="width: 50px; height: 40px;" src="resources/img/mum.png" alt="" />
                        
                        </a>
                </header>
                <!-- END LOGO SECTION -->
                <ul class="nav navbar-top-links navbar-right">

                    <!--ADMIN SETTINGS SECTIONS -->

                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="icon-user "></i>&nbsp; <i class="icon-chevron-down "></i>
                        </a>

                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#"><i class="icon-user"></i> User Profile </a>
                            </li>
                            <li><a href="#"><i class="icon-gear"></i> Settings </a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="login.html"><i class="icon-signout"></i> Logout </a>
                            </li>
                        </ul>

                    </li>
                    <!--END ADMIN SETTINGS -->
                </ul>

            </nav>

        </div>
        <!-- END HEADER SECTION -->



        <!-- MENU SECTION -->
       <div id="left" >
            <div class="media user-media well-small">
                <a class="user-link" href="#">
                    <img class="media-object img-thumbnail user-img" alt="User Picture" src="resources/img/user.gif" />
                </a>
                <br />
                <div class="media-body">
                    <h5 class="media-heading"> Joe Romlin</h5>
                
                </div>
                <br />
            </div>

            <ul id="menu" class="collapse">

                
                <li class="panel active">
                    <a href="index.html" >
                        <i class="icon-table"></i> Dashboard
                    </a>                   
                </li>

<!-- // COACH MENU -->
        <li class="panel">
              <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#coach-menu">
                  <i class="icon-user"></i> 
                        Coach
                        <span class="pull-right">
                            <i class="icon-angle-left"></i>
                        </span>
                          &nbsp; <span class="label label-warning">5</span>&nbsp;
                    </a>
                    <ul class="collapse" id="coach-menu">
                        <li><a href="#"><i class="icon-angle-right"></i> List Coach </a></li>
                        <li><a href="#"><i class="icon-angle-right"></i> Add Coach </a></li>
                    </ul>
                </li>
<!-- // STUDENTS MENU -->
        <li class="panel">
              <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#students-menu">
                  <i class="icon-user"></i> 
                        Student
                        <span class="pull-right">
                            <i class="icon-angle-left"></i>
                        </span>
                          &nbsp; <span class="label label-warning">5</span>&nbsp;
                    </a>
                    <ul class="collapse" id="students-menu">
                        <li><a href="#"><i class="icon-angle-right"></i> List Students </a></li>
                        <li><a href="#"><i class="icon-angle-right"></i> Add Student </a></li>
                    </ul>
                </li>
<!-- // Data Entry MENU -->
        <li class="panel">
              <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#manager-menu">
                  <i class="icon-user"></i> 
                        Data Manager
                        <span class="pull-right">
                            <i class="icon-angle-left"></i>
                        </span>
                          &nbsp; <span class="label label-warning">5</span>&nbsp;
                    </a>
                    <ul class="collapse" id="manager-menu">
                        <li><a href="#"><i class="icon-angle-right"></i> List Data Manager </a></li>
                        <li><a href="#"><i class="icon-angle-right"></i> Add Data Manager </a></li>
                    </ul>
                </li>
<!-- test menu -->
       <li class="panel">
                   <a href="test_result.html" >
                        <i class="icon-folder-open-alt"></i> Test Page
                    </a>                   
                </li>
       <li class="panel">
                   <a href="editUser.html" >
                        <i class="icon-folder-open-alt"></i> User
                    </a>                   
                </li>
       <li class="panel">
                   <a href="test_frontend.html" >
                        <i class="icon-folder-open-alt"></i> TEST UI
                    </a>                   
                </li>

                <li><a href="login.html"><i class="icon-signin"></i> Login  </a></li>

            </ul>

        </div>
        <!--END MENU SECTION -->



        <!--PAGE CONTENT -->
        <div id="content" class="col-lg-12">
             
            <div class="inner col-lg-12" style="min-height: 700px;">
                <div class="row">
                    <div class="col-lg-12">
                        <h1> Admin Dashboard </h1>
                    </div>
                </div>
                  <hr />
                 <!--BLOCK SECTION -->
                 <div class="row">
                    <div class="col-lg-12">
                        <div style="text-align: center;">
                           
                            <a class="quick-btn" href="#">
                                <i class="icon-check icon-2x"></i>
                                <span> Coach</span>
                                <span class="label label-danger">2</span>
                            </a>

                            <a class="quick-btn" href="#">
                                <i class="icon-envelope icon-2x"></i>
                                <span>Student</span>
                                <span class="label label-success">456</span>
                            </a>
                            <a class="quick-btn" href="#">
                                <i class="icon-signal icon-2x"></i>
                                <span>Test</span>
                                <span class="label label-warning">+25</span>
                            </a>
                        </div>

                    </div>

                </div>
                  <!--END BLOCK SECTION -->
                <hr />
                  



                 <!--TABLE, PANEL, ACCORDION AND MODAL  -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="box">
                            <header>
                                <h5>Recent Test</h5>
                                <div class="toolbar">
                                    <div class="btn-group">
                                        <a href="#sortableTable" data-toggle="collapse" class="btn btn-default btn-sm accordion-toggle minimize-box">
                                            <i class="icon-chevron-up"></i>
                                        </a>
                                    </div>
                                </div>
                            </header>
                            <div id="sortableTable" class="body collapse in">
                                <table class="table table-bordered sortableTable responsive-table">
                                    <thead>
                                        <tr>
                                            <th>#<i class="icon-sort"></i><i class="icon-sort-down"></i> <i class="icon-sort-up"></i></th>
                                            <th>Category<i class="icon-sort"></i><i class="icon-sort-down"></i> <i class="icon-sort-up"></i></th>
                                            <th>First Name<i class="icon-sort"></i><i class="icon-sort-down"></i> <i class="icon-sort-up"></i></th>
                                            <th>Last Name<i class="icon-sort"></i><i class="icon-sort-down"></i> <i class="icon-sort-up"></i></th>
                                            <th>Score<i class="icon-sort"></i><i class="icon-sort-down"></i> <i class="icon-sort-up"></i></th>
                                        </tr>
                                    </thead>
                                    <tbody>


                                        <tr>
                                            <td>1</td>
                                            <td>Java</td>
                                            <td>Jill</td>
                                            <td>Smith</td>
                                            <td>50</td>
                                        </tr>

                                        <tr>
                                            <td>2</td>
                                            <td>Java</td>
                                            <td>Eve</td>
                                            <td>Jackson</td>
                                            <td>94</td>
                                        </tr>

                                        <tr>
                                            <td>3</td>
                                            <td>Java</td>
                                            <td>John</td>
                                            <td>Doe</td>
                                            <td>80</td>
                                        </tr>

                                        <tr>
                                            <td>4</td>
                                            <td>Java</td>
                                            <td>Adam</td>
                                            <td>Johnson</td>
                                            <td>67</td>
                                        </tr>


                                    </tbody>
                                </table>
                            </div>
                        </div>
                        
                    </div>
                    <div class="col-lg-12">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                Short Info
                            </div>
                            <div class="panel-body">
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
                            </div>
                            <div class="panel-footer">
                                Panel Footer
                            </div>
                        </div>
                    </div>

                </div>
                 <!--TABLE, PANEL, ACCORDION AND MODAL  -->

                
            </div>

        </div>
        <!--END PAGE CONTENT -->

      
    </div>

    <!--END MAIN WRAPPER -->

    <!-- FOOTER -->
    <div id="footer">
        <p>&copy;  binarytheme &nbsp;2014 &nbsp;</p>
    </div>
    <!--END FOOTER -->


    <!-- GLOBAL SCRIPTS -->
    <script src="resources/plugins/jquery-2.0.3.min.js"></script>
     <script src="resources/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/plugins/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <!-- END GLOBAL SCRIPTS -->

    <!-- PAGE LEVEL SCRIPTS -->
    <script src="resources/plugins/flot/jquery.flot.js"></script>
    <script src="resources/plugins/flot/jquery.flot.resize.js"></script>
    <script src="resources/plugins/flot/jquery.flot.time.js"></script>
     <script  src="resources/plugins/flot/jquery.flot.stack.js"></script>
    <script src="resources/js/for_index.js"></script>
   
    <!-- END PAGE LEVEL SCRIPTS -->


</body>

    <!-- END BODY -->
</html>
