package uo.asw.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import uo.asw.entities.Agent;



@Repository
public interface AgentRepository extends MongoRepository<Agent, Long> {
	
	
	public Agent findByEmail(String email);
	
}
