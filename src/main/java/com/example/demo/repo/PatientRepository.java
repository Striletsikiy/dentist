package com.example.demo.repo;

import com.example.demo.entity.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p Where p.user.name = ?1")
    Patient getPatientByUsername(String username);
}
