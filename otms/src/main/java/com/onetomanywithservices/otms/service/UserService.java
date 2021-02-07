package com.onetomanywithservices.otms.service;

import com.onetomanywithservices.otms.entity.Role;
import com.onetomanywithservices.otms.entity.User;
import com.onetomanywithservices.otms.repository.MyUserRepository;
import com.onetomanywithservices.otms.repository.RoleRepository;
import com.onetomanywithservices.otms.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private UserRepository userRepository;

    private MyUserRepository myUserRepository;

    public UserService(UserRepository userRepository, MyUserRepository myUserRepository) {
        this.userRepository = userRepository;
        this.myUserRepository = myUserRepository;
    }

    /**
     * Create a new role along with users
     */

    @Transactional
    public ResponseEntity<Object> addUser(User user) {

        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setMobile(user.getMobile());
        newUser.setEmail(user.getEmail());

        newUser.setMyUsers(user.getMyUsers());
        User savedUser = userRepository.save(newUser);
        if (userRepository.findById(savedUser.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully Created Role and Users");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
    }

    /**
     * Delete a specified role given the id
     */
    /*
    public ResponseEntity<Object> deleteRole(Long id) {
        if (roleRepository.findById(id).isPresent()) {
            roleRepository.deleteById(id);
            if (roleRepository.findById(id).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
            } else return ResponseEntity.ok().body("Successfully deleted specified record");
        } else
            return ResponseEntity.unprocessableEntity().body("No Records Found");
    }

     */

}
