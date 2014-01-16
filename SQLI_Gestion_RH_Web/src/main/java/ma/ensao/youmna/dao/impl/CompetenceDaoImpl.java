package ma.ensao.youmna.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.ensao.youmna.dao.CompetenceDao;
import ma.ensao.youmna.model.Competence;

@Repository
@Transactional
public class CompetenceDaoImpl implements CompetenceDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addCompetence(Competence competence) {
		sessionFactory.getCurrentSession().save(competence);
		
	}

	public void deleteCompetence(Long id) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public List<Competence> getAllCompetences() {
		return sessionFactory.getCurrentSession().createQuery("from Competence").list();
	}

	public Competence getCompetenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Competence> getAllCompetences(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Competence where id_techno = :id");
		query.setParameter("id", id);
		return query.list();
	}

	public void updateCompetence(Competence competence) {
		sessionFactory.getCurrentSession().merge(competence);
		
	}

}
