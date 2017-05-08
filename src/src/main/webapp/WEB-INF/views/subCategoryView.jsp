<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>SubCategory List</title>
</head>
<body>
	<h1>SubCategory List</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Category</th>
		</tr>
		<c:forEach var="subCategory" items="${list}">
			<tr>
				<td>${subCategory.subCatId}</td>
				<td>${subCategory.description}</td>
				<td>${subCategory.category.description}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="${pageContext.request.contextPath}/subCategory/subCategoryForm">Add
		SubCategory</a>
</body>
</html>
