package cz.jantobola.blog.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jantobola.blog.domain.Article;
import cz.jantobola.blog.domain.Section;
import cz.jantobola.blog.domain.User;
import cz.jantobola.blog.repository.ArticleRepository;
import cz.jantobola.blog.repository.SectionRepository;
import cz.jantobola.blog.service.AbstractService;
import cz.jantobola.blog.service.ArticleService;
import cz.jantobola.blog.util.UrlBuilder;

@Service
public class ArticleServiceImpl extends AbstractService implements ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private SectionRepository sectionRepository;
	
	@Override
	@Transactional
	public void saveArticle(Article article, Long id) {
		
		Section section = sectionRepository.findOne(article.getSectionId());
		
		if (id != null) {
			Article edited = articleRepository.findOne(id);
			
			edited.setContent(article.getContent());
			edited.setHeadline(article.getHeadline());
			edited.setResource(article.getResource().replace("watch?v=", "embed/"));
			edited.setSection(section);
			edited.setLastChange(new Date());
			edited.setEditCount(edited.getEditCount() + 1);
			edited.setEditor(User.getCurrentUser());
			edited.setUrl(UrlBuilder.buildDefaultUrl(article.getHeadline()));
			edited.setConcept(article.isConcept());
			
			log.info("EDITED ARTICLE with id: " + id);
			
		} else {
			article.setResource(article.getResource().replace("watch?v=", "embed/"));
			article.setSection(section);
			article.setAuthor(User.getCurrentUser());
			article.setCreationDate(new Date());
			article.setUrl(UrlBuilder.buildDefaultUrl(article.getHeadline()));
			
			articleRepository.save(article);
			log.info("SAVED NEW ARTICLE");
		}
	}
	
	@Override
	@Transactional
	public void deleteArticle(Long id) {
		Article article = articleRepository.findOne(id);
		article.setDeleted(true);
		article.setSection(null);
		log.info("DELETED ARTICLE with id: " + id);
	}
}
