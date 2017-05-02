<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Category & Sub Category</title>
<script src="../resources/js/jquery-2.0.3.min.js"></script>
<script>
var categories = eval('('+'${categoriesJSON}'+')');

$(document).ready(function() {
    var subCat = {
		<c:forEach items="${categories}" var="category">
				'${category.categoryId}' : [{
    				<c:forEach items="${category.subCatCollection}" var="subcat">
    				'${subcat.subCategoryId}':'${subcat.description}',
    				</c:forEach>
				}],
    	</c:forEach>
    }

    $('#catId').on('change',function() {
		subCat1 = categories[$(this).val()-1].subCatCollection
		innerText = ""
    	$.each(subCat[$(this).val()], function( key, value ) {
    		$.each(value, function( key1, value1 ) {
    			innerText += '<input type="checkbox" name="subCatId" value="' + key1 + '"/>' + value1 + '<br/>';
    		})
    	})			
		
		$('#subCatCheckBox').html(innerText
//            subCat[$(this).val()].map(function() { 
//            		return '<input type="checkbox" name="subCat" value="' + this.id + '"/>' + this.key + '<br/>' 
//            	})

        );
    });
});
</script>
</head>

<body>
	<h1>You have reached to select Category & Sub Category page for your test. <br/></h1>
	<form:form action="${pageContext.request.contextPath}/test/selectCatSubcat"
		modelAttribute="selectCatSubcat" method="POST">
		<h3>Category :</h3>
	<form:select type="text" path="catId">
		<form:option value="0">--------Select Category------</form:option>
		<form:options items="${categories}" itemLabel="description"	itemValue="categoryId" />
	</form:select>
	<div id="subCatCheckBox"></div>
 	<br/>
 	<h3>Test data from DB</h3>
 	<table>
	<c:forEach items="${categories}" var="category">
		<tr>
			<td>${category.description}</td>
			<td>
				<c:forEach items="${category.subCatCollection}" var="subcat">
					${subcat.description}<br/>
				</c:forEach>
			</td>
		</tr>
	</c:forEach>
	</table>
		<h3>I'm done for selecting Category and Subcategory for the test.
			Send me to the test questions page.</h3>
		<br />
		<input type="submit" value="Yes, take me to the test" />
	</form:form>
</body>
</html>