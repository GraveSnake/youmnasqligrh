package ma.ensao.youmna.model;


public class Compte {
	
	private String login;
	
	private String password;

	private String email;

	private String hash;
	
	private Boolean active;
	
	private String authorities;
	
	
	public Boolean getActive() {
		return active;
	}
	
	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

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
