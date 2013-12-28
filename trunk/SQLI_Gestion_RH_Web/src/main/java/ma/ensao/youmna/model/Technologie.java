package ma.ensao.youmna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "technologie")
public class Technologie {

	@Id
	@Column(name = "id")
	@GeneratedValue()
	private Long id;
	@Column(name = "technologie", nullable = false)
	private String technologie;

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

}
