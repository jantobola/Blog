<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags/blog" prefix="blog"%>

			<blog:content ribbon="PAGE NOT FOUND">

				<blog:left cssClass="content_left" title="Requested page no longer exists on this site...">
					Stránka, kterou hledáte neexistuje
				</blog:left>

				<blog:right title="Možná jste hledali:">
					<p>
							Lorem ipsum dolor sit amet, consectetur adipiscing elit. In porta justo et dui cursus non aliquam nisi aliquam. In porta justo et dui cursus non aliquam nisi aliquam. In porta justo et dui cursus non aliquam nisi aliquam. In porta justo et dui cursus non aliquam nisi aliquam. Cras commodo sem at neque tempor at semper nunc vehicula...
					</p>

					<blog:space />
					<blog:button title="READ MORE" link="#" />
					<blog:space />
				</blog:right>

			</blog:content>