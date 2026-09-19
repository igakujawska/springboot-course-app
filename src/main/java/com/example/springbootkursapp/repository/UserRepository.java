package com.example.springbootkursapp.repository;

import com.example.springbootkursapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//chcemy zeby pobieralo, zapisywało dane bez skomplikowanych zapytan np. sql
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
