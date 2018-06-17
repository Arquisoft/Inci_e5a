package asw.inciManager.inciManager_e5a.entities;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "incidencias")
public class Incidence {


	private String indicenceName, description,identificador;
	
	private Agent agent;

	private Date date;
	private IncidenceStatus status;
	
	private List<String> tags;
	
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
	
	public String toJSON() {
		return "{ \"identifier\" : " + identificador + ", "
			+ " \"name\" : " + indicenceName + ", "
			+ " \"description\" : " + description + ", "
			+ " \"date\" : " + date + ", "
			+ " \"status\" : " + status + ", "
			+ " \"agent\" : " + agent.getNombre() + ", "
			+ " \"tags\" : [" + tagsList() + "]} ";
	}
	
	private String tagsList() {
		String list = "";
		for(int i = 0; i < tags.size(); i++) 
			list += tags.get(i) + ((i == tags.size() - 1) ? "" : ", ");
		return list;
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