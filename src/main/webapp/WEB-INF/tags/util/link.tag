<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://jantobola.cz/taglib/regexp/1.0" prefix="item"%>

<%@ attribute name="regexp" required="false"%>
<%@ attribute name="href" required="true"%>

<c:url value="${href}" var="springUrl" />
<c:set var="requestUrl" value="${requestScope['javax.servlet.forward.servlet_path']}" />

<c:choose>
	<c:when test="${item:regexp(regexp,requestUrl)}">
		<a href="${springUrl}" class="active"><jsp:doBody /></a>
	</c:when>
	<c:otherwise>
		<a href="${springUrl}"><jsp:doBody /></a>
	</c:otherwise>
</c:choose>
