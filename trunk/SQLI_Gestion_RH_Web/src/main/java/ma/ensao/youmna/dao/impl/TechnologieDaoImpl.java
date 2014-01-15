package ma.ensao.youmna.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.ensao.youmna.dao.TechnologieDao;
import ma.ensao.youmna.model.Technologie;

@Repository
@Transactional
public class TechnologieDaoImpl implements TechnologieDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addTechnolgie(Technologie technologie) {
		sessionFactory.getCurrentSession().save(technologie);
		
	}

	public void deleteTechnologie(Long id) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public List<Technologie> getAllTechnologies() {
		return sessionFactory.getCurrentSession().createQuery("from Technologie").list();
	}

	public Technologie getTechnologieById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Technologie> getAllTechnologies(String matricule) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Technologie where matricule = :matricule");
		query.setParameter("matricule", matricule);
		return query.list();
	}

	public void updateTechnologie(Technologie technologie) {
		sessionFactory.getCurrentSession().update(technologie);
		
	}

	@SuppressWarnings("unchecked")
	public List<String> technologies() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("select nom from TechnoExist").list();
	}

}
