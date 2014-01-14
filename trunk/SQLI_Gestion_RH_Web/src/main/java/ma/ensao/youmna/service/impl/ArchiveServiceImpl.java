package ma.ensao.youmna.service.impl;

import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.ensao.youmna.dao.ArchiveDao;
import ma.ensao.youmna.model.Archive;
import ma.ensao.youmna.model.Collaborateur;
import ma.ensao.youmna.service.ArchiveService;

@Service
@Transactional
public class ArchiveServiceImpl implements ArchiveService {

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	@Autowired
	private ArchiveDao archiveDao;

	public List<Archive> getCollabArchivessByType(String matricule, String Type) {
		if (ArchiveService.SALAIRE.equals(Type)) {
			// get distinct salary values from archive
			archiveDao.getCollabArchivessBySalary(matricule);
		} else if (ArchiveService.POSTE3.equals(Type)) {
			// get distinct posts3 values from archive
			archiveDao.getCollabArchivessByPost3(matricule);
		} else if (ArchiveService.POSTE4.equals(Type)) {
			// get distinct posts4 values from archive
			archiveDao.getCollabArchivessByPost4(matricule);
		}
		return null;
	}

	public void saveArchive(Archive CollabArchive) {
		archiveDao.saveArchive(CollabArchive);
	}

	public void saveCollab(Collaborateur collaborator) {
		Archive CollabArchive = dozerBeanMapper
				.map(collaborator, Archive.class);
		CollabArchive.setDate(new Date());
		saveArchive(CollabArchive);
	}
}
