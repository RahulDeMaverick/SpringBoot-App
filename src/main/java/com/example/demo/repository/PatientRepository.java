package com.example.demo.repository;

import com.example.demo.pojo.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);

    Patient findPatientByPatientId(int id);
    Patient findPatientByEmail(String email);

    void deletePatientByPatientId(int id);


}
