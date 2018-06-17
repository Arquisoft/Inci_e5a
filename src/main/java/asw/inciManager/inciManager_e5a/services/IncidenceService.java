package asw.inciManager.inciManager_e5a.services;


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
		kafkaProducer.send("gygw6fys-Incidencias",incidence.toString());
	}
	
	public Incidence getIncidenceById(Long id)
	{
		return incidenceRepository.findOne(id);
	}
	
	public Incidence saveIncidence (Incidence incidence)
	{
		return incidenceRepository.save(incidence);
	}
}
