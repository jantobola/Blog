package cz.jantobola.blog.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Jan Tobola
 * 
 */
public class UserForm {

    @NotEmpty(message = "*")
    private String name;

    @NotEmpty(message = "*")
    private String surname;

    @NotEmpty(message = "*")
    private String email;

    @NotEmpty(message = "*")
    private String password;

    @NotEmpty(message = "*")
    private String checkPassword;

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getCheckPassword() {
	return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
	this.checkPassword = checkPassword;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getSurname() {
	return surname;
    }

    public void setSurname(String surname) {
	this.surname = surname;
    }

}
