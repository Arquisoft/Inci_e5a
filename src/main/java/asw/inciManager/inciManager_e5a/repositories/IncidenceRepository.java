package asw.inciManager.inciManager_e5a.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import asw.inciManager.inciManager_e5a.entities.Incidence;


public interface IncidenceRepository extends MongoRepository<Incidence, ObjectId> {

	
	
}
