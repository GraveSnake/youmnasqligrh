package ma.ensao.youmna.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.ensao.youmna.dao.CollaborateurDao;
import ma.ensao.youmna.service.HomeService;

@Transactional
@Service
public class HomeServiceImpl implements HomeService{

	@Autowired
	private CollaborateurDao collaborateurDao;
	
	public Integer CountAllCollabs() {
		return collaborateurDao.getAllCollaborateurs().size();
	}

	public Integer CountManagedCollabs(String matricule) {
		
		return 0;
	}

	public Integer CountAllManagers() {
		return collaborateurDao.getAllCollaborators("Manager").size();
	}

}
