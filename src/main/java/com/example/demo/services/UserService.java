//package com.example.demo.services;
//
//import com.example.demo.entity.User;
//import com.example.demo.entity.Role;
//import com.example.demo.repo.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class UserService {
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public boolean createUser (User user){
//        String email = user.getEmail();
//        if (userRepository.findByEmail(user.getEmail()) != null ) return false;
//        user.setActive(true);
//        user.getPassword(passwordEncoder.encode(user.getPassword()));
//        user.getRoles().add(Role.ROLE_USER);
//        log.info("Saving new User with email: {}", email);
//        return true;
//    }
//}
