package com.example.demo.repo;

import com.example.demo.entity.Authority;
import com.example.demo.entity.AuthorityId;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, AuthorityId> {

}

