package ma.ensao.youmna.dao.impl;

import java.util.List;

import ma.ensao.youmna.dao.CollaborateurDao;
import ma.ensao.youmna.model.Collaborateur;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CollaborateurDaoImpl implements CollaborateurDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void createCollaborateur(Collaborateur collaborateur) {
		sessionFactory.getCurrentSession().save(collaborateur);

	}

	public void deleteCollaborateur(String matricule) {
        Collaborateur collaborateur = getCollaborateurById(matricule);
        sessionFactory.getCurrentSession().delete(collaborateur);
	}

	public Collaborateur getCollaborateurById(String matricule) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Collaborateur where matricule = :matricule");
		query.setParameter("matricule", matricule);
		return (Collaborateur) query.uniqueResult();
	}

	public void updateCollaborateur(Collaborateur collaborateur) {
		sessionFactory.getCurrentSession().update(collaborateur);

	}
	
	public Collaborateur getCollaborateurByCompte(String login){
		Query query = sessionFactory.getCurrentSession().createQuery("from Collaborateur where compte_login = :login");
		query.setParameter("login", login);
		return (Collaborateur) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Collaborateur> getAllCollaborateurs() {
		 return sessionFactory.getCurrentSession().createQuery("from Collaborateur").list();
		
	}

	@SuppressWarnings("unchecked")
	public List<String> getAllCollaborators(String role) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("select nom from Collaborateur  where role = :role order by nom asc");
		query.setParameter("role", role);
		return (List<String>) query.list();
	}

}
