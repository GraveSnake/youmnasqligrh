package ma.ensao.youmna.service;

import java.util.List;

import ma.ensao.youmna.model.Archive;
import ma.ensao.youmna.model.Collaborateur;

public interface ArchiveService {

	public static final String SALAIRE = "salaire";
	public static final String POSTE3 = "posteActuel3";
	public static final String POSTE4 = "posteActuel4";
	
	void saveArchive(Archive CollabArchive);
	
	void saveCollab(Collaborateur collaborator);
	
	List<Archive> getCollabArchivessByType(String matricule, String type);
}
