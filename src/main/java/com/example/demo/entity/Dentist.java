package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Dentist {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String photo;

    private boolean active;

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

}
