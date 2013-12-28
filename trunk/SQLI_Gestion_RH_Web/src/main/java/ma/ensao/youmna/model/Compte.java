package ma.ensao.youmna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Compte")
public class Compte {
	@Id
	@Column(name="login",nullable=false)
	private String login;
	@Column(name="password",nullable=false)
	private String password;
	@Column(name="email",nullable=false)
	private String email;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
