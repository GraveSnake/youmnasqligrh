package ma.ensao.youmna.service.impl;

import org.springframework.stereotype.Service;

import ma.ensao.youmna.dao.DiplomeDao;
import ma.ensao.youmna.model.Diplome;
import ma.ensao.youmna.service.DiplomeService;

@Service
public class DiplomeServiceImpl implements DiplomeService {

	private DiplomeDao diplomeDao;

	/**
	 * @return the diplomeDao
	 */
	public DiplomeDao getDiplomeDao() {
		return diplomeDao;
	}

	/**
	 * @param diplomeDao
	 *            the diplomeDao to set
	 */
	public void setDiplomeDao(DiplomeDao diplomeDao) {
		this.diplomeDao = diplomeDao;
	}

	public void saveDiplome(Diplome diplome) {
		diplomeDao.addDiplome(diplome);
	}
}
