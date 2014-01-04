package ma.ensao.youmna.service;

import java.security.NoSuchAlgorithmException;
import ma.ensao.youmna.util.User;
import org.hibernate.HibernateException;

public interface AccountService {
	
	//public boolean emailIsAvailable(String email) throws HibernateException;
	//public Object getAccountData(long id) throws Throwable;
	//public void updatePassword(UserDTO userDto) throws HibernateException;
	//public void updateEmail();
	//public void activateAccount(String hash) throws HibernateException, AccountException;
//	void resendActivationMail(UserDTO userDto) 
//			throws AccountException, AddressException, MessagingException, HibernateException;
	public User loginAccount(User userDto) throws NoSuchAlgorithmException, HibernateException;
	public String authenticate(String authToken, String credentials);
	

}
