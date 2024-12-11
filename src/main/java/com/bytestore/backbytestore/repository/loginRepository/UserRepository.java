package com.bytestore.backbytestore.repository.loginRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytestore.backbytestore.model.login.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
