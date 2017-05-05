<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


	<table border=1>
		<c:forEach items="${userModel}" var="user">
			<tr>
				<td>${user.userName} ${user.email} </td>
			</tr>
		</c:forEach>
	</table>

	<a href="./test">Student Test Front Page</a>
	
	<a href="./user">Sign Up</a>
	
	<a href="./login">Login</a>
	
	<a href="./studentLogin">Student Login</a>
	
	<a href="./coach/sendEmail">SendEmail</a>
</body>
</html>
