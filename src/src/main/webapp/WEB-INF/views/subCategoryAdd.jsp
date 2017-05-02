<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add SubCategory</h1>
<form:form method="post"
	action="${pageContext.request.contextPath}/subCategory/saveSubCategory">
	<table>
		<tr>

			<td>Category :</td>


			<td><form:select path="description">

					<form:option value="" label="...." />

					<form:options items="${categoryList}" />

				</form:select></td>

			<td>SubCategory :</td>
			<td><form:input path="description" /></td>
		</tr>

		<tr>
			<td></td>
			<td><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form:form>
