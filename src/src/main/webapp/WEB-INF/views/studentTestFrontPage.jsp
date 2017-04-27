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
			<tr>
				<td>Session Key</td>
				<td>Test Date</td>
			</tr>
			<c:forEach items="${testModel}" var="test">
			<tr>
				<td>${test.sessionKey}</td>
				<td>{test.date}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
