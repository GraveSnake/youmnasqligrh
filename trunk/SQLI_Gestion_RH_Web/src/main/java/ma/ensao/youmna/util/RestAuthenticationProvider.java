package ma.ensao.youmna.util;

import java.util.ArrayList;
import java.util.List;
import ma.ensao.youmna.service.AccountService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class RestAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private AccountService accountService;
	
	public RestAuthenticationProvider() {
		
	}


	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		RestToken restToken = (RestToken) authentication;

		String key = restToken.getKey();
		String credentials = restToken.getCredentials();

		try {

			String authority = accountService.authenticate(key, credentials);
			return getAuthenticatedUser(key, credentials, authority);
			
		} catch (HibernateException e) {
			throw new BadCredentialsException("login error");
		} catch (NullPointerException e) {
			throw new BadCredentialsException("null pointer");
		}

	}

	private Authentication getAuthenticatedUser(String key, String credentials,
			String authority) {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(authority));

		RestToken restToken = new RestToken(key, credentials, authorities);
		return restToken;
	}

	
	/*
	 * Determines if this class can support the token provided by the filter.
	 */
	public boolean supports(Class<?> authentication) {
		return RestToken.class.equals(authentication);
	}
	

}
