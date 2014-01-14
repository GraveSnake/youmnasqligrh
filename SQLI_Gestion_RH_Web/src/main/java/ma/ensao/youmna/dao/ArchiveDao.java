package ma.ensao.youmna.dao;

import java.util.List;
import ma.ensao.youmna.model.Archive;

public interface ArchiveDao {
	
		void saveArchive(Archive CollabArchive);
		
		List<Archive> getCollabArchivessBySalary(String matricule);
		
		List<Archive> getCollabArchivessByPost3(String matricule);
		
		List<Archive> getCollabArchivessByPost4(String matricule);

	}
