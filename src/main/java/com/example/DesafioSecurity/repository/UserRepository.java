package com.example.DesafioSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.example.DesafioSecurity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    
    Optional<UserDetails> findUserByEmail(String username);
}
