package com.example.springbootkursapp.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Override

    public void run(String... args) throws Exception {
        User admin = new User("admin", "admin", "ROLE_ADMIN");
        admin.setPassword("admin");
    }
}
