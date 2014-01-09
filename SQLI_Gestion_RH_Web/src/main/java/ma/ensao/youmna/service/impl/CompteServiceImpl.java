package ma.ensao.youmna.service.impl;

import ma.ensao.youmna.dao.CompteDao;
import ma.ensao.youmna.model.Competence;
import ma.ensao.youmna.model.Compte;
import ma.ensao.youmna.service.CompetenceService;
import ma.ensao.youmna.service.CompteService;

public class CompteServiceImpl implements CompteService{
	
	private CompteDao compteDao;
	

	/**
	 * @return the compteDao
	 */
	public CompteDao getCompteDao() {
		return compteDao;
	}


	/**
	 * @param compteDao the compteDao to set
	 */
	public void setCompteDao(CompteDao compteDao) {
		this.compteDao = compteDao;
	}




	public void createCompte(Compte compte) {
		compteDao.saveCompte(compte);		
	}


}
