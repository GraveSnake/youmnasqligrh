package ma.ensao.youmna.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ma.ensao.youmna.dao.CompetenceDao;
import ma.ensao.youmna.model.Competence;

public class CompetenceDaoImpl implements CompetenceDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCompetence(Competence competence) {
		sessionFactory.getCurrentSession().save(competence);
		
	}

	public void deleteCompetence(Long id) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public List<Competence> getAllCompetences() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Competence").list();
	}

	public Competence getCompetenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
