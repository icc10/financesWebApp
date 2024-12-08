package com.example.financesApp.controller;

import com.example.financesApp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * Controller class for user authentication
 * manages user registration and login
 * all of the heavy lifting is done by the AuthServiceq
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/ping")
    public String ping() {
        return "Backend is running.";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        System.out.println("Received login request with username: " + username + " and password: " + password);
        boolean success = authService.login(username, password);
        return success ? "Login successful." : "Login failed.";
    }
}
