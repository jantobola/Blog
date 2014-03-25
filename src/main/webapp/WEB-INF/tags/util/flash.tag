<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>

<c:if test="${not empty errorMsg}">
	<div class="alert alert-error fade in">
		<a class="close" data-dismiss="alert">×</a>
		<h4 class="alert-heading">
			<util:message code="alert.error.title" />
		</h4>
		${errorMsg}
	</div>
</c:if>

<c:if test="${not empty warningMsg}">
	<div class="alert alert-warning fade in">
		<a class="close" data-dismiss="alert">×</a>
		<h4 class="alert-heading">
			<util:message code="alert.warning.title" />
		</h4>
		${warningMsg}
	</div>
</c:if>

<c:if test="${not empty infoMsg}">
	<div class="alert alert-info fade in">
		<a class="close" data-dismiss="alert">×</a>
		<h4 class="alert-heading">
			<util:message code="alert.info.title" />
		</h4>
		${infoMsg}
	</div>
</c:if>

<c:if test="${not empty successMsg}">
	<div class="alert alert-success fade in">
		<a class="close" data-dismiss="alert">×</a>
		<h4 class="alert-heading">
			<spring:message code="alert.success.title" />
		</h4>
		${successMsg}
	</div>
</c:if>