package ma.ensao.youmna.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ma.ensao.youmna.dao.TechnologieDao;
import ma.ensao.youmna.model.Technologie;

public class TechnologieDaoImpl implements TechnologieDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addTechnolgie(Technologie technologie) {
		// TODO Auto-generated method stub
		
	}

	public void deleteTechnologie(Long id) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public List<Technologie> getAllTechnologies() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Technologie").list();
	}

	public Technologie getTechnologieById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
