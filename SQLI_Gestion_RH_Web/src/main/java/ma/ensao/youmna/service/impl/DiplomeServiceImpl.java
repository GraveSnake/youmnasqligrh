package ma.ensao.youmna.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.ensao.youmna.dao.DiplomeDao;
import ma.ensao.youmna.model.Diplome;
import ma.ensao.youmna.service.DiplomeService;

@Service
@Transactional
public class DiplomeServiceImpl implements DiplomeService {

	@Autowired
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

	public List<Diplome> getAll() {
		return diplomeDao.getAllDiplomes();
	}
}
