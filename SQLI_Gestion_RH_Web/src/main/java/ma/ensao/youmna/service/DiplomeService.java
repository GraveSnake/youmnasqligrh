package ma.ensao.youmna.service;

import java.util.List;

import ma.ensao.youmna.model.Diplome;

public interface DiplomeService {
	void saveDiplome(Diplome diplome);
	List<Diplome> getAll();
	List<Diplome> getAll(String matricule);

}
