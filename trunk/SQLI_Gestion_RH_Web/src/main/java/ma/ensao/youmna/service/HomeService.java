package ma.ensao.youmna.service;


public interface HomeService {
	public Integer CountAllCollabs();
	public Integer CountAllManagers();
	public Integer CountManagedCollabs(String matricule);
	
}
