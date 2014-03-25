package cz.jantobola.blog.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

	public static void createCookie(HttpServletResponse response, String cookieName, String value, int age) {
		Cookie cookie = new Cookie(cookieName, value);
		cookie.setMaxAge(age);
		response.addCookie(cookie);
	}
	
	public static void deleteCookie(HttpServletResponse response, String cookieName) {
		Cookie cookie = new Cookie(cookieName, null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
}
