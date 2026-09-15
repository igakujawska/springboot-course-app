package com.example.springbootkursapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //kontrolery do odbierania żądań,, ustawienie adnotacji
public class UserController {
    @GetMapping("/users") //przypisanie, zmapowanie prostego endpointu do kontrolera
    public String getUsers() {return "Lista użytkowników: ";}
}
