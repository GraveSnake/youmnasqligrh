package ma.ensao.youmna.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "technologie")
public class Technologie {

	@Id
	@Column(name = "id_techno")
	@GeneratedValue()
	private Long id;
	@Column(name = "technologie", nullable = false)
	private String technologie;
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
