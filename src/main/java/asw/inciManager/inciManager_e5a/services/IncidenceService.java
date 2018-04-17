package asw.inciManager.inciManager_e5a.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.inciManager.inciManager_e5a.entities.Incidence;
import asw.inciManager.inciManager_e5a.repositories.IncidenceRepository;
import asw.inciManager.kafkamanager.SendIncidenceImpl;

@Service
public class IncidenceService {

	@Autowired
	private IncidenceRepository incidenceRepository;
	
	@Autowired
	private SendIncidenceImpl sender;
	
	public void addIncidence(Incidence incidence) {
		incidenceRepository.save(incidence);
	}
	
	public void sendIncidence(Incidence incidence) {
		String inci = sender.createMessage(incidence);
		sender.send(inci);
	}
	
	public Incidence getIncidenceById(Long id)
	{
		return incidenceRepository.findOne(id);
	}
	
	public Incidence saveIncidence (Incidence incidence)
	{
		sendIncidence(incidence);
		return incidenceRepository.save(incidence);
	}
}
