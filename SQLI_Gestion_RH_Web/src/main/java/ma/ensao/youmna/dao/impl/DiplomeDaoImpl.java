package ma.ensao.youmna.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.ensao.youmna.dao.DiplomeDao;
import ma.ensao.youmna.model.Diplome;

@Repository
@Transactional
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

	@SuppressWarnings("unchecked")
	public List<Diplome> getAllDiplomes(String matricule) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Diplome where matricule = :matricule");
		query.setParameter("matricule", matricule);
		return query.list();
	}

	public void updateDiplome(Diplome diplome) {
		sessionFactory.getCurrentSession().saveOrUpdate(diplome);
		
	}

}
