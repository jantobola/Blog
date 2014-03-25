package cz.jantobola.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jantobola.blog.domain.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
	
}
