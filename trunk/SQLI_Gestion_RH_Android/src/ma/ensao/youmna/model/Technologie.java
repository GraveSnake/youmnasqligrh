package ma.ensao.youmna.model;

import java.util.List;

public class Technologie {

	private Long id;
	
	private String technologie;
	
	private Collaborateur collaborateur;
	
	private List<Competence> competence;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTechnologie() {
		return technologie;
	}

	public void setTechnologie(String technologie) {
		this.technologie = technologie;
	}

	/**
	 * @return the collaborateur
	 */
	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	/**
	 * @param collaborateur the collaborateur to set
	 */
	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	/**
	 * @return the competence
	 */
	public List<Competence> getCompetence() {
		return competence;
	}

	/**
	 * @param competence the competence to set
	 */
	public void setCompetence(List<Competence> competence) {
		this.competence = competence;
	}
	

}
