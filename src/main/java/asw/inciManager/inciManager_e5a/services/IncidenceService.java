package asw.inciManager.inciManager_e5a.services;


import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.inciManager.inciManager_e5a.entities.Incidence;
import asw.inciManager.inciManager_e5a.repositories.IncidenceRepository;
import asw.inciManager.kafkamanager.producers.KafkaProducer;

@Service
public class IncidenceService {

	@Autowired
	private IncidenceRepository incidenceRepository;
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	
	public void addIncidence(Incidence incidence) {
		incidenceRepository.save(incidence);
		kafkaProducer.send("gygw6fys-Incidencias",incidence.toJSON());
	}
	
	public Incidence getIncidenceById(ObjectId id)
	{
		return incidenceRepository.findOne(id);
	}
	
	public List<Incidence> getIncidencesByAgentId(String id)
	{
		return incidenceRepository.findByAgentIdentificador(id);
	}
	
	public Incidence saveIncidence (Incidence incidence)
	{
		return incidenceRepository.save(incidence);
	}
}
