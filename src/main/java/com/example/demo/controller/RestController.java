package com.example.demo.controller;

import com.example.demo.pojo.Patient;
import com.example.demo.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    RestService restService;
    @PostMapping("/api/add/patient")
    @ResponseBody
    public ResponseEntity createUser(@RequestBody Patient patient) {
        Patient patientResp = restService.findByEmail(patient.getEmail());
        if (patientResp != null) {
            return ok("Already exist");
        }
        patient= restService.createUser(patient);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }
    @GetMapping("/api/users")
    public List<Patient> getAll() {
        return restService.getAllUsers();
    }


    @GetMapping("/api/user/{id}")
    public Patient getUserById(@PathVariable(value = "id") long userId) {
        Patient patient = restService.getUserById((int) userId);
        return patient;
    }

    @GetMapping("/api/username/{name}")
    public  Patient getUserByUname(@PathVariable(value = "name") String name){
        Patient patient = restService.getUserByName(name);
        return patient;
    }
    @GetMapping("/api/email/{email}")
    public Patient getUserByEmail(@PathVariable(value = "email") String email){
        return restService.findByEmail(email);
    }
    @DeleteMapping("/api/user/{id}")
    @ResponseBody
    public ResponseEntity deleteById(@PathVariable(value = "id") long userId) {
        restService.deleteById((int) userId);
        return ok("User Sucessfully deleted");
    }

    protected ResponseEntity ok(String jsonBody) {
        return ResponseEntity.ok(jsonBody);
    }
}
