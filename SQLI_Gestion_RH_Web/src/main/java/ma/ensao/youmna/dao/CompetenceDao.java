package ma.ensao.youmna.dao;

import java.util.List;

import ma.ensao.youmna.model.Competence;

public interface CompetenceDao {
	
	void addCompetence(Competence competence);
	
	void deleteCompetence(Long id);
	
	List<Competence> getAllCompetences();
	
	Competence getCompetenceById(Long id);

}
