package ma.ensao.youmna.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "technologie")
public class Technologie {

	@Id @GeneratedValue
	@Column(name = "id")
	private Long id;
//	@Column(name = "technologie")
//	private String technologie;
	@OneToOne(cascade = CascadeType.ALL)
	private TechnoExist technologie;
	@ManyToOne
	@JoinColumn(name="matricule")
	private Collaborateur collaborateur;
	@Transient
	private List<Competence> competence;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	/**
	 * @return the technologie
	 */
	public TechnoExist getTechnologie() {
		return technologie;
	}

	/**
	 * @param technologie the technologie to set
	 */
	public void setTechnologie(TechnoExist technologie) {
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
