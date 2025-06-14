package com.majed.SpringSecTemplate.repository;

import com.majed.SpringSecTemplate.domain.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
