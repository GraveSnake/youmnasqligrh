package ma.ensao.youmna.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "collaborateur")
public class Collaborateur {
	
	@Id
	@Column(name = "matricule", nullable = false)
	private String matricule;
	@Column(name = "nom", nullable = false)
	private String nom;
	@Column(name = "prenom", nullable = false)
	private String prenom;
	@Column(name = "abreviation", nullable = false)
	private String abreviation;
	@Column(name = "mgrh_ancien", nullable = false)
	private String mgrhAncien;
	@Column(name = "mgrh_actuel", nullable = false)
	private String mgrhActuel;
	@Column(name = "sexe", nullable = false)
	private char sexe;
	@Column(name = "site", nullable = false)
	private String site;
	@Column(name = "bu", nullable = false)
	private String bu;
	@Column(name = "date_embauche", nullable = false)
	private String dateEmbauche;
	@Column(name = "mois_bap", nullable = false)
	private String moisBap;
	@Column(name = "date_depart", nullable = false)
	private String dateDepart;
	@Column(name = "ancien_coll", nullable = false)
	private boolean ancienColl;
	@Column(name = "participe_si", nullable = false)
	private boolean participeSi;
	@Column(name = "date_si", nullable = false)
	private String dateSi;
	@Column(name = "poste_actuel3", nullable = false)
	private String posteActuel3;
	@Column(name = "poste_actuel4", nullable = false)
	private String posteActuel4;
	@Column(name = "salaire_actuel", nullable = false)
	private Double salaireActuel;
	@OneToMany
	@JoinColumn(name="id_matricule", referencedColumnName="matricule")
	private List<Diplome> diplomes;
	@OneToMany
	@JoinColumn(name="id_matricule", referencedColumnName="matricule")
	private List<TechnoPossed> technologies;
	@OneToOne(cascade = CascadeType.ALL)
	private Compte compte;
	@Column(name="statut_manager")
	private boolean statutManager;
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAbreviation() {
		return abreviation;
	}
	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}
	public String getMgrhAncien() {
		return mgrhAncien;
	}
	public void setMgrhAncien(String mgrhAncien) {
		this.mgrhAncien = mgrhAncien;
	}
	public String getMgrhActuel() {
		return mgrhActuel;
	}
	public void setMgrhActuel(String mgrhActuel) {
		this.mgrhActuel = mgrhActuel;
	}
	public char getSexe() {
		return sexe;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getBu() {
		return bu;
	}
	public void setBu(String bu) {
		this.bu = bu;
	}
	public String getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(String dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public String getMoisBap() {
		return moisBap;
	}
	public void setMoisBap(String moisBap) {
		this.moisBap = moisBap;
	}
	public String getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}
	public boolean isAncienColl() {
		return ancienColl;
	}
	public void setAncienColl(boolean ancienColl) {
		this.ancienColl = ancienColl;
	}
	public boolean isParticipeSi() {
		return participeSi;
	}
	public void setParticipeSi(boolean participeSi) {
		this.participeSi = participeSi;
	}
	public String getDateSi() {
		return dateSi;
	}
	public void setDateSi(String dateSi) {
		this.dateSi = dateSi;
	}
	public String getPosteActuel3() {
		return posteActuel3;
	}
	public void setPosteActuel3(String posteActuel3) {
		this.posteActuel3 = posteActuel3;
	}
	public String getPosteActuel4() {
		return posteActuel4;
	}
	public void setPosteActuel4(String posteActuel4) {
		this.posteActuel4 = posteActuel4;
	}
	public Double getSalaireActuel() {
		return salaireActuel;
	}
	public void setSalaireActuel(Double salaireActuel) {
		this.salaireActuel = salaireActuel;
	}
	public List<Diplome> getDiplomes() {
		return diplomes;
	}
	public void setDiplomes(List<Diplome> diplomes) {
		this.diplomes = diplomes;
	}

	public List<TechnoPossed> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(List<TechnoPossed> technologies) {
		this.technologies = technologies;
	}
	public boolean isStatutManager() {
		return statutManager;
	}
	public void setStatutManager(boolean statutManager) {
		this.statutManager = statutManager;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public boolean isStatut() {
		return statutManager;
	}
	public void setStatut(boolean statut) {
		this.statutManager = statut;
	}
	
	
}
