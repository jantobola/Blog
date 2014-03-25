<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags/blog" prefix="blog"%>


	<div class="well login_container">
		<form id="login-form" action="<spring:url value='/j_spring_security_check' />" method="post">
			
				<div class="controls">
					<input type="text" placeholder="Username" id="username" name="j_username" />
				</div>
			
				<div class="controls">
					<input type="password" placeholder="Password" id="password" name="j_password" />
				</div>
			
    			<div class="controls">
    				<label class="checkbox left">
        				<input type="checkbox" name="_spring_security_remember_me" /> Remember me
     				</label>
     				<button type="submit" class="btn right">Sign in</button>
    			</div>
    			
    			<div class="clear_both"></div>
		</form>
	</div>