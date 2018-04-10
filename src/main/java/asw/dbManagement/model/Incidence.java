package asw.dbManagement.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Incidence")
public class Incidence {

	@Id
	@GeneratedValue
	private Long id;
	private String indicenceName, description,identificador;
	
	@ManyToOne
	private Agent agent;

	private Date date;
	private IncidenceStatus status;
	
	@ElementCollection
	@CollectionTable(name ="tags")
	private List<String> tags;
	
	@ElementCollection
	@CollectionTable(name ="properties")
	private Map<String, String> properties;
	
	public Incidence(String identificador, String name, String description, Agent agent, List<String> tags) {
		
		this.identificador = identificador;
		this.indicenceName = name;
		this.description = description;
		this.tags=tags;
		this.date = new Date();
		this.status = IncidenceStatus.OPENED;
		this.agent=agent;
		this.date=new Date();
		this.tags = tags;
	}

	Incidence() {
	}

	public Long getId() {
		return id;
	}

	public String getIndicenceName() {
		return indicenceName;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getTags() {
		return tags;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public IncidenceStatus getStatus() {
		return status;
	}

	public void setStatus(IncidenceStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Incidence other = (Incidence) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Incidence [id=" + identificador + "#user=" + agent.getNombre() + "#indicenceName=" + indicenceName
				+ "#description=" + description + "#tags=<" + tags + ">]";
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Date getDate() {
		return date;
	}

}