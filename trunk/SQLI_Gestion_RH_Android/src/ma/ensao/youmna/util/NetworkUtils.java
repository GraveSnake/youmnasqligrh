package ma.ensao.youmna.util;

import java.io.UnsupportedEncodingException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.util.support.Base64;
import org.springframework.web.client.RestTemplate;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Log;

public class NetworkUtils {
	
	private static HttpHeaders headers;
	public static Account account;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T callWebService(Class T,
			String url, String param) throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJacksonHttpMessageConverter());
		HttpComponentsClientHttpRequestFactory rf = new HttpComponentsClientHttpRequestFactory();
		rf.setReadTimeout(1 * 10000);
		rf.setConnectTimeout(1 * 5000);
		restTemplate.setRequestFactory(rf);

		ResponseEntity<?> result = restTemplate.exchange(Constants.BASE_URL + url, HttpMethod.GET,
				new HttpEntity<Object>(headers), T, param);

		return (T) result.getBody();

	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static User authenticate(User userDto) throws Exception {
		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpComponentsClientHttpRequestFactory rf = new HttpComponentsClientHttpRequestFactory();
			rf.setReadTimeout(1 * 5000);
			rf.setConnectTimeout(1 * 5000);
			
		restTemplate.getMessageConverters().add(
				new MappingJacksonHttpMessageConverter());
		
		restTemplate.setRequestFactory(rf);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity request = new HttpEntity(userDto, headers);
		try{
			Log.i("CALLING REST WITH ADDRESS : ", Constants.BASE_URL + "/login");
			ResponseEntity result = restTemplate.exchange(Constants.BASE_URL + "/login", HttpMethod.POST,
					request, User.class);
			Log.i("Exchange Success", "-----------------");
			
			return (User) result.getBody();
		} catch(Exception e){
			throw e;
		}
		
	}

	public static void prepareAuthHeader(Context context,Account account) {
		
		if(account != null){
			final String login = account.name;
			final String hashCode = AccountManager.get(context).getUserData(account, Constants.AUTH_TOKEN_KEY);
			try {
				headers =  new HttpHeaders(){
				      {
				         String auth = login + ":" + hashCode;
				         byte[] encodedAuth = Base64.encodeBytesToBytes(
				            auth.getBytes("UTF-8"));
				         String authHeader = new String( encodedAuth );
				         Log.i("AUTHENTICATION", authHeader);
				         set( "Authorization", authHeader );
				      }
				   };
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
				headers.setContentType(MediaType.APPLICATION_JSON);

		} else {
			throw new IllegalAccessError();
		}
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T getRestObject(Class T, String url, String param) {
		Object result = null;
		
		try{
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
    		HttpComponentsClientHttpRequestFactory rf = new HttpComponentsClientHttpRequestFactory();
    		rf.setReadTimeout(1 * 10000);
    		rf.setConnectTimeout(1 * 5000);
    		restTemplate.setRequestFactory(rf);
            result = restTemplate.getForObject(Constants.BASE_URL+url, T, param);
		}catch(Exception e){
			Log.e("EXCEPTION", e.getMessage());
		}
		return (T) result;

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T[] getRestObjects(Class T, String url, String param) {
		Object[] result = null;
		
		try{
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
    		HttpComponentsClientHttpRequestFactory rf = new HttpComponentsClientHttpRequestFactory();
    		rf.setReadTimeout(1 * 10000);
    		rf.setConnectTimeout(1 * 5000);
    		restTemplate.setRequestFactory(rf);
            result = restTemplate.getForObject(Constants.BASE_URL+url, T, param);
		}catch(Exception e){
			Log.e("EXCEPTION", e.getMessage());
		}
		return (T[]) result;

	}
}
