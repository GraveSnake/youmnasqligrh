package ma.ensao.youmna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "compentence")
public class Competence {
	
	@Id @GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "competence", nullable = false)
	private String competence;
	@Column(name = "niveau_expertise", nullable = false)
	private Integer niveauExpertise;

}
