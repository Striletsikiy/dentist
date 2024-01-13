package com.example.demo.controllers;

import com.example.demo.entity.Dentist;
import com.example.demo.entity.Journal;
import com.example.demo.repo.DentistRepository;
import com.example.demo.repo.JournalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class DentistController {
//    private final UserPage userPage;

    @Autowired
    JournalRepository journalRepo;
    @Autowired
    DentistRepository dentistRepository;

    @GetMapping("/DentistPage")
    public String userPage(Principal principal, Model model) {

        Authentication authentication = (Authentication) principal;
        User user = (User) authentication.getPrincipal();
        final String username = user.getUsername();
        Dentist dentist = dentistRepository.getDentistByUsername(username);
        final Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        final List<Journal> patientRecords = journalRepo.findDentistRecords(dentist.getId(), calendar.getTime());

        model.addAttribute("patientRecords", patientRecords);

        return "DentistPage";
    }

    @GetMapping("/DentistPage/delete/{id}")
    public String deleteRecord(@PathVariable String id){
        journalRepo.deleteById(Long.valueOf(id));
        return "redirect:/DentistPage";
    }
}