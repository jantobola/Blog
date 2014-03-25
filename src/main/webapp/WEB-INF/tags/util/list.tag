<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://jantobola.cz/taglib/regexp/1.0" prefix="item"%>

<%@ attribute name="regexp" required="false"%>
<%@ attribute name="cssClass" required="false"%>

<c:url value="${href}" var="springUrl" />
<c:set var="requestUrl" value="${requestScope['javax.servlet.forward.servlet_path']}" />

<c:choose>
	<c:when test="${item:regexp(regexp,requestUrl)}">
		<c:if test="${not empty cssClass}"><li class="${cssClass} active"><jsp:doBody /></li></c:if>
		<c:if test="${empty cssClass}"><li class="active"><jsp:doBody /></li></c:if>
	</c:when>
	<c:otherwise>
		<c:if test="${not empty cssClass}"><li class="${cssClass}"><jsp:doBody /></li></c:if>
		<c:if test="${empty cssClass}"><li><jsp:doBody /></li></c:if>
	</c:otherwise>
</c:choose>
