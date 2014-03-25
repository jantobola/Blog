<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags/blog" prefix="blog"%>
<%@ taglib uri="http://jantobola.cz/taglib/regexp/1.0" prefix="item"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>

<c:url var="res" value="/resources" />

<c:forEach var="article" items="${articles.content}">
	<blog:content ribbon="${article.headline}">

		<blog:left cssClass="content_left center">
			<c:choose>
				<c:when test="${not empty article.resource and item:regexp('(.*)youtube(.*)', article.resource)}">
					<iframe width="480" height="270" src="${article.resource}?rel=0" frameborder="0" allowfullscreen></iframe>
				</c:when>
				
				<c:when test="${empty article.resource}">
					<img src="${res}/img/book.jpg" alt="" />
				</c:when>
				
				<c:otherwise>
					<img src="${article.resource}" class="article_thumb" alt="" />
				</c:otherwise>
			</c:choose>
		</blog:left>

		<blog:right>
			${article.content}

			<blog:space />
			<blog:button title="READ MORE" link="/blog/${article.url}" />
			<blog:meta author="${article.author.fullname}" date="${article.creationDate}" section="${article.section.name}" />
		</blog:right>

	</blog:content>
</c:forEach>
			
<util:pagination page="${articles}" />