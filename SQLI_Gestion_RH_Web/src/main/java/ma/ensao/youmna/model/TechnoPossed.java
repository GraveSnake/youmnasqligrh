//package ma.ensao.youmna.model;
//
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//
//@Entity
//@Table(name = "techno_possed")
//public class TechnoPossed {
//
//	@Id
//	@Column(name = "id")
//	@GeneratedValue()
//	private Long id;
//	@OneToOne()
//	private Technologie technologie;
//	@ManyToOne
//	@JoinColumn(name="matricule")
//	private Collaborateur collaborateur;
//	@Transient
//	private List<Competence> competence;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public Technologie getTechnologie() {
//		return technologie;
//	}
//	public void setTechnologie(Technologie technologie) {
//		this.technologie = technologie;
//	}
//
//}
