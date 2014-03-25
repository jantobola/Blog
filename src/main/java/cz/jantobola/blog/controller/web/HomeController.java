package cz.jantobola.blog.controller.web;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.jantobola.blog.controller.common.AbstractController;
import cz.jantobola.blog.enumeration.C02_PageTheme;
import cz.jantobola.blog.web.ThemeResolver;

/**
 * @author Jan Tobola
 */
@Controller
public class HomeController extends AbstractController {
	
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		ThemeResolver.resolveTheme(C02_PageTheme.THEME_BUSINESS, model);
		return "home";
	}
	
	@RequestMapping(value = "/about")
	public String about(Model model) {
		ThemeResolver.resolveTheme(C02_PageTheme.THEME_BUSINESS, model);
		return "about";
	}
	
	@RequestMapping(value = "/contact")
	public String contact(Model model) {
		ThemeResolver.resolveTheme(C02_PageTheme.THEME_BUSINESS_2, model);
		return "contact";
	}
	
}
