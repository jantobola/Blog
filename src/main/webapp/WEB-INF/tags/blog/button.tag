<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ attribute name="title" required="true"%>
<%@ attribute name="link" required="true"%>

<c:url value="${link}" var="springUrl" />
<a href="${springUrl}" class="blog_button">${title}</a>

