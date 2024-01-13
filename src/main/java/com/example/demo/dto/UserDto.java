package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
public class UserDto {


        private String firstName;
        private String email;
        private String phone;
        private String password;
        private String matchingPassword;

}
