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
	 * Método que devuelve el Agente buscado por email
	 * Hace uso del método findByEmail (mapeador)
	 */
	public Agent getAgent(String email) {
		
		return this.repository.findByEmail(email);
	}

	public void cambiarUsuario(Agent agente) {
		repository.save(agente);
	}
	
	
	
}
