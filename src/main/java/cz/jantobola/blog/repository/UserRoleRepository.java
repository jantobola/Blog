package cz.jantobola.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cz.jantobola.blog.domain.User;
import cz.jantobola.blog.domain.UserRole;

/**
 * @author Jan Tobola
 * 
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	
	@Query("from UserRole where user=?1")
	public List<UserRole> getRoles(User user);
	
}
