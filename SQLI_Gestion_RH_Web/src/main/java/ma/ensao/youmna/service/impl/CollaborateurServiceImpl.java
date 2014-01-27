package ma.ensao.youmna.service.impl;

import java.util.List;
import java.util.Map;

import ma.ensao.youmna.dao.CollaborateurDao;
import ma.ensao.youmna.model.Collaborateur;
import ma.ensao.youmna.service.CollaborateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CollaborateurServiceImpl implements CollaborateurService {

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

	public List<Collaborateur> getAllCollaborateursByRole(String role) {

		return collaborateurDao.getAllCollaborateursByRole(role);
	}

	public List<String> getAllCollaborateurs(String role) {
		return collaborateurDao.getAllCollaborators(role);
	}

	public boolean requireArchive(Collaborateur collaborator) {
		Collaborateur existingCollab = collaborateurDao
				.getCollaborateurById(collaborator.getMatricule());
		
		Double ancien_salaire = existingCollab.getSalaireActuel();
		Double nouveau_salaire = collaborator.getSalaireActuel();
		String ancien_poste3 = existingCollab.getPosteActuel3();
		String nouveau_poste3 = collaborator.getPosteActuel3();
		String ancien_poste4 = existingCollab.getPosteActuel4();
		String nouveau_poste4 = collaborator.getPosteActuel4();

		if ((ancien_salaire.compareTo(nouveau_salaire) == 0)
				&& (ancien_poste3.equals(nouveau_poste3))
				&& (ancien_poste4.equals(nouveau_poste4))) {
			return false;
		}
		return true;
	}

	public int getAllCollaborateurs(char s) {

		return collaborateurDao.getAllCollaborateurs(s);
	}

	public List<Collaborateur> getAllCollaborateurs() {

		return collaborateurDao.getAllCollaborateurs();
	}

	public Collaborateur getCollaborateurByLogin(String login) {

		return collaborateurDao.getCollaborateurByCompte(login);
	}

	public List<Collaborateur> getAllCollaborateursByManager(String manager) {

		return collaborateurDao.getAllCollaborateursByManager(manager);
	}

	public Map<String, String> getSalaireByYear(String matricule) {

		return collaborateurDao.getSalaireByYear(matricule);
	}

	public Map<String, String> getPosteByYear(String matricule) {
		return collaborateurDao.getPosteByYear(matricule);
	}

	public Map<String, Integer> getCompByExpert(Long tech) {

		return collaborateurDao.getComByExpert(tech);
	}

	public Map<String, Long> getRecrByYear() {

		return collaborateurDao.getRecrByYear();
	}

}
