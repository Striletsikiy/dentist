package com.example.demo.controllers;

import com.example.demo.dto.AppointmentDto;
import com.example.demo.entity.Journal;
import com.example.demo.repo.DentistRepository;
import com.example.demo.repo.JournalRepository;
import com.example.demo.repo.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Calendar;
import java.util.Date;


@Controller
public class AppointmentController {

    @Autowired
    private JournalRepository journalRepo;

    @Autowired
    private DentistRepository dentistRepo;

    @Autowired
    private ServiceRepository serviceRepo;

    @GetMapping("/appointment")
    public String appointment(Model model) {
        model.addAttribute("dentists", dentistRepo.findByActive(true));
        model.addAttribute("services", serviceRepo.findByActive(true));
        model.addAttribute("appointmentData", new AppointmentDto());
        return "RecordDentist";
    }

    @PostMapping("/saveAppointment")
    public String saveAppointment(AppointmentDto appointmentData) {

        final String[] dateSplit = appointmentData.getDate().split("\\.");
        final String[] timeSplit = appointmentData.getTime().split(":");

        final Date date = new Calendar.Builder().setDate(
                        Integer.parseInt(dateSplit[2]),
                        Integer.parseInt(dateSplit[1]) - 1,
                        Integer.parseInt(dateSplit[0]))
                .setTimeOfDay(Integer.parseInt(timeSplit[0]), Integer.parseInt(timeSplit[1]), 0).build().getTime();

        final Journal journal = new Journal();
        journal.setDate(date);
        journal.setDentist(dentistRepo.findById(appointmentData.getDentistId()).get());
        journal.setService(serviceRepo.findById(appointmentData.getServiceId()).get());
        journal.setPatient(appointmentData.getUser());

        journalRepo.save(journal);

        return "redirect:/UserPage";
    }

    @GetMapping("/dentists")
    public String  showDentists(Model model) {
        model.addAttribute("dentists", dentistRepo.findByActive(true));
        return "Dentists";
    }

}
