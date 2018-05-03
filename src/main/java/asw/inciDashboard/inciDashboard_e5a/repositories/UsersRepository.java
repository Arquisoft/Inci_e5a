package asw.inciDashboard.inciDashboard_e5a.repositories;

import org.springframework.data.repository.CrudRepository;

import asw.inciDashboard.inciDashboard_e5a.model.User;

public interface UsersRepository extends CrudRepository<User, Long> {

    User findByIdentificador(String dni);

}
