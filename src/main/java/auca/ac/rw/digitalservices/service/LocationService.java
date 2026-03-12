package auca.ac.rw.digitalservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import auca.ac.rw.digitalservices.domain.Location;
import auca.ac.rw.digitalservices.domain.LocationRequest;
import auca.ac.rw.digitalservices.repository.LocationRepository;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location saveLocation(Location location, Long parentId) {

        if(locationRepository.existsByCode(location.getCode())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Location with this code already exists");
        }

        if(parentId != null) {
            Optional<Location> parentLocation = locationRepository.findById(parentId);
            parentLocation.ifPresent(location::setParent);
        }

        return locationRepository.save(location);
    }
    public Location updateLocation(Long id, LocationRequest request) {

    Location existing = locationRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Location not found"));

    if (!existing.getCode().equals(request.getCode()) && locationRepository.existsByCode(request.getCode())) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Location code already exists");
    }

    existing.setCode(request.getCode());
    existing.setName(request.getName());
    existing.setType(request.getType());

    if (request.getParentId() != null) {
        Location parent = locationRepository.findById(request.getParentId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parent location not found"));
        existing.setParent(parent);
    } else {
        existing.setParent(null);
    }

    return locationRepository.save(existing);
}
}