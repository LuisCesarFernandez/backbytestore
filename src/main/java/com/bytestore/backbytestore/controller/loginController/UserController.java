package com.bytestore.backbytestore.controller.loginController;

import java.util.List;
import java.util.Optional;

import com.bytestore.backbytestore.model.login.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.bytestore.backbytestore.service.loginService.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/")
    public List<UserEntity> listUser() {
        return userService.getAllUser();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public Optional<UserEntity> listIdUser (@PathVariable Long id) {
        return userService.getIdUser(id);
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/")
    public String createUser(@RequestBody UserEntity userEntity) {
        userService.postUser(userEntity);
        return "user created";
    }
    
}
