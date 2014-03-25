package cz.jantobola.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jantobola.blog.domain.StaticMenu;

public interface MenuRepository extends JpaRepository<StaticMenu, Long> {
	
}
