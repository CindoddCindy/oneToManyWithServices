package com.onetomanywithservices.otms.service;


import com.onetomanywithservices.otms.entity.MyUser;
import com.onetomanywithservices.otms.entity.Role;
import com.onetomanywithservices.otms.repository.RoleRepository;
import com.onetomanywithservices.otms.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    private UserRepository userRepository;

    public RoleService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    /**
     * Create a new role along with users
     */

    @Transactional
    public ResponseEntity<Object> addRole(Role role) {

        Role newRole = new Role();
        newRole.setName(role.getName());
        newRole.setDescription(role.getDescription());

        newRole.setUsers(role.getUsers());
        newRole.setMyUsers(role.getMyUsers());
        Role savedRole = roleRepository.save(newRole);
        if (roleRepository.findById(savedRole.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully Created Role and Users");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
    }

    /*

    @Transactional
    public ResponseEntity<Object> justRole(Role role) {

        Role newRole = new Role();
        newRole.setName(role.getName());
        newRole.setDescription(role.getDescription());

       // newRole.setUsers(role.getUsers());
        Role savedRole = roleRepository.save(newRole);
        if (roleRepository.findById(savedRole.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully Created Role and Users");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
    }


    @Transactional
    public ResponseEntity<Object> addRoles(Role role) {

        Role newRole = new Role();
        newRole.setName(role.getName());
        newRole.setDescription(role.getDescription());

        newRole.setMyUsers(role.getMyUsers());
        Role savedRole = roleRepository.save(newRole);
        if (roleRepository.findById(savedRole.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully Created Role and Users");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
    }

     */

    /**
     * Delete a specified role given the id
     */
    public ResponseEntity<Object> deleteRole(Long id) {
        if (roleRepository.findById(id).isPresent()) {
            roleRepository.deleteById(id);
            if (roleRepository.findById(id).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
            } else return ResponseEntity.ok().body("Successfully deleted specified record");
        } else
            return ResponseEntity.unprocessableEntity().body("No Records Found");
    }

    public Role getRole(Long id) {
        if(roleRepository.findById(id).isPresent()) {
            Role role = roleRepository.findById(id).get();
            Role roleModel = new Role();
            roleModel.setName(role.getName());
            roleModel.setDescription(role.getDescription());
            roleModel.setUsers(role.getUsers());
            roleModel.setMyUsers(role.getMyUsers());
            return roleModel;
        } else return null;
    }

}
