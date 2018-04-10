package asw.kafkamanager;

import asw.dbManagement.model.Incidence;

public interface SendIncidence {
	
	String createMessage(Incidence incidence);
	void send(String message);

}
