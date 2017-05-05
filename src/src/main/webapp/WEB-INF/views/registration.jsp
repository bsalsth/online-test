<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Registration</title>

 
<link rel="stylesheet" href="resources/css/bootstrap.css" />
<link rel="stylesheet" href="resources/css/registration.css" />
 
</head>
<body>

	<div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title">Add User</small></h3>
			 			</div>
			 			<div class="panel-body">
			    		<form:form role="form" action="${pageContext.request.contextPath}/user/registration" modelAttribute="userForm" method="POST">
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			                <form:input type="text" path="firstName" id="first_name" class="form-control input-sm" placeholder="First Name"/>
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="text" path="lastName" id="last_name" class="form-control input-sm" placeholder="Last Name"/>
			    					</div>
			    				</div>
			    			</div>

			    			<div class="form-group">
			    				<form:input type="email" path="email" id="email" class="form-control input-sm" placeholder="Email Address"/>
			    			</div>
			    			
			    			<div class="form-group">
			    				<form:input type="text" path="userName" id="userName" class="form-control input-sm" placeholder="User Name"/>
			    			</div>

			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="password" path="password" id="password" class="form-control input-sm" placeholder="Password"/>
			    					</div>
			    				</div>
			    				 
			    			</div>
			    			
							<div class="form-group">
                                    <label for="filter">Role</label>
                                    <select class="form-control">
                              
                                        <option value="1">Admin</option>
                                        <option value="2">Coach</option>
                                        <option value="3">Database Manager</option>
                                         
                                    </select>
                                  </div>
							
							<div class="form-group">
                                    <label for="filter">Coach</label>
                                    <select class="form-control">
                              
                                        <option value="1">Jose</option>
                                        <option value="2">Minh</option>
                                        <option value="3">Govinda</option>
                                        <option value="4">Bishal</option>
                                    </select>
                                  </div>

			    			
			    			<input type="submit" value="Register" class="btn btn-info btn-block">
			    		
			    		</form:form>
			    	</div>
	    		</div>
    		</div>
    	</div>
    </div>
    
</body>
</html>