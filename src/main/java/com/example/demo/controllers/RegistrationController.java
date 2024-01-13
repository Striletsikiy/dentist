package com.example.demo.controllers;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Authority;
import com.example.demo.entity.Patient;
import com.example.demo.entity.User;
import com.example.demo.repo.AuthorityRepository;
import com.example.demo.repo.PatientRepository;
import com.example.demo.repo.UserRepository;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    PatientRepository patientRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    AuthorityRepository authorityRepo;
    @Autowired
    public PasswordEncoder passEncoder;

    @GetMapping("/SignUp")
    public String signUp(Model model){
        model.addAttribute("user", new UserDto());
        return "SignUp";
    }
    @PostMapping ("/SignUp")
    public String registration(Model model, UserDto userDto){

        EmailValidator emailValidator = EmailValidator.getInstance();

        if (!emailValidator.isValid(userDto.getEmail())){

            return "redirect:/SiqnUp";
        }

        User user = new User();
        user.setName(userDto.getEmail());
        user.setPassword(passEncoder.encode(userDto.getPassword()));
        user.setActive(true);
        user = userRepo.save(user);

        Patient patient = new Patient();
        patient.setName(userDto.getFirstName());
        patient.setPhone(userDto.getPhone());
        patient.setUser(user);
        patientRepo.save(patient);

        Authority authority = new Authority();
        authority.setUsername(userDto.getEmail());
        authority.setAuthority("ROLE_CLIENT");
        authorityRepo.save(authority);

        return "login";
    }
}
