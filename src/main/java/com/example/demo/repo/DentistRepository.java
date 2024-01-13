package com.example.demo.repo;

import com.example.demo.entity.Dentist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DentistRepository extends CrudRepository<Dentist, Long> {
    List<Dentist> findByActive(Boolean isActive);

    @Query("SELECT d FROM Dentist d Where d.user.name = ?1")
    Dentist getDentistByUsername(String username);

}
