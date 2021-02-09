package com.onetomanywithservices.otms.controller;

import com.onetomanywithservices.otms.entity.Role;
import com.onetomanywithservices.otms.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/role/create")
    public ResponseEntity<Object> createRole(@RequestBody Role role) {
        return  roleService.addRole(role);
    }
/*
    @PostMapping("/role/creates")
    public ResponseEntity<Object> createsRole(@RequestBody Role role) {
        return  roleService.addRoles(role);
    }

    @PostMapping("/role/just")
    public ResponseEntity<Object> justRole(@RequestBody Role role) {
        return  roleService.justRole(role);
    }


 */

    @DeleteMapping("/role/delete/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }

    @GetMapping("/role/details/{id}")
    public Role getRole(@PathVariable Long id) {
        return roleService.getRole(id);
    }
}
