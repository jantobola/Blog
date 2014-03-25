<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags/blog" prefix="blog"%>

<c:url var="articleUrl" value="/admin/article" />
<c:if test="${not empty id}">
	<c:url var="articleUrl" value="/admin/article/${id}" />
</c:if>

<h3>Article informations</h3>

<form:form class="well form" id="article-form" action="${articleUrl}" modelAttribute="articleForm" method="POST">

	<div>
		<div class="form-group">
			<form:input type="text" placeholder="Headline" path="headline" cssClass="span5" />
		</div>

		<div class="form-group">
			<form:input type="text" placeholder="Third party resource (URL of an image or Youtube video)" path="resource" cssClass="span4" />
		</div>

		<div class="form-group">
			<form:select path="sectionId" items="${sections}" itemLabel="name" itemValue="id" />
		</div>

		<div class="form-group">
			<form:input type="text" placeholder="URL - will be generated" path="url" disabled="true" />
		</div>
		
	</div>

	<div class="controls">
		<form:textarea path="content"></form:textarea>
		<script>
			CKEDITOR.replace('content');
		</script>
		
		<blog:space />
		
		<span class="right">
			<label class="radio inline">
				<form:radiobutton path="concept" value="true" />
				Draft
			</label>
			<label class="radio inline">
				<form:radiobutton path="concept" value="false" />
				Public
			</label>
			
			<form:hidden path="id" />
			<button type="submit" class="btn">Save</button>
		</span>
	</div>
	
	<div class="clear_both"></div>
	
</form:form>
	
<h3>Article Gallery</h3>
<blog:upload target="/admin/processUpload/${articleForm.id}" numFiles="2"/>
