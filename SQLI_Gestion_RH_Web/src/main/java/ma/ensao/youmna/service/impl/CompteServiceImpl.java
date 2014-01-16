package ma.ensao.youmna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.ensao.youmna.dao.CompteDao;
import ma.ensao.youmna.model.Compte;
import ma.ensao.youmna.service.CompteService;

@Service
@Transactional
public class CompteServiceImpl implements CompteService{
	
	@Autowired
	private CompteDao compteDao;
	
	@Autowired
	private JavaMailSender mailSender;
	

	/**
	 * @return the compteDao
	 */
	public CompteDao getCompteDao() {
		return compteDao;
	}


	/**
	 * @param compteDao the compteDao to set
	 */
	public void setCompteDao(CompteDao compteDao) {
		this.compteDao = compteDao;
	}

	public void createCompte(Compte compte) {
		compteDao.saveCompte(compte);		
	}


	public void sendMessage(String to, String subject, String message) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(to);
        email.setSubject(subject);
        email.setText(message);
        
        mailSender.send(email);
		
	}

	public List<Compte> getAll() {
		return compteDao.getAllCompte();
	}


	public void updateCompte(Compte compte) {
		compteDao.updateCompte(compte);
		
	}


	public Compte getCompteByLogin(String login) {
		
		return compteDao.getCompteByLogin(login);
	}


}
