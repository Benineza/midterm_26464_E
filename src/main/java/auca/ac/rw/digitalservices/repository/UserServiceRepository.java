package auca.ac.rw.digitalservices.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import auca.ac.rw.digitalservices.domain.UserService;

public interface UserServiceRepository extends JpaRepository<UserService, UUID> {

}