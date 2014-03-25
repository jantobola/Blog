package cz.jantobola.blog.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cz.jantobola.blog.controller.common.AbstractController;
import cz.jantobola.blog.domain.Section;
import cz.jantobola.blog.repository.SectionRepository;
import cz.jantobola.blog.service.SectionService;

@Controller
public class SectionController extends AbstractController {

	@Autowired
	private SectionRepository sectionRepository;
	
	@Autowired
	private SectionService sectionService;
	
	@RequestMapping(value = "/admin/articles/sections", method = RequestMethod.GET)
	public String sections(Model model, Pageable pageable) {
		model.addAttribute("sections", sectionRepository.findAll(pageable));
		model.addAttribute("sectionForm", new Section());
		return "admin/sections";
	}
	
	@RequestMapping(value = "/admin/articles/sections/show", method = RequestMethod.GET)
	public String sectionsShow(Model model, RedirectAttributes ra) {
		ra.addFlashAttribute("modalShow", true);
		return "redirect:/admin/articles/sections";
	}
	
	@RequestMapping(value = "/admin/articles/sections/{id}", method = RequestMethod.GET)
	public String sectionsLoad(Model model, @PathVariable Long id, Pageable pageable) {
		model.addAttribute("sections", sectionRepository.findAll(pageable));
		model.addAttribute("sectionForm", sectionRepository.findOne(id));
		model.addAttribute("modalShow", true);
		return "admin/sections";
	}
	
	@RequestMapping(value = "/admin/articles/sections", method = RequestMethod.POST)
	public String sectionsSave(@Valid @ModelAttribute("sectionForm") Section sectionForm, BindingResult result, Model model, Pageable pageable) {
		
		if (checkError(result, model, "error")) {
			model.addAttribute("sections", sectionRepository.findAll(pageable));
			return "admin/sections";
		}
		
		sectionService.saveSection(sectionForm, null);
		
		return "redirect:/admin/articles/sections";
	}
	
	@RequestMapping(value = "/admin/articles/sections/{id}", method = RequestMethod.POST)
	public String sectionsEdit(@Valid @ModelAttribute("sectionForm") Section sectionForm, BindingResult result, @PathVariable Long id, Model model, Pageable pageable) {
		
		if (checkError(result, model, "error")) {
			model.addAttribute("sections", sectionRepository.findAll(pageable));
			return "admin/sections";
		}
		
		sectionService.saveSection(sectionForm, id);
		
		return "redirect:/admin/articles/sections";
	}
	
	@RequestMapping(value = "/admin/articles/sections/{id}", method = RequestMethod.DELETE)
	public String sectionDelete(@PathVariable Long id, Model model, RedirectAttributes ra) {
		
		try {
			sectionRepository.delete(id);
		} catch (DataIntegrityViolationException e) {
			log.info("User tried to delete section but operation failed.", e);
			error(ra, "Sekce nemohla být smazána, protože k ní jsou přiřazené některé články.");
			info(ra, "Pokud chcete sekci smazat, nejprve přeřaďte články do jiné sekce.");
		}
		
		return "redirect:/admin/articles/sections";
	}
	
}
