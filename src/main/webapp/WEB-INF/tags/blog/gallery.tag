<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ attribute name="items" type="java.util.List" required="true"%>

<c:set var="res" value="${pageContext.request.contextPath}/resources" />

<c:forEach var="item" items="${items}">
	
		<a class="fancybox gallery" rel="gallery" href="${item.url}" title="${item.name}"><img class="gallery img-rounded" src="${item.thumbnailUrl}" alt="" /></a>

</c:forEach>

<script>

$(document).ready(function() {
	$(".fancybox").fancybox({
    	openEffect	: 'elastic',
    	closeEffect	: 'elastic',

    	helpers : {
    		title : {
    			type : 'inside'
    		}
    	}
    });
});

</script>