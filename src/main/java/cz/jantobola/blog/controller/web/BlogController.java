package cz.jantobola.blog.controller.web;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.jantobola.blog.controller.common.AbstractController;
import cz.jantobola.blog.domain.Article;
import cz.jantobola.blog.enumeration.C02_PageTheme;
import cz.jantobola.blog.repository.ArticleRepository;
import cz.jantobola.blog.web.ThemeResolver;

/**
 * @author Jan Tobola
 */
@Controller
@RequestMapping("/blog")
public class BlogController extends AbstractController {
	
	private final static int CONTENT_CHARS_LIMIT = 700;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String blog(Model model, @PageableDefaults(value = 5) Pageable pageable) {
		ThemeResolver.resolveTheme(C02_PageTheme.THEME_BLOG, model);
		Page<Article> articles = articleRepository.findAll(false, false, pageable);
		
		for (Article article : articles) {
			article.setContent(Jsoup.clean(article.getContent(), Whitelist.none()));
			
			if (article.getContent().length() >= CONTENT_CHARS_LIMIT) {
				article.setContent(article.getContent().substring(0, CONTENT_CHARS_LIMIT) + "...");
			}
		}
		
		model.addAttribute("articles", articles);
		return "blog";
	}
	
	@RequestMapping(value = "/{articleUrl}", method = RequestMethod.GET)
	public String blogLoad(Model model, @PathVariable String articleUrl) {
		ThemeResolver.resolveTheme(C02_PageTheme.THEME_BLOG, model);
		Article article = null;
		
		if (StringUtils.isNumeric(articleUrl)) {
			article = articleRepository.findOne(Long.parseLong(articleUrl));
		} else {
			article = articleRepository.findByUrl(articleUrl);
		}
		
		model.addAttribute("article", article);
		return "article";
	}
	
}
