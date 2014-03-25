<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags/blog" prefix="blog"%>

<c:url var="res" value="/resources" />

			<blog:content ribbon="CONTACT">

				<blog:left cssClass="content_left center">
					<iframe width="425" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.cz/maps?f=q&amp;source=s_q&amp;hl=cs&amp;geocode=&amp;q=praska%C4%8Dka+121&amp;aq=&amp;sll=49.803763,15.474913&amp;sspn=5.758725,16.907959&amp;t=m&amp;brcurrent=5,0,0&amp;ie=UTF8&amp;hq=&amp;hnear=Praska%C4%8Dka+121,+503+33+Praska%C4%8Dka&amp;ll=50.189649,15.744953&amp;spn=0.038467,0.072956&amp;z=13&amp;iwloc=A&amp;output=embed"></iframe><br /><small><a href="https://maps.google.cz/maps?f=q&amp;source=embed&amp;hl=cs&amp;geocode=&amp;q=praska%C4%8Dka+121&amp;aq=&amp;sll=49.803763,15.474913&amp;sspn=5.758725,16.907959&amp;t=m&amp;brcurrent=5,0,0&amp;ie=UTF8&amp;hq=&amp;hnear=Praska%C4%8Dka+121,+503+33+Praska%C4%8Dka&amp;ll=50.189649,15.744953&amp;spn=0.038467,0.072956&amp;z=13&amp;iwloc=A" style="color:#0000FF;text-align:left">Zvětšit mapu</a></small>
				</blog:left>

				<blog:right title="Contact me...">
					<p>
						<strong>Phone:</strong> +420 774 999 392
					</p>
					<p>
						<strong>Email:</strong> jan.tobola@email.cz
					</p>

				</blog:right>

			</blog:content>