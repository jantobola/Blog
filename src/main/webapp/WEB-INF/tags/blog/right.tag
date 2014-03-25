<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags/blog" prefix="blog"%>

<%@ attribute name="title" required="false"%>
<%@ attribute name="cssClass" required="false"%>

<div class="<c:if test='${empty cssClass}'>content_right</c:if>${cssClass}">
	<c:if test="${not empty title}">
		<h3>${title}</h3>
	</c:if>
	<jsp:doBody />
	<blog:space />
</div>
<div class="clear_both"></div>
