package asw.inciManager.kafkamanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.inciManager.inciManager_e5a.entities.Incidence;
import asw.inciManager.kafkamanager.producers.KafkaProducer;

@Service
public class SendIncidenceImpl implements SendIncidence{
	
	@Autowired
	KafkaProducer kafkaProducer;
	private final static String TOPIC = "Incidencia";

	@Override
	public String createMessage(Incidence incidence) {
		
		return incidence.toString();
	
	}

	@Override
	public void send(String message) {
		kafkaProducer.send(TOPIC, message);
	}


	

}
