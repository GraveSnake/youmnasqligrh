package ma.ensao.youmna.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import ma.ensao.youmna.dao.CollaborateurDao;
import ma.ensao.youmna.dao.CompteDao;
import ma.ensao.youmna.model.Collaborateur;
import ma.ensao.youmna.model.Compte;
import ma.ensao.youmna.service.AccountService;
import ma.ensao.youmna.util.User;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private CompteDao compteDao;
	
	@Autowired
	private CollaborateurDao collabDao;

	public AccountServiceImpl() {

	}

	@Transactional
	public User loginAccount(User userDto) throws NoSuchAlgorithmException, HibernateException {

		MessageDigest md = MessageDigest.getInstance("MD5");
		String hash;
		byte[] bytehash;

		Compte member = compteDao.loadCompteByQuery("from Compte where login ='" + userDto.getUsername() + "' AND password ='"
						+ userDto.getPassword() + "'");
		
		if (member != null) {
			compteDao.refresh(member);
			bytehash = md.digest((member.getEmail() + new Date()
					.getTime()).getBytes());
			hash = new String(Hex.encode(bytehash));
			member.setHash(hash);
			compteDao.updateCompte(member);
			Collaborateur collab = collabDao.getCollaborateurByCompte(member.getLogin());
			
			userDto = new User();
			userDto.setPassword(hash);
			userDto.setAuthority(member.getAuthorities());
			userDto.setId(collab.getMatricule());
			userDto.setNom(collab.getNom());
			userDto.setPrenom(collab.getPrenom());
			
			return userDto;
		} else {
			return null;
		}
		
	}
	
	
	@Transactional
	public String authenticate(String authToken,String credentials){
		Compte compte = compteDao.getCompteByLogin(authToken);
		if (compte == null) {
			System.out.println("member null");
			throw new BadCredentialsException(
					"Enter a username and password");
		}
		if (!compte.getActive())
			throw new BadCredentialsException("Account disabled");
		if (!credentials.equals(compte.getHash())) {
			throw new BadCredentialsException(
					"Enter a username and password");
		}

		return compte.getAuthorities();
	}


//	@Override
//	@Transactional
//	public Object getAccountData(long id) throws AccountException,
//			HibernateException {
//		return id;
//	}

//	@Override
//	@Transactional
//	public void updatePassword(UserDTO userDto) throws HibernateException {
//		Member member = memberDao.getMemberByORMID(userDto.getId());
//		member.setPASSWORD(userDto.getPassword());
//		memberDao.save(member);
//	}

//	@Override
//	@Transactional
//	public void updateEmail() {
//
//	}

//	@Override
//	@Transactional
//	public boolean emailIsAvailable(String email) throws HibernateException {
//		Member member = memberDao.loadMemberByQuery("EMAIL='" + email + "'",
//				null);
//		return (member == null);	
//	}

//	@Override
//	@Transactional
//	public void activateAccount(String hash) throws HibernateException,
//			AccountException {
//		Member member = memberDao.loadMemberByQuery("hashcode='" + hash + "'",
//				null);
//
//		if (member != null) {
//		}
//	}

//	@Override
//	@Transactional
//	public void resendActivationMail(UserDTO userDto) throws AccountException,
//			AddressException, MessagingException, HibernateException {
//
//		Member member = memberDao.getMemberByORMID(userDto.getId());
//
//		if (member != null) {
//			if (member.getACTIVE()) {
//				throw new AccountException(Error.ACCOUNT_ACTIVATION);
//			} else {
//				mailUtil.sendActivationMail(userDto, member.getHASHCODE(),
//						member.getHASHDELETE());
//			}
//		}
//	}
	
}
