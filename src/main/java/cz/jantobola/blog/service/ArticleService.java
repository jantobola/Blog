package cz.jantobola.blog.service;

import cz.jantobola.blog.domain.Article;

public interface ArticleService {
	
	public void saveArticle(Article article, Long id);
	
	public void deleteArticle(Long id);
	
}
