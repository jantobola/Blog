<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="value" type="java.util.Date" required="true"%>
<%@ attribute name="patternCode" required="false"%>

<c:choose>
	<c:when test="${empty patternCode}">
		<spring:message var="patternTranslated" code="pattern.date" text="yyyy/MM/dd" />
	</c:when>
	<c:otherwise>
		<spring:message var="patternTranslated" code="${patternCode}" text="yyyy/MM/dd" />
	</c:otherwise>
</c:choose>

<c:if test="${not empty value}">
	<fmt:formatDate value="${value}" pattern="${patternTranslated}" />
</c:if>

