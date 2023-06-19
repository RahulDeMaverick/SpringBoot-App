package com.example.demo.controller;

import com.example.demo.pojo.Patient;
import com.example.demo.pojo.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user")
    @ResponseBody
    public ResponseEntity createUser(@RequestBody User user) {

        user= userService.createUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("User" +user.getUserName() +"created with userid" + user.getUserId());
    }
    @PostMapping("/api/verifyuser")
    @ResponseBody
    public ResponseEntity validUser(@RequestBody User user){
        boolean flag = userService.ValidateUser(user);
            if(!flag)  return ResponseEntity.status(HttpStatus.OK).body("User id and password does not match");

        return ResponseEntity.status(HttpStatus.OK).body("User logged in sucessfully  " +user.getUserName() );

    }
}
