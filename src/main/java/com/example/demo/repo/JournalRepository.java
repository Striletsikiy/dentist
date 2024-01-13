package com.example.demo.repo;

import com.example.demo.entity.Journal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface JournalRepository extends CrudRepository<Journal, Long> {

    @Query("SELECT j FROM Journal j WHERE j.patient.id = ?1 and date >= ?2")
    List<Journal> findPatientRecords(long patientId, Date date);

    @Query("SELECT j FROM Journal j WHERE j.dentist.id = ?1 and date >= ?2")
    List<Journal> findDentistRecords(long dentistId, Date date);

}
