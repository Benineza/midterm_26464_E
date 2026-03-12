package auca.ac.rw.digitalservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.digitalservices.domain.Location;
import auca.ac.rw.digitalservices.domain.LocationRequest;
import auca.ac.rw.digitalservices.service.LocationService;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/save")
    public String saveLocation(@RequestBody LocationRequest request) {

        Location location = new Location();
        location.setCode(request.getCode());
        location.setName(request.getName());
        location.setType(request.getType());

        locationService.saveLocation(location, request.getParentId());

        return "Location saved successfully";
    }
    
    @PutMapping("/update/{id}")
public String updateLocation(@PathVariable Long id, @RequestBody LocationRequest request) {
    locationService.updateLocation(id, request);

    return "Location updated successfully";
}
}