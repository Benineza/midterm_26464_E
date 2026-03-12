package auca.ac.rw.digitalservices.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.digitalservices.domain.UserRequest;
import auca.ac.rw.digitalservices.service.UserServiceAssignmentService;
import auca.ac.rw.digitalservices.service.UserServiceManager;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceManager userService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserRequest request){

        String response = userService.saveUser(request);

        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/village/{villageId}")
public ResponseEntity<?> getUsersByVillage(@PathVariable Long villageId){

    return new ResponseEntity<>(
        userService.getUsersByVillage(villageId),
        HttpStatus.OK
    );
}

@Autowired
private UserServiceAssignmentService userServiceAssignmentService;

@PostMapping("/assign-service")
public ResponseEntity<?> assignService(
        @RequestParam UUID userId,
        @RequestParam UUID serviceId){

    String response = userServiceAssignmentService.assignService(userId, serviceId);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
}

}