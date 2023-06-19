package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.pojo.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User,UUID> {

    User findUserByUserName(String name);

}
