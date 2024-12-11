package com.bytestore.backbytestore.service.loginService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytestore.backbytestore.model.login.Role;
import com.bytestore.backbytestore.repository.loginRepository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRole(){
        return roleRepository.findAll();
    }

    public void postRole(Role role) {
        roleRepository.save(role);
    }
}
