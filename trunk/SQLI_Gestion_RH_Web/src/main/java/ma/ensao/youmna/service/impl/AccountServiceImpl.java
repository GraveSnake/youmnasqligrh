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
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private CompteDao compteDao;
	
	@Autowired
	private CollaborateurDao collabDao;

	public AccountServiceImpl() {

	}


	public User loginAccount(User userDto) throws NoSuchAlgorithmException, HibernateException {
		System.out.println("inside loginAccount()");
		MessageDigest md = MessageDigest.getInstance("MD5");
		System.out.println("After getting MessageDigest");
		String hash;
		byte[] bytehash;
		System.out.println("Now loading user from database");
		Compte member = compteDao.getCompteByLoginPassword(userDto.getUsername(), userDto.getPassword());
		System.out.println("After Loading User member");
		if (member != null) {
			compteDao.refresh(member);
			bytehash = md.digest((member.getEmail() + new Date()
					.getTime()).getBytes());
			hash = new String(Hex.encode(bytehash));
			System.out.println("HASH : "+hash);
			member.setHash(hash);
			compteDao.updateCompte(member);
			Collaborateur collab = collabDao.getCollaborateurByCompte(member.getLogin());
			
			System.out.println("Filling User Response with Collaborator infos...");
			userDto = new User();
			userDto.setPassword(hash);
			userDto.setAuthority(member.getAuthorities());
			userDto.setId(collab.getMatricule());
			userDto.setNom(collab.getNom());
			userDto.setPrenom(collab.getPrenom());

			return userDto;
		} else {
			System.out.println("Member NULL !!");
			return null;
		}
		
	}
	
	
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
