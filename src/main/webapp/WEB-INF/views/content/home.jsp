<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags/blog" prefix="blog"%>

<c:url var="res" value="/resources" />

<blog:content>

	<blog:left title="ABOUT ME" cssClass="content_left">
		<p>
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce id imperdiet tortor, non bibendum augue. Vestibulum feugiat venenatis risus, vitae dignissim augue. Proin eu bibendum ante. Phasellus porta urna vitae vehicula tincidunt. Praesent tempus justo urna. In auctor eget lectus a porta. Donec ultricies augue non urna convallis, nec commodo est pellentesque.
		</p>

		<blog:button title="READ MORE" link="/about" />
		<blog:space />
	</blog:left>

	<blog:right title="VISIT MY BLOG" cssClass="content_right">
		<p>
			Integer libero mauris, lobortis ac convallis nec, fermentum quis nibh. Donec tincidunt magna eu leo congue iaculis. Nullam laoreet tempus nibh et imperdiet. Suspendisse ac sagittis ipsum. Suspendisse eget quam vitae lorem vestibulum viverra sit amet sed eros. Donec bibendum ligula vitae enim sagittis, at pharetra tortor cursus. Nulla a odio vel est vehicula iaculis fringilla non magna.
		</p>

		<blog:button title="VISIT MY BLOG" link="/blog" />
		<blog:space />
	</blog:right>

</blog:content>