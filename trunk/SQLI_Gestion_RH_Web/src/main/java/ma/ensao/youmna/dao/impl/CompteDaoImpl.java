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

	public Compte getCompteByLogin(String login) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Compte where login = :login");
		query.setParameter("login", login);
		return (Compte) query.uniqueResult();
	}

	public void updateCompte(Compte compte) {
		sessionFactory.getCurrentSession().save(compte);
	}

	public Compte loadCompteByQuery(String condition) throws HibernateException {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(condition);
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
