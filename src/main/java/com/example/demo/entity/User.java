package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @Column(name = "username")
    private String name;
    @Column(name = "enabled")
    private boolean active;
    @Column(name = "password", length = 100)
    private String password;

}
