package com.example.demo.repo;

import com.example.demo.entity.DentistCalendar;
import com.example.demo.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface DentistCalendarRepository extends JpaRepository<DentistCalendar,Long> {

    @Query("SELECT d FROM DentistCalendar d WHERE d.dentist.id = ?1 and date >= ?2")
    List<DentistCalendar> getDentistCalendar(long dentistId, Date date);



}
