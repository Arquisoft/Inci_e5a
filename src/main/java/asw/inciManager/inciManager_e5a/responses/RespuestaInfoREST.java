package asw.inciManager.inciManager_e5a.responses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import asw.inciManager.inciManager_e5a.entities.Agent;


@XmlRootElement(name = "agent")
public class RespuestaInfoREST {	
	
	private String firstName;
	private String ID;
	private String email;
	
	public RespuestaInfoREST() {}
	
	public RespuestaInfoREST(Agent agent){
		setFirstName(agent.getNombre());
		setID(agent.getIdentificador());
		setEmail(agent.getEmail());
//		this.firstName = participant.getNombre();
//		this.lastName = participant.getApellidos();
//		this.edad = Utilidades.getEdad(participant.getFechaNacimiento());
//		this.ID = participant.getDNI();
//		this.email = participant.getEmail();
	}

	public String getFirstName() {
		return firstName;
	}

	@XmlElement
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
//....

	public String getID() {
		return ID;
	}

	@XmlElement
	public void setID(String iD) {
		ID = iD;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

}
