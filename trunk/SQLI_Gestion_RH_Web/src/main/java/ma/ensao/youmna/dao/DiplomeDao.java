package ma.ensao.youmna.dao;

import java.util.List;

import ma.ensao.youmna.model.Diplome;

public interface DiplomeDao {
	
	void addDiplome(Diplome diplome);
	
	void deleteDiplome(Long id);
	
	List<Diplome> getAllDiplomes();
	
	Diplome getDiplomeById(Long id);

}
