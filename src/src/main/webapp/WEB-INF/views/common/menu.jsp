	<!-- MENU SECTION -->
		<c:if test="${sessionScope.currentRole == 'Coach'}">
		<%@ include file="/WEB-INF/views/common/Coach/menu.jsp"%>
		</c:if>
		<c:if test="${sessionScope.currentRole == 'Admin'}">
		<%@ include file="/WEB-INF/views/common/Admin/menu.jsp"%>
		</c:if>
		<c:if test="${sessionScope.currentRole == 'DataManager'}">
		<%@ include file="/WEB-INF/views/common/DataManager/menu.jsp"%>
		</c:if>
		<!--END MENU SECTION -->