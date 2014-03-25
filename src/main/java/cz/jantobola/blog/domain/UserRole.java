package cz.jantobola.blog.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import cz.jantobola.blog.enumeration.C01_SecurityRole;

/**
 * @author Jan Tobola
 * 
 */
@Entity
public class UserRole implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private C01_SecurityRole role;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public C01_SecurityRole getRole() {
		return role;
	}
	
	public void setRole(C01_SecurityRole role) {
		this.role = role;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
}
