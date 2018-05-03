package asw.inciDashboard.inciDashboard_e5a.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.inciDashboard.inciDashboard_e5a.model.Incidence;

@Repository
public interface IncidencesRepository extends CrudRepository<Incidence, Long> {

}
