package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.pojo.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@Component
public class RestService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createUser( Patient patient) {
        return this.patientRepository.save(patient);
    }
    public List<Patient> getAllUsers() {
        return this.patientRepository.findAll();
    }

    public Patient getUserById(int id){ return this.patientRepository.findPatientByPatientId(id);   }


    public Patient getUserByName(String patient) {  return  this.patientRepository.findByName(patient); }

    public void deleteById(int userId) {    this.patientRepository.deletePatientByPatientId(userId);    }

    public  Patient findByEmail(String email){  return this.patientRepository.findPatientByEmail(email);    }
}
