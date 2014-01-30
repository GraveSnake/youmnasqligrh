package ma.ensao.youmna.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ma.ensao.youmna.dao.TechnologieDao;
import ma.ensao.youmna.model.Technologie;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
		sessionFactory.getCurrentSession().saveOrUpdate(technologie);
		
	}

	@SuppressWarnings("unchecked")
	public List<String> technologies() {
		return sessionFactory.getCurrentSession().createQuery("select nom from TechnoExist order by nom asc").list();
	}

	@SuppressWarnings("rawtypes")
	public Map<String, Long> getCountTechnologie() {
		Map<String, Long> map= new HashMap<String, Long>() ;
		String SQL_QUERY = "select technologie.nom, count(technologie) from Technologie group by technologie";
		Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY);
		 for (Iterator it = 
				 query.iterate(); it.hasNext();) {
				  Object[] row = (Object[]) it.next();
				  map.put((String)row[0],(Long) row[1]);
				  System.out.println("Invested Amount: " + row[0]);
				  System.out.println("Insurance Name: " + row[1]);
				   }
		return map;
	}

}
