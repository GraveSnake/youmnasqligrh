package ma.ensao.youmna.dao.impl;

import ma.ensao.youmna.dao.CompteDao;
import ma.ensao.youmna.model.Compte;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompteDaoImpl implements CompteDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Compte getCompteByLogin(String login) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Compte where login = :login");
		query.setParameter("login", login);
		return (Compte) query.uniqueResult();
	}

	public void updateCompte(Compte compte) {
		sessionFactory.getCurrentSession().save(compte);
	}

	public Compte getCompteByLoginPassword(String login, String pwd) throws HibernateException {
		try {
			System.out.println("Should be inside getCompteByLoginPassword");
			String condition = "From Compte Where login ='" + login + "' AND password ='"
					+ pwd + "'";
			//System.out.println(sessionFactory==null);
			//System.out.println(sessionFactory.getCurrentSession()==null);
			//System.out.println("Session?? "+sessionFactory.toString());
			Query query = sessionFactory.getCurrentSession().createQuery(condition);
			System.out.println("Now returning");
			return (Compte) query.uniqueResult();
		}
		catch (Exception e) {
			throw new HibernateException(e);
		}
	}

	public boolean refresh(Compte member) throws HibernateException {
		try {
			sessionFactory.getCurrentSession().refresh(member);
			return true;
		}
		catch (Exception e) {
			throw new HibernateException(e);
		}
	}

	public void saveCompte(Compte compte) {
		sessionFactory.getCurrentSession().save(compte);		
	}

}
