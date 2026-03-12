package auca.ac.rw.digitalservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import auca.ac.rw.digitalservices.domain.Location;
import auca.ac.rw.digitalservices.domain.User;
import auca.ac.rw.digitalservices.domain.UserRequest;
import auca.ac.rw.digitalservices.repository.LocationRepository;
import auca.ac.rw.digitalservices.repository.UserRepository;

@Service
public class UserServiceManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    public String saveUser(UserRequest request){

        Boolean exists = userRepository.existsByEmail(request.getEmail());

        if(exists){
            return "User already exists.";
        }

        Location village = locationRepository.findById(request.getVillageId())
                .orElseThrow(() -> new RuntimeException("Village not found"));

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setLocation(village);
        

        userRepository.save(user);

        return "User saved successfully.";
    }

    public Page<User> getUsers(int page,int size){

        Pageable pageable =
        PageRequest.of(page,size,Sort.by("firstName"));

        return userRepository.findAll(pageable);

    }
    public List<User> getUsersByVillage(Long villageId){
    return userRepository.findByLocation_Id(villageId);
}

}