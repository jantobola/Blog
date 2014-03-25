package cz.jantobola.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import cz.jantobola.blog.domain.User;
import cz.jantobola.blog.repository.UserRepository;
import cz.jantobola.blog.service.SecurityService;

/**
 * @author Jan Tobola
 * 
 */
public class JpaAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SecurityService securityService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		User user = userRepository.findUserByUsername(authentication.getName());
		
		if (user != null) {
			String pass = String.valueOf(authentication.getCredentials());
			String hashPass = HashEncode.sha1(pass, null);
			
			if (user.getPassword().equals(hashPass) && user.isEnabled()) {
				UsernamePasswordAuthenticationToken upaToken = securityService.getAuthenticationToken(user);
				return upaToken;
			}
		}
		return null;
	}
	
	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
	
}
