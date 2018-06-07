package asw.inciManager.inciManager_e5a.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import asw.inciManager.inciManager_e5a.entities.Agent;



@Repository
public interface AgentRepository extends MongoRepository<Agent, Long> {
	
	
	public Agent findByEmail(String email);
	
}
