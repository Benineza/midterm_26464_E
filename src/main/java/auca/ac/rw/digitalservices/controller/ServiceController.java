package auca.ac.rw.digitalservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.digitalservices.domain.ServiceEntity;
import auca.ac.rw.digitalservices.service.ServiceService;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;


    @PostMapping(value="/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveService(@RequestBody ServiceEntity service){

        String response = serviceService.saveService(service);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllServices(){

        List<ServiceEntity> services = serviceService.getAllServices();

        return new ResponseEntity<>(services, HttpStatus.OK);

    }

}