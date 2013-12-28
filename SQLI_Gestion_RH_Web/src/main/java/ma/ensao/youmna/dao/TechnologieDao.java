package ma.ensao.youmna.dao;

import java.util.List;

import ma.ensao.youmna.model.Technologie;

public interface TechnologieDao {
	
	void addTechnolgie(Technologie technologie);
	
	void deleteTechnologie(Long id);
	
	List<Technologie> getAllTechnologies();
	

}
