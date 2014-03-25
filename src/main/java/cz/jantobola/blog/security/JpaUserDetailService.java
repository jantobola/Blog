package cz.jantobola.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cz.jantobola.blog.domain.User;
import cz.jantobola.blog.repository.UserRepository;
import cz.jantobola.blog.service.SecurityService;

/**
 * @author Jan Tobola
 * 
 */
public class JpaUserDetailService implements UserDetailsService {
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		User user = userRepository.findUserByUsername(username);
		return securityService.createUserDetails(user);
	}
	
}
