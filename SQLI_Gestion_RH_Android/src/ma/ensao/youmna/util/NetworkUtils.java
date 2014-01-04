package ma.ensao.youmna.util;

import java.io.Serializable;
import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;

public class NetworkUtils {
	
	private static HttpAuthentication authHeader;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T callWebService(Class T, Serializable requestBody,
			String url, HttpMethod method) throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJacksonHttpMessageConverter());
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

		HttpHeaders headers = new HttpHeaders();
		headers.setAuthorization(authHeader);
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Serializable> request = new HttpEntity<Serializable> (requestBody, headers);

		ResponseEntity<?> result = restTemplate.exchange(Constants.BASE_URL + url, method,
				request, T);

		return (T) result.getBody();

	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static User authenticate(User userDto) throws Exception {
		
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJacksonHttpMessageConverter());
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity request = new HttpEntity(userDto, headers);
		try{
			ResponseEntity result = restTemplate.exchange(Constants.BASE_URL + "/rest/login", HttpMethod.POST,
					request, User.class);
			
			
			return (User) result.getBody();
		} catch(Exception e){
			throw e;
		}
		
	}

	public static void prepareAuthHeader(Context context,Account account) {
		
		if(account != null){
			String login = account.name;
			String hashCode = AccountManager.get(context).getUserData(account, Constants.AUTH_TOKEN_KEY);
			authHeader = new HttpBasicAuthentication(login, hashCode);
		} else {
			throw new IllegalAccessError();
		}
		
	}

}
