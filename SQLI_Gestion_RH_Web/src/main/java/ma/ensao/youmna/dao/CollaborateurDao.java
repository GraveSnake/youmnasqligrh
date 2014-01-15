package ma.ensao.youmna.dao;

import java.util.List;

import ma.ensao.youmna.model.Collaborateur;

public interface CollaborateurDao {
	
	void createCollaborateur(Collaborateur collaborateur);
	
	void deleteCollaborateur(String matricule);
	
	Collaborateur getCollaborateurById(String matricule);
	
	void updateCollaborateur(Collaborateur collaborateur);
	
	Collaborateur getCollaborateurByCompte(String login);
	
	List<Collaborateur> getAllCollaborateursByRole(String role);
	
	List<Collaborateur> getAllCollaborateurs();
	
	List<String> getAllCollaborators(String role);
	
	int getAllCollaborateurs(char s);
	 

}
