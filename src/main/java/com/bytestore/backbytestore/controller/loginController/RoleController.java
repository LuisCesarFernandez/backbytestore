package com.bytestore.backbytestore.controller.loginController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytestore.backbytestore.model.login.Role;
import com.bytestore.backbytestore.service.loginService.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public List<Role> listRole() {
        return roleService.getRole();
    }
    
    @PostMapping("/")
    public String createRole(@RequestBody Role role) {
        roleService.postRole(role);
        return "role created";
    }
    
}
