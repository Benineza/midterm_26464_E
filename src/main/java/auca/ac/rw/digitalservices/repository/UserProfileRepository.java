package auca.ac.rw.digitalservices.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import auca.ac.rw.digitalservices.domain.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, UUID> {

}