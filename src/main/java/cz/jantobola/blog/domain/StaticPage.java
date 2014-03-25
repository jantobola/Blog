package cz.jantobola.blog.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class StaticPage extends AbstractPage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private StaticMenu menu;
	
	public StaticMenu getMenu() {
		return menu;
	}
	
	public void setMenu(StaticMenu menu) {
		this.menu = menu;
	}
	
}
