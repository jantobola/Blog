<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags/blog" prefix="blog"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>

<h3>Articles</h3>

<c:if test="${empty page.content}">
	<p class="well">No public articles released.</p>
</c:if>

<c:if test="${not empty page.content}">
<table class="table table-striped table-hover table-condensed">
	
	<thead>
		<tr class="center">
			<th>#id</th>
			<th style="text-align: left">Headline</th>
			<th>Author</th>
			<th>Created</th>
			<th>Section</th>
			<th>Last edit</th>
			<th>Editor</th>
			<th>Edited</th>
			<th>Action</th>
		</tr>
	</thead>
	
	<c:forEach var="article" items="${page.content}">
		<tr class="center">
			<td>${article.id}</td>
			<td class="article_headline" style="text-align: left">${article.headline}</td>
			<td>${article.author.fullname}</td>
			<td><util:date value="${article.creationDate}" patternCode="pattern.datetime.nosec" /></td>
			<td>${article.section.name}</td>
			<td><util:date value="${article.lastChange}" patternCode="pattern.datetime.nosec" /></td>
			<td>${article.editor.fullname}</td>
			<td>${article.editCount}x</td>
			<td>
				<util:link href="/blog/${article.id}"><button rel="tooltip" data-placement="left" title="View"><i class="icon-eye-open"></i></button></util:link>
				<util:link href="/admin/article/${article.id}"><button rel="tooltip" data-placement="top" title="Edit"><i class="icon-edit"></i></button></util:link>
				
				<c:url value="/admin/article/${article.id}" var="deleteUrl" />
				
				<form class="inline_form" action="${deleteUrl}" method="post">
					<input type="hidden" name="_method" value="DELETE"/>
					<button type="submit" rel="tooltip" data-placement="right" title="Delete"><i class="icon-remove"></i></button>
				</form>
			</td>
		</tr>	
	</c:forEach>
</table>

<util:pagination page="${page}" />
</c:if>

<h3>Drafts</h3>

<c:if test="${empty concepts.content}">
	<p class="well">No drafts at this moment.</p>
</c:if>

<c:if test="${not empty concepts.content}">
<table class="table table-striped table-hover table-condensed">
	
	<thead>
		<tr class="center">
			<th>#id</th>
			<th style="text-align: left">Headline</th>
			<th>Author</th>
			<th>Created</th>
			<th>Section</th>
			<th>Last edit</th>
			<th>Editor</th>
			<th>Edited</th>
			<th>Action</th>
		</tr>
	</thead>
	
	<c:forEach var="article" items="${concepts.content}">
		<tr class="center">
			<td>${article.id}</td>
			<td class="article_headline" style="text-align: left">${article.headline}</td>
			<td>${article.author.fullname}</td>
			<td><util:date value="${article.creationDate}" patternCode="pattern.datetime.nosec" /></td>
			<td>${article.section.name}</td>
			<td><util:date value="${article.lastChange}" patternCode="pattern.datetime.nosec" /></td>
			<td>${article.editor.fullname}</td>
			<td>${article.editCount}x</td>
			<td>
				<util:link href="/blog/${article.id}"><button rel="tooltip" data-placement="left" title="View"><i class="icon-eye-open"></i></button></util:link>
				<util:link href="/admin/article/${article.id}"><button rel="tooltip" data-placement="top" title="Edit"><i class="icon-edit"></i></button></util:link>
				
				<c:url value="/admin/article/${article.id}" var="deleteUrl" />
				
				<form class="inline_form" action="${deleteUrl}" method="post">
					<input type="hidden" name="_method" value="DELETE"/>
					<button type="submit" rel="tooltip" data-placement="right" title="Delete"><i class="icon-remove"></i></button>
				</form>
			</td>
		</tr>	
	</c:forEach>
</table>

<util:pagination page="${concepts}" />
</c:if>