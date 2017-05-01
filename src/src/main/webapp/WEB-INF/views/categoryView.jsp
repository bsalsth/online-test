<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Category List</h1>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="category" items="${list}">
		<tr>
			<%-- <td>${category.catId}</td> --%>
			<td>${category.description}</td>
			<%-- <td><a href="editCategory/${category.catId}">Edit</a></td>
			<td><a href="deleteCategory/${category.catId}">Delete</a></td> --%>
		</tr>
	</c:forEach>
</table>
<br />
<a href="${pageContext.request.contextPath}/category/categoryForm">Add
	Category</a>