package cz.jantobola.blog.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.jantobola.blog.controller.common.AbstractController;

@Controller
public class AdminController extends AbstractController {
	
	@Autowired
	private ArticleController articleController;
	
	@Autowired
	private SectionController sectionController;
	
	@RequestMapping(value = "/admin/overview", method = RequestMethod.GET)
	public String admin(Model model, Pageable pageable) {
		articleController.articles(model, pageable);
		return "admin/articles";
	}
	
	@RequestMapping(value = "/admin/static", method = RequestMethod.GET)
	public String staticc(Model model, Pageable pageable) {
		sectionController.sections(model, pageable);
		return "admin/sections";
	}
	
}