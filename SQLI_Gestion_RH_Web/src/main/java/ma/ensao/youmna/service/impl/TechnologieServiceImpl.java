package ma.ensao.youmna.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.ensao.youmna.dao.TechnologieDao;
import ma.ensao.youmna.model.Technologie;
import ma.ensao.youmna.service.TechnologieService;

@Service
public class TechnologieServiceImpl implements TechnologieService {
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
		// TODO Auto-generated method stub
		return technologieDao.getAllTechnologies();
	}

}
