package cz.jantobola.blog.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jantobola.blog.domain.User;
import cz.jantobola.blog.domain.UserRole;
import cz.jantobola.blog.enumeration.C01_SecurityRole;
import cz.jantobola.blog.repository.UserRepository;
import cz.jantobola.blog.repository.UserRoleRepository;
import cz.jantobola.blog.service.AbstractService;
import cz.jantobola.blog.service.UserService;

/**
 * @author Jan Tobola
 * 
 */
@Service
public class UserServiceImpl extends AbstractService implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Override
	@Transactional
	public User addUser(String firstname, String surname, String username, String email, String password, Date bornDate, String avatarPath, C01_SecurityRole role) {
		User user = new User();
		
		user.setFirstname(firstname);
		user.setSurname(surname);
		user.setUsername(username);
		user.setEmail(email);
		user.setBornDate(bornDate);
		user.setAvatarPath(avatarPath);
		user.setPassword(password);
		user.setCreationDate(new Date());
		user.setEnabled(true);
		
		UserRole ur = new UserRole();
		ur.setUser(user);
		ur.setRole(role);
		
		userRoleRepository.save(ur);
		
		return user;
	}
	
	@Override
	@Transactional
	public void disableAccount(User user) {
		user.setEnabled(false);
		userRepository.save(user);
	}
	
}
