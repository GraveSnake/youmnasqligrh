package ma.ensao.youmna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.ensao.youmna.dao.CollaborateurDao;
import ma.ensao.youmna.model.Collaborateur;
import ma.ensao.youmna.service.CollaborateurService;

@Service
@Transactional
public class CollaborateurServiceImpl implements CollaborateurService{
	
	@Autowired
	private CollaborateurDao collaborateurDao;
	

	public void setCollaborateurDao(CollaborateurDao collaborateurDao) {
		this.collaborateurDao = collaborateurDao;
	}

	public void createCollaborateur(Collaborateur collaborateur) {
		collaborateurDao.createCollaborateur(collaborateur);
		
	}

	public void deleteCollaborateur(String matricule) {
		collaborateurDao.deleteCollaborateur(matricule);
		
	}

	public Collaborateur getCollaborateurById(String matricule) {
		
		return collaborateurDao.getCollaborateurById(matricule);
	}

	public void updateCollaborateur(Collaborateur collaborateur) {
		collaborateurDao.updateCollaborateur(collaborateur);
		
	}

	public List<Collaborateur> getAllCollaborateurs() {

		return collaborateurDao.getAllCollaborateurs();
	}

	public List<String> getAllCollaborateurs(String role) {
		return collaborateurDao.getAllCollaborators(role);
	}

}
