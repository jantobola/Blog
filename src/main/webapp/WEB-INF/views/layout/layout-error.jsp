<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags/blog" prefix="blog"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><c:if test="${empty title}">Error occured</c:if>${title}</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<c:set var="res" value="${pageContext.request.contextPath}/resources" />

<link href="${res}/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="${res}/css/bootstrap-responsive.min.css" rel="stylesheet"
	type="text/css" />
<link href="${res}/css/style.css" rel="stylesheet" type="text/css" />

</head>

<body>
	<div class="container">
		<div class="content_container">

			<tiles:insertAttribute name="content" />

		</div>
	</div>

	<script src="${res}/js/jquery-1.9.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<script src="${res}/js/jquery.placeholder.min.js"></script>

</body>
</html>