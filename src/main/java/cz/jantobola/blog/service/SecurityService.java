package cz.jantobola.blog.service;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cz.jantobola.blog.domain.User;

/**
 * @author Jan Tobola
 * 
 */
public interface SecurityService {
	
	public UsernamePasswordAuthenticationToken getAuthenticationToken(User user);
	
	public List<GrantedAuthority> getAuthorities(User user);
	
	public UserDetails createUserDetails(User user);
	
}
