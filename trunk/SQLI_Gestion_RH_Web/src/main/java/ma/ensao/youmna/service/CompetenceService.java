package ma.ensao.youmna.service;

import java.util.List;

import ma.ensao.youmna.model.Competence;

public interface CompetenceService {
	void saveCompetence(Competence competence);
	List<Competence> getAll();
	
	List<Competence> getAll(Long id);

}
