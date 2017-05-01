<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit Category</h1>
<form:form method="POST" action="${pageContext.request.contextPath}/category/editSaveCategory">
	<table>
		<tr>
			<td></td>
			<td><form:hidden path="catId" /></td>
		</tr>
		<tr>
			<td>Name :</td>
			<td><form:input path="description" /></td>
		</tr>

		<tr>
			<td></td>
			<td><input type="submit" value="Edit" /></td>
		</tr>
	</table>
</form:form>
