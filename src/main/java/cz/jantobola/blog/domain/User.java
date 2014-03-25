package cz.jantobola.blog.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import cz.jantobola.blog.security.HashEncode;

/**
 * @author Jan Tobola
 * 
 */
@Entity
public class User implements UserDetails, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String firstname;
	private String surname;
	private String password;
	private String username;
	private String email;
	private Date creationDate;
	private Date bornDate;
	private String avatarPath;
	private boolean enabled;
	
	@Transient
	private List<GrantedAuthority> authorities;
	
	@PrePersist
	void hashPassword() {
		if (StringUtils.isNotBlank(password)) {
			setPassword(HashEncode.sha1(this.password, null));
		}
	}
	
	public static User getCurrentUser() {
		if (SecurityContextHolder.getContext() != null) {
			SecurityContext sc = SecurityContextHolder.getContext();
			if (sc.getAuthentication() != null) {
				Object principal = sc.getAuthentication().getPrincipal();
				return (principal != null && principal instanceof User) ? (User) principal : null;
			}
		}
		return null;
	}
	
	public String getFullname() {
		return firstname + " " + surname;
	}
	
	public Long getId() {
		return userId;
	}
	
	public void setId(Long id) {
		this.userId = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getAvatarPath() {
		return avatarPath;
	}
	
	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Date getBornDate() {
		return bornDate;
	}
	
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	
	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return this.enabled;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return this.enabled;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return this.enabled;
	}
	
}