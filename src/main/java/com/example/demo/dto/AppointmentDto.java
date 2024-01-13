package com.example.demo.dto;

import com.example.demo.entity.Patient;
import lombok.Data;

@Data
public class AppointmentDto {

    //Date and time
    private String date;

    private String time;

    // Послуга
    private long serviceId;

    // Стоматолог
    private long dentistId;

    // ID клієнта (пізніше будеш витягати з security
    private Patient user;


}
