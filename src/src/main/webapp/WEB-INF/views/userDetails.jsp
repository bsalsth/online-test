<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		 <h4>The user details have been saved.</h4>
    
        <h5>Details:</h5>
        <p>
        First Name: ${userForm.firstName}<br/>
        Last Name: ${userForm.lastName}<br/>
        Email: ${userForm.email}<br/>
        UserName: ${userForm.userName}<br/>
        
       
        </p>
        <form action="/user/edit" method="post">
Choose your favorite subject:
<button name="subject" type="submit" value="EditUser">Edit</button>
</form>
     

</body>
</html>