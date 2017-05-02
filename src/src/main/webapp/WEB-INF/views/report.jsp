<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<h1>Score Report</h1>
<p><b>Test Results for:</b> ${report.user.firstName} ${report.user.lastName}</p>
<p><b>Test Date:</b> <fmt:formatDate pattern="MM/dd/yyyy" value="${report.test.testDate}"/></p>

<form:form>
  <c:forEach items="${report.score}" var="category">
    <table border=1>
      <tr><td colspan="5"><b>Category:</b> ${category.key.description}</td></tr>
      <tr>
        <th>SubCategory</th>
        <th>Number of Correct</th>
        <th>Number of Incorrect</th>
        <th>Number of Questions</th>
        <th>Total Percentage</th>
      </tr>
      <c:forEach items="${category.value}" var="subcategory">
        <tr>
          <td>${subcategory.key.description}</td>
          <td align="center">${subcategory.value.CORRECT}</td>
          <td align="center">${subcategory.value.INCORRECT}</td>
          <td align="center">${subcategory.value.TOTAL}</td>
          <td align="center">${subcategory.value.PERCENTAGE}</td>
        </tr>
      </c:forEach>
      <tr>
        <th align="left">Total</th>
        <td align="center">${report.categoryScoreMap[category.key.description].CORRECT}</td>
        <td align="center">${report.categoryScoreMap[category.key.description].INCORRECT}</td>
        <td align="center">${report.categoryScoreMap[category.key.description].TOTAL}</td>
        <td align="center">${report.categoryScoreMap[category.key.description].PERCENTAGE}</td>
      </tr>
    </table><br>
  </c:forEach>
</form:form>

</body>
</html>
