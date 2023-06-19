package com.example.demo.service;

import com.example.demo.pojo.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        String password = user.getPassword();
        String hashedPassword = PasswordUtils.hashPassword(password);
        user.setPassword(hashedPassword);
        return this.userRepository.save(user);
    }


    public boolean ValidateUser(User user) {
      User  newUser = userRepository.findUserByUserName(user.getUserName());
        if(newUser == null) return false;
        return PasswordUtils.verifyPassword(user.getPassword(),newUser.getPassword());
    }
}
