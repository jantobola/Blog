<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags/blog" prefix="blog"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>

<c:set var="res" value="${pageContext.request.contextPath}/resources" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><c:if test="${empty title}">Blog Administration</c:if>${title}</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="${res}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="${res}/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="http://blueimp.github.io/Gallery/css/blueimp-gallery.min.css" type="text/css" />
	<link rel="stylesheet" href="${res}/fileUpload/css/jquery.fileupload-ui.css" type="text/css" />
	<link href="${res}/css/style.css" rel="stylesheet" type="text/css" />
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="${res}/ckeditor/ckeditor.js"></script>
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">

		<div class="content_container">

			<blog:content>
				<blog:ribbon>
					<h3>ADMINISTRATION</h3>
				</blog:ribbon>
				
				<blog:button title="HOME" link="/" />
				<blog:button title="BLOG" link="/blog" />
				
				<blog:right cssClass="wider">

					<sec:authorize access="isAuthenticated()">
						<div class="admin_menu right">
							<ul class="nav nav-tabs">
								<util:list regexp="/admin/overview(.*)">
									<util:link href="/admin/overview">Overview</util:link>
								</util:list>

								<util:list cssClass="dropdown" regexp="/admin/article(.*)">
									<a href="" data-toggle="dropdown" class="dropdown-toggle">Articles<span
										class="caret"></span></a>

									<ul class="dropdown-menu" role="menu">
										<util:list>
											<util:link href="/admin/articles">Overview</util:link>
											<util:link href="/admin/article">New article</util:link>
											<util:link href="/admin/articles/sections">Sections</util:link>
										</util:list>
									</ul>
								</util:list>

<%-- 								<util:list regexp="/admin/sections(.*)"> --%>
<%-- 									<util:link href="/admin/static">Sections</util:link> --%>
<%-- 								</util:list> --%>

								<util:list cssClass="dropdown" regexp="/admin/settings(.*)">
									<a href="" data-toggle="dropdown" class="dropdown-toggle">Administration<span
										class="caret"></span></a>

									<ul class="dropdown-menu" role="menu">
										<util:list>
											<util:link href="/j_spring_security_logout">Logout</util:link>
										</util:list>
									</ul>
								</util:list>

							</ul>
						</div>
					</sec:authorize>

					<div class="clear_both"></div>

					<util:flash />

					<div class="admin_content">
						<tiles:insertAttribute name="content" />
					</div>

				</blog:right>
				
			</blog:content>

		</div>

	</div>
	
	<script src="${res}/js/jquery.placeholder.min.js"></script>
	
	<script>
 		$('input[placeholder], textarea[placeholder]').placeholder();
 		$("[rel=tooltip]").tooltip();
  	</script>
  	
</body>
</html>