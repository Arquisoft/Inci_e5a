package asw.inciManager.inciManager_e5a.services;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import asw.inciManager.inciManager_e5a.entities.Agent;
import asw.inciManager.inciManager_e5a.repositories.AgentRepository;


@Service
public class AgentsService {

	@Autowired 
	private AgentRepository agentsRepository;
	
	public static final String URL = "http://localhost:8081/agents";
	
	/**
	 * Método que devuelve el Agente buscado por email
	 * Hace uso del método findByEmail (mapeador)
	 */
	public Agent getAgent(String email) {
		
		return agentsRepository.findByEmail(email);
	}

	public void cambiarUsuario(Agent agente) {
		agentsRepository.save(agente);
	}
	
	public boolean comprobarAgente(String email, String pass, String kind) {
		PeticionAgenteREST agente = new PeticionAgenteREST(email, pass, kind);
		String res = new RestTemplate().postForEntity(URL, agente, String.class).getBody();
		try {
			JSONObject json = new JSONObject(res);
			return json.get("email").equals(email);
		} catch (JSONException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	class PeticionAgenteREST {
		
		private String login, password, kind;
		
		PeticionAgenteREST(String login, String password, String kind) {
			setLogin(login);
			setPassword(password);
			setKind(kind);
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getKind() {
			return kind;
		}

		public void setKind(String kind) {
			this.kind = kind;
		}
		
		
	}
}
