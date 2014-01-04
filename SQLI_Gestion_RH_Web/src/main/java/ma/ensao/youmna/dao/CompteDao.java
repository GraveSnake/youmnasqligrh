package ma.ensao.youmna.dao;

import org.hibernate.HibernateException;

import ma.ensao.youmna.model.Compte;

public interface CompteDao {
			
	Compte getCompteByLogin(String login);
	
	void updateCompte(Compte compte);
	
	Compte loadCompteByQuery(String condition) throws HibernateException;
	
	boolean refresh(Compte member) throws HibernateException;

}
