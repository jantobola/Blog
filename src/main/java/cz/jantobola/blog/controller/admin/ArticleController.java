package cz.jantobola.blog.controller.admin;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.jantobola.blog.controller.common.AbstractController;
import cz.jantobola.blog.domain.Article;
import cz.jantobola.blog.domain.User;
import cz.jantobola.blog.form.FileForm;
import cz.jantobola.blog.form.JQueryUploadResponseWrapper;
import cz.jantobola.blog.repository.ArticleRepository;
import cz.jantobola.blog.repository.SectionRepository;
import cz.jantobola.blog.service.ArticleService;

@Controller
public class ArticleController extends AbstractController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private SectionRepository sectionRepository;

	@RequestMapping(value = "/admin/articles", method = RequestMethod.GET)
	public String articles(Model model, Pageable pageable) {

		model.addAttribute("page", articleRepository.findAll(false, false, pageable));
		model.addAttribute("concepts", articleRepository.findAll(false, true, pageable));
		return "admin/articles";
	}

	@RequestMapping(value = "/admin/article", method = RequestMethod.GET)
	public String articleNew(Model model) {

		prepareNew(model);

		Article concept = new Article();
		concept.setConcept(true);
		concept.setAuthor(User.getCurrentUser());
		concept.setCreationDate(new Date());
		concept.setSection(sectionRepository.findAll().get(0));

		articleRepository.save(concept);
		model.addAttribute("articleForm", concept);

		return "admin/article";
	}

	@ResponseBody
	@RequestMapping(value = "/admin/article", method = RequestMethod.GET, headers = "x-requested-with=XMLHttpRequest")
	public ResponseEntity<String> initializeUploader(Model model, HttpServletResponse response) {

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/admin/article/{id}", method = RequestMethod.GET)
	public String articleLoad(Model model, @PathVariable Long id) {

		prepareLoad(model, id);
		return "admin/article";
	}

	@ResponseBody
	@RequestMapping(value = "/admin/article/{id}", method = RequestMethod.GET, headers = "x-requested-with=XMLHttpRequest")
	public JQueryUploadResponseWrapper initializeUploaderLoad(Model model, @PathVariable Long id) {

		Article article = articleRepository.findOne(id);
		JQueryUploadResponseWrapper response = new JQueryUploadResponseWrapper();
		response.assembleFiles(article.getMediaFiles());

		return response;
	}

	@RequestMapping(value = "/admin/article", method = RequestMethod.POST)
	public String articleSave(@Valid @ModelAttribute("articleForm") Article article, BindingResult result, Model model) {

		prepareNew(model);

		if (checkError(result, model, "error")) {
			return "admin/article";
		}

		articleService.saveArticle(article, article.getId());
		return "redirect:/admin/articles";
	}

	@RequestMapping(value = "/admin/article/{id}", method = RequestMethod.POST)
	public String articleEdit(@Valid @ModelAttribute("articleForm") Article article, BindingResult result, @PathVariable Long id, Model model) {

		prepareLoad(model, id);

		if (checkError(result, model, "error")) {
			return "admin/article";
		}

		articleService.saveArticle(article, id);
		return "redirect:/admin/articles";
	}

	@RequestMapping(value = "/admin/article/{id}", method = RequestMethod.DELETE)
	public String articleDelete(@Valid @ModelAttribute("articleForm") Article article, BindingResult bindingResult, @PathVariable Long id, Model model) {

		articleService.deleteArticle(id);
		return "redirect:/admin/articles";
	}

	private void prepareNew(Model model) {
		model.addAttribute("sections", sectionRepository.findAll());
		model.addAttribute("fileForm", new FileForm());
	}

	private void prepareLoad(Model model, Long id) {
		Article article = articleRepository.findOne(id);
		article.setSectionId(article.getSection().getId());

		model.addAttribute("articleForm", article);
		model.addAttribute("sections", sectionRepository.findAll());
	}

}
