package auca.ac.rw.digitalservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.ac.rw.digitalservices.domain.ServiceEntity;
import auca.ac.rw.digitalservices.repository.ServiceRepository;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public String saveService(ServiceEntity service){

        serviceRepository.save(service);

        return "Service saved successfully.";
    }

    public List<ServiceEntity> getAllServices(){

        return serviceRepository.findAll();

    }

}