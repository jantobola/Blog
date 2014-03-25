package cz.jantobola.blog.service;

import java.util.Date;

import cz.jantobola.blog.domain.User;
import cz.jantobola.blog.enumeration.C01_SecurityRole;

/**
 * @author Jan Tobola
 * 
 */
public interface UserService {
	
	public User addUser(String firstname, String surname, String username, String email, String password, Date bornDate, String avatarPath, C01_SecurityRole role);
	
	public void disableAccount(User user);
	
}
