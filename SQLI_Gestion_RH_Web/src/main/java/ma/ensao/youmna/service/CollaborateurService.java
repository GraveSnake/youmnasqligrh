package ma.ensao.youmna.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ma.ensao.youmna.model.Collaborateur;

public interface CollaborateurService {

	void createCollaborateur(Collaborateur collaborateur);
	
	boolean requireArchive(Collaborateur collaborator);

	void deleteCollaborateur(String matricule);

	Collaborateur getCollaborateurById(String matricule);
	
	Collaborateur getCollaborateurByLogin(String login);

	void updateCollaborateur(Collaborateur collaborateur);

	List<Collaborateur> getAllCollaborateursByRole(String role);
	
	List<Collaborateur> getAllCollaborateurs();
	
	List<Collaborateur> getAllCollaborateursByManager(String manager);
	
	List<String> getAllCollaborateurs(String role);
	
	int getAllCollaborateurs(char s);
	
	Map<String,String> getSalaireByYear(String matricule);
	
	Map<String,String> getPosteByYear(String matricule);
	
	Map<String,Integer> getCompByExpert(Long tech);
	
	Map<String, Long> getRecrByYear();

}
