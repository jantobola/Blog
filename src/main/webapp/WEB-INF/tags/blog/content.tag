<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ attribute name="ribbon" required="false"%>

<div class="content_table">
	<c:if test="${not empty ribbon}">
		<div class="ribbon">
			<h3>${ribbon}</h3>
		</div>

		<div class="clear_left"></div>
		<div class="ribbon_append"></div>
		<div class="clear_left"></div>
	</c:if>
	<jsp:doBody />
</div>
<div class="content_shadow"></div>
