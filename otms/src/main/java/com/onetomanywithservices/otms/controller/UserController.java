package com.onetomanywithservices.otms.controller;

import com.onetomanywithservices.otms.entity.Role;
import com.onetomanywithservices.otms.entity.User;
import com.onetomanywithservices.otms.service.RoleService;
import com.onetomanywithservices.otms.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return  userService.addUser(user);
    }
    /*
    @DeleteMapping("/role/delete/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }

     */
}
