package com.app.services.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.services.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
