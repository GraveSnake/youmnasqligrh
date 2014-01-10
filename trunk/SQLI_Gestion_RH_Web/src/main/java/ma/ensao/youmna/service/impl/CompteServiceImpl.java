package ma.ensao.youmna.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import ma.ensao.youmna.dao.CompteDao;
import ma.ensao.youmna.model.Compte;
import ma.ensao.youmna.service.CompteService;

public class CompteServiceImpl implements CompteService{
	
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




}
