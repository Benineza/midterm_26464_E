package auca.ac.rw.digitalservices.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import auca.ac.rw.digitalservices.domain.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    Boolean existsByEmail(String email);

    List<User> findByLocation_Name(String name);
    List<User> findByLocation_Id(Long locationId);

}