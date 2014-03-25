<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ attribute name="page" type="org.springframework.data.domain.Page"
	required="true"%>

<c:set var="currPage" value="${page.number + 1}" />
<c:set var="perPage" value="5" />

<spring:url value="" var="next">
	<spring:param name="page.page" value="${currPage + 1}"></spring:param>
	<spring:param name="page.size" value="${page.size}"></spring:param>
</spring:url>

<spring:url value="" var="previous">
	<spring:param name="page.page" value="${currPage - 1}"></spring:param>
	<spring:param name="page.size" value="${page.size}"></spring:param>
</spring:url>

<div class="pagination pagination-centered">
	<ul>

		<c:choose>
			<c:when test="${page.firstPage}">
				<li class="disabled"><a href="">«</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${previous}">«</a></li>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${page.totalPages <= perPage}">
				<c:forEach begin="1" end="${page.totalPages}" varStatus="counter">
					<spring:url value="" var="custom">
						<spring:param name="page.page" value="${counter.count}"></spring:param>
						<spring:param name="page.size" value="${page.size}"></spring:param>
					</spring:url>

					<c:choose>
						<c:when test="${currPage eq counter.count}">
							<li class="active"><a href="">${counter.count}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${custom}">${counter.count}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:when>

			<c:when test="${page.totalPages > perPage}">
				<c:forEach begin="1" end="${perPage - 1}" varStatus="counter">
					<spring:url value="" var="custom">
						<spring:param name="page.page" value="${counter.count}"></spring:param>
						<spring:param name="page.size" value="${page.size}"></spring:param>
					</spring:url>

					<c:choose>
						<c:when test="${currPage eq counter.count}">
							<li class="active"><a href="">${counter.count}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${custom}">${counter.count}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<spring:url value="" var="lastPage">
					<spring:param name="page.page" value="${page.totalPages}"></spring:param>
					<spring:param name="page.size" value="${page.size}"></spring:param>
				</spring:url>

				<li><a href="#">...</a></li>

				<c:choose>
					<c:when test="${currPage eq page.totalPages}">
						<li class="active"><a href="${lastPage}">${page.totalPages}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${lastPage}">${page.totalPages}</a></li>
					</c:otherwise>
				</c:choose>

			</c:when>

			<c:otherwise>

			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${page.lastPage}">
				<li class="disabled"><a href="">»</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${next}">»</a></li>
			</c:otherwise>
		</c:choose>

	</ul>
</div>