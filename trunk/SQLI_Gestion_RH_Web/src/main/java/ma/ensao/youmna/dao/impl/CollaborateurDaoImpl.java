package ma.ensao.youmna.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

	public Collaborateur getCollaborateurByCompte(String login) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Collaborateur where compte.login = :login");
		query.setParameter("login", login);
		return (Collaborateur) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Collaborateur> getAllCollaborateursByRole(String role) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Collaborateur  where role = :role order by matricule asc");
		query.setParameter("role", role);
		return query.list();

	}

	@SuppressWarnings("unchecked")
	public List<String> getAllCollaborators(String role) {

		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select nom from Collaborateur  where role = :role order by nom asc");
		query.setParameter("role", role);
		return (List<String>) query.list();
	}

	public int getAllCollaborateurs(char sexe) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select nom from Collaborateur  where sexe = :sexe");
		query.setParameter("sexe", sexe);
		return query.list().size();
	}

	@SuppressWarnings("unchecked")
	public List<Collaborateur> getAllCollaborateurs() {

		return sessionFactory.getCurrentSession()
				.createQuery("from Collaborateur").list();
	}

	public Collaborateur getCollaborateurByIdLogin(String login) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Collaborateur  where compte = :login");
		query.setParameter("login", login);
		return (Collaborateur) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Collaborateur> getAllCollaborateursByManager(String manager) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Collaborateur  where mgrhActuel = :manager");
		query.setParameter("manager", manager);
		return query.list();
	}

	public Map<String, String> getSalaireByYear(String matricule) {
		Map<String, String> map = new TreeMap<String, String>();
		String SQL_QUERY = "select date, salaire from Archive where matricule = :matricule order by date asc";
		Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY);
		query.setParameter("matricule", matricule);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-dd-MM");
		for (Iterator it = query.iterate(); it.hasNext();) {
			Object[] row = (Object[]) it.next();
			map.put(simpleDateFormat.format((Date) row[0]), String.valueOf(row[1]));
			System.out.println(row[0]+": "+row[1]);

		}
		return map;
	}

	public Map<String, String> getPosteByYear(String matricule) {

		Map<String, String> map = new HashMap<String, String>();
		String SQL_QUERY = "select date, posteActuel3 from Archive where matricule = :matricule order by date asc";
		Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY);
		query.setParameter("matricule", matricule);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-dd-MM");
		for (Iterator it = query.iterate(); it.hasNext();) {
			Object[] row = (Object[]) it.next();
			map.put(simpleDateFormat.format((Date) row[0]), String.valueOf(row[1]));

		}
		return map;
	}

	public Map<String, Integer> getComByExpert(Long tech) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String SQL_QUERY = "select competence, niveauExpertise from Competence where technologie.id = :tech order by niveauExpertise asc";
		Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY);
		query.setParameter("tech", tech);
		for (Iterator it = query.iterate(); it.hasNext();) {
			Object[] row = (Object[]) it.next();
			map.put(String.valueOf(row[0]), (Integer) row[1]);

		}
		return map;
	}

	public Map<String, Long> getRecrByYear() {
		Map<String, Long> map = new HashMap<String, Long>();
		String SQL_QUERY = "select dateEmbauche, count(matricule) from Collaborateur group by dateEmbauche";
		Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY);
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for (Iterator it = query.iterate(); it.hasNext();) {
			Object[] row = (Object[]) it.next();
			System.out.println(row[0]);
			String key=((String) row[0]).substring(6,10);
			System.out.println(key);
			if(map.containsKey(key)){
				map.put(key, map.get(key)+ (Long) row[1]);
			}else
			map.put(key, (Long) row[1]);

		}
		return map;
	}

}
