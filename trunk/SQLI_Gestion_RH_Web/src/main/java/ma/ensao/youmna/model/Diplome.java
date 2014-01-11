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
	private Long id;
	
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

	@Column(name = "niveau", nullable = false)
	private String niveau;
	
	@ManyToOne
	@JoinColumn(name="matricule")
	private Collaborateur collaborateur;

	
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the ecole
	 */
	public String getEcole() {
		return ecole;
	}

	/**
	 * @param ecole the ecole to set
	 */
	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	/**
	 * @return the ecoleType
	 */
	public String getEcoleType() {
		return ecoleType;
	}

	/**
	 * @param ecoleType the ecoleType to set
	 */
	public void setEcoleType(String ecoleType) {
		this.ecoleType = ecoleType;
	}

	/**
	 * @return the diplomeType
	 */
	public String getDiplomeType() {
		return diplomeType;
	}

	/**
	 * @param diplomeType the diplomeType to set
	 */
	public void setDiplomeType(String diplomeType) {
		this.diplomeType = diplomeType;
	}

	/**
	 * @return the promotion
	 */
	public Integer getPromotion() {
		return promotion;
	}

	/**
	 * @param promotion the promotion to set
	 */
	public void setPromotion(Integer promotion) {
		this.promotion = promotion;
	}

	/**
	 * @return the niveau
	 */
	public String getNiveau() {
		return niveau;
	}

	/**
	 * @param niveau the niveau to set
	 */
	public void setNiveau(String niveau) {
		this.niveau = niveau;
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
