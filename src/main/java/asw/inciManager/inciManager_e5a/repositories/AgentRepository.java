package asw.inciManager.inciManager_e5a.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.inciManager.inciManager_e5a.entities.Agent;



@Repository
public interface AgentRepository extends CrudRepository<Agent, Long> {
	
	
	public Agent findByEmail(String email);
	
}
