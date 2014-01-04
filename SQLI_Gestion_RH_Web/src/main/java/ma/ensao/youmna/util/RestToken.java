package ma.ensao.youmna.util;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class RestToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = 1L;
	private long id;
	
    public RestToken(String key, String credentials) {
        super(key, credentials);
    }

    public RestToken(String key, String credentials, Collection<? extends GrantedAuthority> authorities) {
        super(key, credentials, authorities);
    }

    public String getKey() {
        return (String) super.getPrincipal();
    }

    public String getCredentials() {
        return (String) super.getCredentials();
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
