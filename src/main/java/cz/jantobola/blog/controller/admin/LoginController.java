package cz.jantobola.blog.controller.admin;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cz.jantobola.blog.controller.common.AbstractController;

/**
 * @author Jan Tobola
 * 
 */
@Controller
public class LoginController extends AbstractController {
	
	@RequestMapping(value = "/admin/login")
	public String login(Model model) {
		return "admin/login";
	}
	
	@RequestMapping(value = "/admin/logout")
	public String logout(Model model, RedirectAttributes ra) {
		info(ra, "alert.info.logout.success");
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/admin/loginfailed")
	public String loginfailed(Model model, RedirectAttributes ra) {
		error(ra, "alert.error.login.failed");
		
		return "redirect:/admin/login";
	}
	
	@RequestMapping(value = "/admin")
	public String adminRedirect(Locale locale, Model model) {
		return "redirect:/admin/overview";
	}
	
}
