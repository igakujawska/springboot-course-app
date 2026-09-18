package com.example.springbootkursapp.service;

import com.example.springbootkursapp.model.User;
import com.example.springbootkursapp.repository.UserRepository;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers()
    {
        return userRepository.findAll();

    public User addUser(@RequestBody User user)
    {
        return userRepository.save(user);
    }
}
