package cz.jantobola.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jantobola.blog.domain.User;

/**
 * @author Jan Tobola
 * 
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findUserByEmail(String email);
	
	public User findUserByUsername(String username);
	
}
