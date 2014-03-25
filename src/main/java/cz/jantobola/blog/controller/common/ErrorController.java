package cz.jantobola.blog.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author Jan Tobola
 * 
 */
@Controller
public class ErrorController extends AbstractController {
	
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String error404(Model model, HttpServletRequest request) {
		model.addAttribute("errorCode", "NOT FOUND");
		return "error/404";
	}
	
	// Nevim, nekdy mozna pouziju ...
	// @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	// public String accessDenied(Model model, RedirectAttributes ra,
	// HttpServletRequest request) {
	//
	// String referer = request.getHeader("Referer");
	// Enumeration<?> from = request.getHeaderNames();
	//
	// while (from.hasMoreElements()) {
	// System.out.println(from.nextElement().toString());
	//
	// }
	//
	// System.out.println(from);
	//
	// info(ra, "Již jste přihlášen.");
	// return "redirect:" + referer;
	// }
}
