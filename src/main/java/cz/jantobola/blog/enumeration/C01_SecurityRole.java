package cz.jantobola.blog.enumeration;

/**
 * @author Jan Tobola
 * 
 */
public enum C01_SecurityRole {
	
	ROLE_REDACTOR("redactor"), ROLE_VISITOR("visitor"), ROLE_ADMINISTRATOR("administrator");
	
	private String name;
	
	private C01_SecurityRole(String name) {
		this.name = name;
	}
	
	public String getLabel() {
		return this.name;
	}
	
}
