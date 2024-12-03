package com.example.financesApp.service;

import com.example.financesApp.model.User;
import com.example.financesApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/*
 * Service class for user authentication
 * manages user registration and login
 */
@Service
public class AuthService {

    @Autowired
    private UserRepo userRepository;
    /*
    method to register a new user in the system
    checks for existing username and creates a new user if username is unique
    note: password storage is not secure and should use hashing in a real
    application
    */
    public String register(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            return "Username already exists.";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        return "User registered successfully.";
    }

    public boolean login(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent() && user.get().getPassword().equals(password);
    }
}
