package cz.jantobola.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cz.jantobola.blog.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	public Article findByUrl(String url);
	
	@Query("from Article a where a.deleted=?1 and a.concept=?2 order by a.id desc")
	public Page<Article> findAll(boolean deleted, boolean concept, Pageable pageable);
	
}
