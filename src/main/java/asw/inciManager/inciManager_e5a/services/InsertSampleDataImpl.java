package asw.inciManager.inciManager_e5a.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.inciManager.inciManager_e5a.entities.Agent;
import asw.inciManager.inciManager_e5a.repositories.AgentRepository;



@Service
public class InsertSampleDataImpl  {
	
	@Autowired
	private AgentRepository agentRepository;

	@PostConstruct
	public void insertar() {
		Agent a1 = new Agent("Guille", "Contra", "guille@uniovi.es", "I1", "Pola", "Persona", 2), 
				a2 = new Agent("Jesus", "Contra", "jesus@uniovi.es", "I2", "Mieres", "Persona", 2),
				a3 = new Agent("Miguel", "Contra", "miguel@uniovi.es", "I3", "Pravia", "Persona", 2),
				a4 = new Agent("Alvaro", "Contra", "alvaro@uniovi.es", "I4", "Sotrondio", "Persona", 2);
		
		agentRepository.save(a1);
		agentRepository.save(a2);
		agentRepository.save(a3);
		agentRepository.save(a4);
	}
}
