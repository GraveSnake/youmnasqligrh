package ma.ensao.youmna.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.ensao.youmna.dao.DiplomeDao;
import ma.ensao.youmna.model.Diplome;

@Repository
public class DiplomeDaoImpl implements DiplomeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addDiplome(Diplome diplome) {
		sessionFactory.getCurrentSession().save(diplome);
		
	}

	public void deleteDiplome(Long id) {
		Diplome diplome = getDiplomeById(id);
        sessionFactory.getCurrentSession().delete(diplome);		
	}

	@SuppressWarnings("unchecked")
	public List<Diplome> getAllDiplomes() {
		return sessionFactory.getCurrentSession().createQuery("from Diplome").list();
	}

	public Diplome getDiplomeById(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Diplome where id = :id");
		query.setParameter("id", id);
		return (Diplome) query.uniqueResult();
	}

}
