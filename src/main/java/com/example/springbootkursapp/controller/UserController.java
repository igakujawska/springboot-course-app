package com.example.springbootkursapp.controller;

import com.example.springbootkursapp.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //kontrolery do odbierania żądań,, ustawienie adnotacji
public class UserController {
    @GetMapping("/users") //przypisanie, zmapowanie prostego endpointu do kontrolera
    public List<User> getUsers()
    {
        List<User> users = new ArrayList<>();

        users.add(new User(1,"admin","admin","<EMAIL>"));
        users.add(new User(2,"user","user","<EMAIL>"));
        users.add(new User(3, "user2", "user2", "<EMAIL>"));

        return users;
    }
}
