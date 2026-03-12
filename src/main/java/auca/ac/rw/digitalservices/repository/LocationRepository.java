package auca.ac.rw.digitalservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import auca.ac.rw.digitalservices.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

    Boolean existsByCode(String code);

}