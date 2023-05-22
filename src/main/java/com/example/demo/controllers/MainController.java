package com.example.demo.controllers;

import com.example.demo.dto.AppointmentDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.DentistCalendar;
import com.example.demo.entity.Journal;
import com.example.demo.repo.DentistCalendarRepository;
import com.example.demo.repo.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.apache.coyote.http11.Constants.a;

@Controller
public class MainController {

    @Autowired
    private DentistRepository dentistRepo;

    @Autowired
    private DentistCalendarRepository dentistCalendarRepo;

    @GetMapping("/")
    public String main(Model model) {
        return "Main";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }
    @GetMapping("/dentist")
    public String dentist(Model model){
        model.addAttribute("dentists", dentistRepo.findByActive(true));
        model.addAttribute("appointmentData", new AppointmentDto());

        return "dentist";
    }

    @PostMapping ("/calendar")
    public String calendar(Model model, AppointmentDto appointmentDto){

        final Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        final List<DentistCalendar> dentistCalendars = dentistCalendarRepo.getDentistCalendar(appointmentDto.getDentistId(), calendar.getTime());
        model.addAttribute("dentistCalendars" , dentistCalendars);

        return "calendar";
    }
}
