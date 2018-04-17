package asw.inciManager.inciManager_e5a.controller;

import asw.inciManager.inciManager_e5a.entities.Incidence;

public interface CreateIncidence {

	Incidence createIncidence(String user, String pass, String name, String description);
}
