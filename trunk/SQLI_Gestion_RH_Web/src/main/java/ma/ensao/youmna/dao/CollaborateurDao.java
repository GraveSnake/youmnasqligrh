package ma.ensao.youmna.dao;

import java.util.List;
import java.util.Map;

import ma.ensao.youmna.model.Collaborateur;

public interface CollaborateurDao {
	
	void createCollaborateur(Collaborateur collaborateur);
	
	void deleteCollaborateur(String matricule);
	
	Collaborateur getCollaborateurById(String matricule);
	
	Collaborateur getCollaborateurByIdLogin(String login);
	
	void updateCollaborateur(Collaborateur collaborateur);
	
	Collaborateur getCollaborateurByCompte(String login);
	
	List<Collaborateur> getAllCollaborateursByRole(String role);
	
	List<Collaborateur> getAllCollaborateursByManager(String manager);
	
	List<Collaborateur> getAllCollaborateurs();
	
	List<String> getAllCollaborators(String role);
	
	int getAllCollaborateurs(char s);
	
	Map<String,String> getSalaireByYear(String matricule);
	
	Map<String,String> getPosteByYear(String matricule);
	 

}
