package ma.ensao.youmna.dao;

import java.util.List;

import org.hibernate.HibernateException;

import ma.ensao.youmna.model.Compte;

public interface CompteDao {
			
	Compte getCompteByLogin(String login);
	
	void updateCompte(Compte compte);
	
	Compte getCompteByLoginPassword(String login, String passwd) throws HibernateException;
	
	boolean refresh(Compte member) throws HibernateException;
	
	void saveCompte(Compte compte);
	
	List<Compte> getAllCompte();

}
