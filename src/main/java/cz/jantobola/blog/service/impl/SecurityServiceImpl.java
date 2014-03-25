package cz.jantobola.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jantobola.blog.domain.User;
import cz.jantobola.blog.domain.UserRole;
import cz.jantobola.blog.repository.UserRoleRepository;
import cz.jantobola.blog.service.AbstractService;
import cz.jantobola.blog.service.SecurityService;

/**
 * @author Jan Tobola
 * 
 */
@Service
public class SecurityServiceImpl extends AbstractService implements SecurityService {
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Override
	public UsernamePasswordAuthenticationToken getAuthenticationToken(User user) {
		return new UsernamePasswordAuthenticationToken(user, user.getPassword(), getAuthorities(user));
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<GrantedAuthority> getAuthorities(User user) {
		List<GrantedAuthority> ga = new ArrayList<GrantedAuthority>();
		List<UserRole> roles = userRoleRepository.getRoles(user);
		
		for (final UserRole role : roles) {
			ga.add(new GrantedAuthorityImpl(role.getRole().toString()));
		}
		
		return ga;
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails createUserDetails(User user) {
		user.setAuthorities(getAuthorities(user));
		return user;
	}
	
}
