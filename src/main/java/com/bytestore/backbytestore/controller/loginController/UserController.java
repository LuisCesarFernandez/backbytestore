package com.bytestore.backbytestore.controller.loginController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytestore.backbytestore.model.login.User;
import com.bytestore.backbytestore.service.loginService.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> listUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> listIdUser (@PathVariable Long id) {
        return userService.getIdUser(id);
    }

    @PostMapping("/")
    public void createUser(@RequestBody User user) {
        userService.postUser(user);
    }
    
}
