package ma.ensao.youmna.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.ensao.youmna.dao.ArchiveDao;
import ma.ensao.youmna.model.Archive;

@Repository
@Transactional
public class ArchiveDaoImpl implements ArchiveDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveArchive(Archive CollabArchive) {
		sessionFactory.getCurrentSession().save(CollabArchive);
	}

	public List<Archive> getCollabArchivessBySalary(String matricule) {
		return null;
	}
	
	public List<Archive> getCollabArchivessByPost3(String matricule) {
		return null;
	}
	
	public List<Archive> getCollabArchivessByPost4(String matricule) {
		return null;
	}

}
