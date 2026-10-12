package com.example.springbootkursapp.init;

import com.example.springbootkursapp.model.Role;
import com.example.springbootkursapp.model.Task;
import com.example.springbootkursapp.model.User;
import com.example.springbootkursapp.repository.TaskRepository;
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
        private final TaskRepository taskRepository;

        public DataLoader(PasswordEncoder passwordEncoder, UserRepository userRepository, TaskRepository taskRepository)
        {
            this.passwordEncoder = passwordEncoder;
            this.userRepository = userRepository;
            this.taskRepository = taskRepository;
        }

        @Override
        public void run(String... args) throws Exception
        {
            if(userRepository.count()==0) {
                User admin = new User("admin", passwordEncoder.encode("admin1234"), "admin@gmail.com", Role.ADMIN);
                User user = new User("user", passwordEncoder.encode("user1234"), "user@gmail.com", Role.USER);

                userRepository.saveAll(List.of(admin, user));
                System.out.println("Users loaded");

                Task adminTask1 =  new Task("Task1", "Make sandwich", admin);
                Task adminTask2 =  new Task("Task2", "Make money", admin);
                Task adminTask3 =  new Task("Task1", "Make butter", admin);

                Task userTask1 = new Task("Pizza", "Pizza is a dish of Italian origin...", user);
                Task userTask2 = new Task("Burger", "A burger is a large, flat, round, steak...", user);
                Task userTask3 = new Task("Pasta", "Pasta is a food made from a mixture of flour...", user);
                Task userTask4 = new Task("Sandwich", "A sandwich is a flat bread with lettuce...", user);
                Task userTask5 = new Task("Coffee", "Coffee is a brewed drink made from roasted...", user);

                taskRepository.saveAll(List.of(adminTask1, adminTask2, adminTask3, userTask1, userTask2, userTask3, userTask4, userTask5));
                System.out.println("Tasks loaded");

            }
        }

}
