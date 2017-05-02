<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add Category</h1>
<form:form method="post"
	action="${pageContext.request.contextPath}/category/saveCategory">
	<table>
		<tr>
			<td>Name :</td>
			<td><form:input path="description" /></td>
		</tr>

		<tr>
			<td></td>
			<td><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form:form>
