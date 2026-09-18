package com.example.springbootkursapp.controller;

import com.example.springbootkursapp.model.User;
import com.example.springbootkursapp.repository.UserRepository;
import com.example.springbootkursapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //kontrolery do odbierania żądań,, ustawienie adnotacji
@RequestMapping("/api") //dodanie czegos przed endpointem
public class UserController {

    private final UserService userService;

    @Autowired //trzeba dopisac jak jest wiecej konstruktorów niz jeden
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/users") //przypisanie, zmapowanie prostego endpointu do kontrolera
    public List<User> getUsers()
    {
        return userService.getUsers(); //mozemy uzyc funkcji, bo mamy juz repo
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
}
