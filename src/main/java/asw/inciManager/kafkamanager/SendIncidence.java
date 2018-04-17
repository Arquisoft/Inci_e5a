package asw.inciManager.kafkamanager;

import asw.inciManager.inciManager_e5a.entities.Incidence;

public interface SendIncidence {
	
	String createMessage(Incidence incidence);
	void send(String message);

}
