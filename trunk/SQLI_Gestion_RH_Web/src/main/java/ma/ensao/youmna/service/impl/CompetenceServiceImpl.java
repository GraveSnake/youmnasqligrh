package ma.ensao.youmna.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.ensao.youmna.dao.CompetenceDao;
import ma.ensao.youmna.model.Competence;
import ma.ensao.youmna.service.CompetenceService;

@Service
@Transactional
public class CompetenceServiceImpl implements CompetenceService {

	@Autowired
	private CompetenceDao competenceDao;
	
	
	/**
	 * @return the competenceDao
	 */
	public CompetenceDao getCompetenceDao() {
		return competenceDao;
	}


	/**
	 * @param competenceDao the competenceDao to set
	 */
	public void setCompetenceDao(CompetenceDao competenceDao) {
		this.competenceDao = competenceDao;
	}


	public void saveCompetence(Competence competence) {
		competenceDao.addCompetence(competence);
		
	}

	
	public List<Competence> getAll() {
		
		return competenceDao.getAllCompetences();
	}


	public List<Competence> getAll(Long id) {
		
		return competenceDao.getAllCompetences(id);
	}

}
