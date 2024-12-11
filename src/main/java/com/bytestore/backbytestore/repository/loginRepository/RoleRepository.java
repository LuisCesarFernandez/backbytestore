package com.bytestore.backbytestore.repository.loginRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytestore.backbytestore.model.login.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
