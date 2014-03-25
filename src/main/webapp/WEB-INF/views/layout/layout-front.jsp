<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags/blog" prefix="blog"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>

<c:set var="res" value="${pageContext.request.contextPath}/resources" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<title><c:if test="${empty title}">Jan Tobola</c:if>${title}</title>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	
	<link rel="stylesheet" type="text/css" href="${res}/fancyBox/source/jquery.fancybox.css?v=2.1.5" media="screen" />
	<link rel="stylesheet" type="text/css" href="${res}/fancyBox/source/helpers/jquery.fancybox-buttons.css?v=1.0.5" />
	<link rel="stylesheet" type="text/css" href="${res}/fancyBox/source/helpers/jquery.fancybox-thumbs.css?v=1.0.7" />

	<link href="${res}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="${res}/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
	<link href="${res}/css/style.css" rel="stylesheet" type="text/css" />
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	
</head>

<body>
	<div class="container">
		<div class="header ${theme_header}">
			<div class="headline_main">
				<h1><util:link href="/">JAN TOBOLA</util:link></h1>
				<h2>PROGRAMMER &amp; ANALYST</h2>
			</div>
			<div class="menu">
				<ul>
					<li><util:link href="/" regexp="/">HOME</util:link></li>
					<li><util:link href="/about" regexp="/about(.*)">ABOUT ME</util:link></li>
					<li><util:link href="/blog" regexp="/blog(.*)">BLOG</util:link></li>
					<li><util:link href="/contact" regexp="/contact(.*)">CONTACT</util:link></li>
				</ul>
			</div>
		</div>

		<div class="content_container">

			<tiles:insertAttribute name="content" />

		</div>

		<div class="footer ${theme_footer}">
			<p class="footer_text">
				<span>&copy; 2013 by Jan Tobola. All rights reserved.</span> <span
					class="right"><util:link href="/admin"><img src="${res}/img/key.png" alt="" width="10px" height="10px" />&nbsp;Administration</util:link></span>
			</p>
		</div>

	</div>
	
	<script type="text/javascript" src="${res}/fancyBox/lib/jquery.mousewheel-3.0.6.pack.js"></script>
	<script type="text/javascript" src="${res}/fancyBox/source/jquery.fancybox.js?v=2.1.5"></script>
	<script type="text/javascript" src="${res}/fancyBox/source/helpers/jquery.fancybox-buttons.js?v=1.0.5"></script>
	<script type="text/javascript" src="${res}/fancyBox/source/helpers/jquery.fancybox-thumbs.js?v=1.0.7"></script>
	<script type="text/javascript" src="${res}/fancyBox/source/helpers/jquery.fancybox-media.js?v=1.0.6"></script>
	
	<script src="${res}/js/jquery.placeholder.min.js"></script>
	<script src="${res}/js/bootstrap.min.js"></script>
	
</body>
</html>