package com.example.springbootkursapp.service;

import com.example.springbootkursapp.model.User;
import com.example.springbootkursapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; //interfejs do zamiany/enkodowania hasla

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
        public User addUser(User user)
        { //@RequestBody wystepuje tylko w kontrolerze, nie serwisie
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
}
}
