package ma.ensao.youmna.service;

import java.util.List;

import ma.ensao.youmna.model.Technologie;

public interface TechnologieService {
	void saveTechnologie(Technologie technologie);
	List<Technologie> getAll();

}
