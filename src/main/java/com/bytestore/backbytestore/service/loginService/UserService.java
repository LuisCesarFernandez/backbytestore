package com.bytestore.backbytestore.service.loginService;

import java.util.List;
import java.util.Optional;

import com.bytestore.backbytestore.model.login.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytestore.backbytestore.repository.loginRepository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getIdUser(Long id) {
        return userRepository.findById(id);
    }

    public void postUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public void putUser(UserEntity userEntity, Long id) {
        userEntity.setId_user(id);
        userRepository.save(userEntity);
    }

}
