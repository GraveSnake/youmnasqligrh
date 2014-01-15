package ma.ensao.youmna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compentence")
public class Competence {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "competence")
	private String competence;
	@Column(name = "niveau_expertise")
	private Integer niveauExpertise;
	@ManyToOne
	@JoinColumn(name="id_techno")
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
