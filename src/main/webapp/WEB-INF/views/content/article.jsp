<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags/blog" prefix="blog"%>

<c:url var="res" value="/resources" />

<blog:content>

	<blog:ribbon>
		<h3>${article.headline}</h3>
	</blog:ribbon>

	<blog:right cssClass="wide">
			${article.content}
			
			<blog:space />
			<blog:gallery items="${article.mediaFiles}" />
			
			<blog:space />
			<blog:meta author="${article.author.fullname}" date="${article.creationDate}" section="${article.section.name}" />
	</blog:right>
	
</blog:content>