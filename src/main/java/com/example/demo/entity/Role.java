package com.example.demo.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_CLIENT,
    ROLE_DENTIST,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
