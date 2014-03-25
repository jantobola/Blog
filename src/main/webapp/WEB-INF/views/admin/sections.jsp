<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags/blog" prefix="blog"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>

<h3>Sections</h3>

<table class="table table-striped table-hover table-condensed">

	<thead>
		<tr class="center">
			<th style="text-align: left">Name</th>
			<th style="text-align: left">Description</th>
			<th>Created</th>
			<th>Author</th>
			<th>
				<c:if test="${empty id}">
					<a href="#addSection" data-toggle="modal"><button rel="tooltip" data-placement="top" title="Add section"><i class="icon-plus"></i></button></a>
				</c:if>
				<c:if test="${not empty id}">
					<c:url var="addInvokeUrl" value="/admin/articles/sections/show" />
					<a href="${addInvokeUrl}" data-toggle="modal"><button rel="tooltip" data-placement="top" title="Add section"><i class="icon-plus"></i></button></a>
				</c:if>
			</th>
		</tr>
	</thead>

	<c:forEach var="section" items="${sections.content}">
		<tr class="center">
			<td class="article_headline" style="text-align: left">${section.name}</td>
			<td class="article_headline" style="text-align: left">${section.description}</td>
			<td><util:date value="${section.creationDate}"
					patternCode="pattern.datetime.nosec" /></td>
			<td>${section.author.fullname}</td>
			<td><util:link href="/admin/articles/sections/${section.id}"><button rel="tooltip" data-placement="left" title="Edit"><i class="icon-edit"></i></button></util:link>
			<c:url value="/admin/articles/sections/${section.id}" var="deleteUrl" />

			<c:if test="${section.author.username != 'SYSTEM'}">
				<form class="inline_form" action="${deleteUrl}" method="post">
					<input type="hidden" name="_method" value="DELETE" />
					<button type="submit" rel="tooltip" data-placement="right"
						title="Delete">
						<i class="icon-remove"></i>
					</button>
				</form></td>
			</c:if>
		</tr>
	</c:forEach>
</table>

<!-- Modal -->

<div id="addSection" class="modal hide fade" tabindex="-1" role="dialog" aria-hidden="true">

	<c:url var="sectionUrl" value="/admin/articles/sections/${id}" />
	<form:form class="form" id="section-form" action="${sectionUrl}"
		modelAttribute="sectionForm" method="POST">

		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">Create new section</h3>
		</div>
		<div class="modal-body">

			<div class="form-group">
				<form:input type="text" placeholder="Name" path="name"
					cssClass="span2" id="focusMe" />
			</div>

			<div class="form-group">
				<form:input type="text" placeholder="Description" path="description"
					cssClass="span5" />
			</div>

		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			<button id="saveEventId" class="btn btn-primary">Save</button>
		</div>
	</form:form>
</div>

<util:pagination page="${sections}" />

<c:if test="${modalShow}">
	<script>
		$(document).ready(function() {
	    	$('#addSection').modal('show');
		});
	</script>
</c:if>

<script>
			$('#saveEventId').on("click", function() {
				$('#addSection').modal('hide');
			});
</script>