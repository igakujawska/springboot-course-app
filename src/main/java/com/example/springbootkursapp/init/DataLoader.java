package com.example.springbootkursapp.init;

import com.example.springbootkursapp.model.Role;
import com.example.springbootkursapp.model.User;
import com.example.springbootkursapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
        public class DataLoader implements CommandLineRunner
{

        private final PasswordEncoder passwordEncoder; //dzieki temu ze stworzylismy beany mozemy teraz latwo sie do nich odwolywac i je przerzucac
        private final UserRepository userRepository;

        public DataLoader(PasswordEncoder passwordEncoder, UserRepository userRepository)
        {
            this.passwordEncoder = passwordEncoder;
            this.userRepository = userRepository;
        }

        @Override
        public void run(String... args) throws Exception
        {
            if(userRepository.count()==0) {
                User admin = new User("admin", passwordEncoder.encode("admin1234"), "admin@gmail.com", Role.ADMIN);
                User user = new User("user", passwordEncoder.encode("user1234"), "user@gmail.com", Role.USER);

                userRepository.saveAll(List.of(admin, user));
                System.out.println("Users loaded");
            }
        }

}
