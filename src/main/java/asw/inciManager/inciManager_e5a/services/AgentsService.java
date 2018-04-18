package asw.inciManager.inciManager_e5a.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import asw.inciManager.inciManager_e5a.entities.Agent;
import asw.inciManager.inciManager_e5a.repositories.AgentRepository;


@Service
public class AgentsService {

	@Autowired 
	AgentRepository repository;
	
	/**
	 * Método que permite la actualización de la contraseña del Agente
	 * Se comprueba que las contraseñas no estén vacías, sean distintas y 
	 * la actual coincida con la del agente
	 */
	public void updatePassword(Agent agent, String password, String newPassword) {
		
		if (password != null && newPassword != null && !(password.equals(newPassword))
				&& agent.getPassword().equals(password)) {
			agent.setPassword(newPassword);
			this.repository.save(agent);
		}
		
	}

	/**
	 * Método que permite la actualización del email del Participante
	 * Se comprueba que el email no esté vacío
	 */
	
	public void updateEmail(Agent agent, String email) {
		if(email != null){
			agent.setEmail(email);
			this.repository.save(agent);
		}
	}

	
	/**
	 * Método que devuelve el Agente buscado por email
	 * Hace uso del método findByEmail (mapeador)
	 */
	public Agent getAgent(String email) {
		
		return this.repository.findByEmail(email);
	}
	
}
