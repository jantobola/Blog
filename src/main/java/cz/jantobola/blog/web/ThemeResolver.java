package cz.jantobola.blog.web;

import org.springframework.ui.Model;

import cz.jantobola.blog.enumeration.C02_PageTheme;

public abstract class ThemeResolver {
	
	public static String[] THEME_LOCATION_PROPERTY = { "theme_header", "theme_footer" };
	
	public ThemeResolver() {
		// TODO Auto-generated constructor stub
	}
	
	public static void resolveTheme(C02_PageTheme theme, Model model) {
		
		model.addAttribute(THEME_LOCATION_PROPERTY[0], theme.getHeaderStyle());
		model.addAttribute(THEME_LOCATION_PROPERTY[1], theme.getFooterStyle());
		
	}
}
