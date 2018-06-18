package asw.inciManager.inciManager_e5a.entities;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "incidencias")
public class Incidence {


	@Id
	private ObjectId _id;
	
	private String name, description;
	
	private Agent agent;

	private Date date;
	private IncidenceStatus status;
	
	private List<String> tags;
	
	private Map<String, String> properties;
	
	public Incidence(String name, String description, Agent agent, List<String> tags) {
		this.name = name;
		this.description = description;
		this.tags=tags;
		this.date = new Date();
		this.status = IncidenceStatus.OPENED;
		this.agent=agent;
		this.date=new Date();
		this.tags = tags;
	}

	public String getName() {
		return name;
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
		return "{ \"_id\" : \"" + _id + "\", "
			+ " \"name\" : \"" + name + "\", "
			+ " \"description\" : \"" + description + "\", "
			+ " \"date\" : \"" + date + "\", "
			+ " \"status\" : \"" + status + "\", "
			+ " \"agent\" : \"" + agent.getNombre() + "\", "
			+ " \"tags\" : [" + tagsList() + "]} ";
	}
	
	private String tagsList() {
		String list = "";
		for(int i = 0; i < tags.size(); i++) 
			list += "\"" + tags.get(i) + "\""+ ((i == tags.size() - 1) ? "" : ", ");
		return list;
	}

	@Override
	public String toString() {
		return "Incidence [id=" + _id + "#user=" + agent.getNombre() + "#indicenceName=" + name
				+ "#description=" + description + "#tags=<" + tags + ">]";
	}

	public ObjectId getId() {
		return _id;
	}

	public void setIdentificador(ObjectId id) {
		this._id = id;
	}

	public Date getDate() {
		return date;
	}

}