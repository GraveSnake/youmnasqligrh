package ma.ensao.youmna.service.impl;

import java.util.List;
import java.util.Map;

import ma.ensao.youmna.dao.TechnologieDao;
import ma.ensao.youmna.model.Technologie;
import ma.ensao.youmna.service.TechnologieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TechnologieServiceImpl implements TechnologieService {
	
	@Autowired
	private TechnologieDao technologieDao;

	/**
	 * @return the technologieDao
	 */
	public TechnologieDao getTechnologieDao() {
		return technologieDao;
	}

	/**
	 * @param technologieDao
	 *            the technologieDao to set
	 */
	public void setTechnologieDao(TechnologieDao technologieDao) {
		this.technologieDao = technologieDao;
	}

	public void saveTechnologie(Technologie technologie) {
		technologieDao.addTechnolgie(technologie);
	}

	public List<Technologie> getAll() {
		return technologieDao.getAllTechnologies();
	}

	public List<Technologie> getAll(String matricule) {
		
		return technologieDao.getAllTechnologies(matricule);
	}

	public void updateTechnologie(Technologie technologie) {
		technologieDao.updateTechnologie(technologie);
		
	}

	public List<String> technologies() {
		return technologieDao.technologies();
	}

	public Map<String, Long> getCountTechnologie() {
		return technologieDao.getCountTechnologie();
	}
}
