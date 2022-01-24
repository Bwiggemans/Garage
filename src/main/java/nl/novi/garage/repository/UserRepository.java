package nl.novi.garage.repository;

import nl.novi.garage.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
