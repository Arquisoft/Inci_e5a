package asw.inciManager.inciManager_e5a.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.inciManager.inciManager_e5a.entities.Incidence;
import asw.inciManager.inciManager_e5a.repositories.IncidenceRepository;

@Service
public class IncidenceService {

	@Autowired
	private IncidenceRepository incidenceRepository;
	
	public void addIncidence(Incidence incidence) {
		incidenceRepository.save(incidence);
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
