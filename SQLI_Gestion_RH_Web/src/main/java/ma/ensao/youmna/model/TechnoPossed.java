package ma.ensao.youmna.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "techno_possed")
public class TechnoPossed {

	@Id
	@Column(name = "id")
	@GeneratedValue()
	private Long id;
	@OneToOne()
	private Technologie technologie;
	@OneToMany
	@JoinColumn(name = "id_techno", referencedColumnName = "id")
	private List<Competence> competences;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Technologie getTechnologie() {
		return technologie;
	}
	public void setTechnologie(Technologie technologie) {
		this.technologie = technologie;
	}
	public List<Competence> getCompetences() {
		return competences;
	}
	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

}
