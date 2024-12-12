package com.bytestore.backbytestore.service.loginService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytestore.backbytestore.model.login.User;
import com.bytestore.backbytestore.repository.loginRepository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> getIdUser(Long id) {
        return userRepository.findById(id);
    }

    public String postUser(User user) {
        userRepository.save(user);
        return "User created";
    }

    public String putUser(User user, Long id) {
        user.setId_user(id);
        userRepository.save(user);
        return "user updated";
    }

}
