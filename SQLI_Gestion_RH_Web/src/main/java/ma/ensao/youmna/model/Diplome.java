package ma.ensao.youmna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "diplome")
public class Diplome {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private String id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "ecole", nullable = false)
	private String ecole;
	@Column(name = "ecole_type", nullable = false)
	private String ecoleType;
	@Column(name = "diplome_type", nullable = false)
	private String diplomeType;
	@Column(name = "promotion", nullable = false)
	private Integer promotion;
	@ManyToOne
	@JoinColumn(name="matricule")
	private Collaborateur collaborateur;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEcole() {
		return ecole;
	}
	public void setEcole(String ecole) {
		this.ecole = ecole;
	}
	public String getEcoleType() {
		return ecoleType;
	}
	public void setEcoleType(String ecoleType) {
		this.ecoleType = ecoleType;
	}
	public String getDiplomeType() {
		return diplomeType;
	}
	public void setDiplomeType(String diplomeType) {
		this.diplomeType = diplomeType;
	}
	public Integer getPromotion() {
		return promotion;
	}
	public void setPromotion(Integer promotion) {
		this.promotion = promotion;
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
	
	
	
}
