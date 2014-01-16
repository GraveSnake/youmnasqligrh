package ma.ensao.youmna.model;


public class Competence {
	

	private Long id;

	private String competence;
	private Integer niveauExpertise;
	private Technologie technologie;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the competence
	 */
	public String getCompetence() {
		return competence;
	}
	/**
	 * @param competence the competence to set
	 */
	public void setCompetence(String competence) {
		this.competence = competence;
	}
	/**
	 * @return the niveauExpertise
	 */
	public Integer getNiveauExpertise() {
		return niveauExpertise;
	}
	/**
	 * @param niveauExpertise the niveauExpertise to set
	 */
	public void setNiveauExpertise(Integer niveauExpertise) {
		this.niveauExpertise = niveauExpertise;
	}
	/**
	 * @return the technologie
	 */
	public Technologie getTechnologie() {
		return technologie;
	}
	/**
	 * @param technologie the technologie to set
	 */
	public void setTechnologie(Technologie technologie) {
		this.technologie = technologie;
	}
	
	

}
