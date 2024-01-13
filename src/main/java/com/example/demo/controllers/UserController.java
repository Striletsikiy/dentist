package com.example.demo.controllers;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Journal;
import com.example.demo.entity.Patient;
import com.example.demo.entity.User;
import com.example.demo.repo.JournalRepository;
import com.example.demo.repo.PatientRepository;
import com.example.demo.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {
//    private final UserPage userPage;

    @Autowired
    JournalRepository journalRepo;
    @Autowired
    PatientRepository patientRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    public PasswordEncoder passEncoder;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @GetMapping("/UserPage")
    public String userPage(Principal principal, Model model) {

        Authentication authentication = (Authentication) principal;
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        final String username = user.getUsername();
        Patient patient = patientRepo.getPatientByUsername(username);
        final Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        final List<Journal> patientRecords = journalRepo.findPatientRecords(patient.getId(), calendar.getTime());

        model.addAttribute("patientRecords", patientRecords);

        return "UserPage";
    }

    @GetMapping("/UserPage/delete/{id}")
    public String deleteDentist(@PathVariable String id){
        Optional<Journal> byId = journalRepo.findById(Long.valueOf(id));
        if(byId.isPresent()){
            journalRepo.delete(byId.get());
        }
        return "redirect:/UserPage";
    }

    @GetMapping("/UserPage/edit/{id}")
    public String editDentist(@PathVariable String id){
        Optional<Journal> byId = journalRepo.findById(Long.valueOf(id));
        if(byId.isPresent()){
            journalRepo.delete(byId.get());
        }
        return "/RecordDentist";
    }
}
