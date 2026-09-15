package com.example.springbootkursapp.controller;

import com.example.springbootkursapp.model.User;
import com.example.springbootkursapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //kontrolery do odbierania żądań,, ustawienie adnotacji
public class UserController {

    private final UserRepository userRepository;

    @Autowired //trzeba dopisac jak jest wiecej konstruktorów niz jeden
    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @GetMapping("/users") //przypisanie, zmapowanie prostego endpointu do kontrolera
    public List<User> getUsers()
    {
        return userRepository.findAll(); //mozemy uzyc funkcji, bo mamy juz repo
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user)
    {
        return userRepository.save(user);
    }
}
