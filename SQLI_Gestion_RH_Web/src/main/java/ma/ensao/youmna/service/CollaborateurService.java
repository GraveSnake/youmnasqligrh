package ma.ensao.youmna.service;

import java.util.List;

import ma.ensao.youmna.model.Collaborateur;

public interface CollaborateurService {

	void createCollaborateur(Collaborateur collaborateur);

	void deleteCollaborateur(String matricule);

	Collaborateur getCollaborateurById(String matricule);

	void updateCollaborateur(Collaborateur collaborateur);

	List<Collaborateur> getAllCollaborateurs();

}
