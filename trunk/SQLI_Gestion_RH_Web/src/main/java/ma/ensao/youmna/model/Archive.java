package ma.ensao.youmna.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Archive")
public class Archive {
	@Id
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Matricule")
	private String matricule;
	
	@Column(name = "Poste_Actuel3")
	private String posteActuel3;
	
	@Column(name = "Poste_Actuel4")
	private String postActuel4;
	
	@Column(name = "Salaire")
	private String salaire;
	
	@Column(name = "Annee")
	private Date annee;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the posteActuel3
	 */
	public String getPosteActuel3() {
		return posteActuel3;
	}

	/**
	 * @param posteActuel3 the posteActuel3 to set
	 */
	public void setPosteActuel3(String posteActuel3) {
		this.posteActuel3 = posteActuel3;
	}

	/**
	 * @return the postActuel4
	 */
	public String getPostActuel4() {
		return postActuel4;
	}

	/**
	 * @param postActuel4 the postActuel4 to set
	 */
	public void setPostActuel4(String postActuel4) {
		this.postActuel4 = postActuel4;
	}

	/**
	 * @return the salaire
	 */
	public String getSalaire() {
		return salaire;
	}

	/**
	 * @param salaire the salaire to set
	 */
	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}

	/**
	 * @return the annee
	 */
	public Date getAnnee() {
		return annee;
	}

	/**
	 * @param annee the annee to set
	 */
	public void setAnnee(Date annee) {
		this.annee = annee;
	}

}
