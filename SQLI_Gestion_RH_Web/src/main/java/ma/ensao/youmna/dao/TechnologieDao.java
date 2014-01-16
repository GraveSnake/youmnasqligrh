package ma.ensao.youmna.dao;

import java.util.List;
import java.util.Map;

import ma.ensao.youmna.model.TechnoExist;
import ma.ensao.youmna.model.Technologie;

public interface TechnologieDao {
	
	void addTechnolgie(Technologie technologie);
	
	void updateTechnologie(Technologie technologie);
	
	void deleteTechnologie(Long id);
	
	List<Technologie> getAllTechnologies();
	List<Technologie> getAllTechnologies(String matricule);
	
	Technologie getTechnologieById(Long id);
	
	List<String> technologies();
	
	Map<String , Integer> getCountTechnologie();
	

}
