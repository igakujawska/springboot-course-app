package com.example.springbootkursapp.service;

import com.example.springbootkursapp.model.User;
import com.example.springbootkursapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();

        public User addUser(@RequestBody User user)
        {
            return userRepository.save(user);
        }
    }
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
}
}
