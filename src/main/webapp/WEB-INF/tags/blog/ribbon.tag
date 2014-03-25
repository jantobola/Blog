<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ attribute name="cssClass" required="false"%>

<div class="<c:if test='${empty cssClass}'>ribbon_container_float</c:if>${cssClass}">
	<div class="ribbon">
		<jsp:doBody />
	</div>

	<div class="clear_left"></div>
	<div class="ribbon_append"></div>
</div>