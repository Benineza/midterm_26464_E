package auca.ac.rw.digitalservices.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.ac.rw.digitalservices.domain.ServiceEntity;
import auca.ac.rw.digitalservices.domain.User;
import auca.ac.rw.digitalservices.domain.UserService;
import auca.ac.rw.digitalservices.repository.ServiceRepository;
import auca.ac.rw.digitalservices.repository.UserRepository;
import auca.ac.rw.digitalservices.repository.UserServiceRepository;

@Service
public class UserServiceAssignmentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private UserServiceRepository userServiceRepository;

    public String assignService(UUID userId, UUID serviceId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ServiceEntity service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        UserService userService = new UserService();
        userService.setUser(user);
        userService.setService(service);

        userServiceRepository.save(userService);

        return "Service assigned successfully";
    }
}