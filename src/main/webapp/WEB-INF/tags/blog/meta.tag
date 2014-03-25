<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>

<%@ attribute name="author" required="false"%>
<%@ attribute name="date" required="false" type="java.util.Date"%>
<%@ attribute name="section" required="false"%>

<div class="content_data">
	<p>
		<span>${author}, <util:date value="${date}" /></span>
	</p>
	
	<p>
		<span>Section: ${section}</span>
	</p>
</div>
<div class="clear_both"></div>
