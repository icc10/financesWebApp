package com.example.financesApp.service;

import com.example.financesApp.model.User;
//import com.example.financesApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/*
 * Service class for user authentication
 * manages user registration and login
 */
@Service
public class AuthService {

    /*
     * method to register a new user in the system
     * checks for existing username and creates a new user if username is unique
     * note: password storage is not secure and should use hashing in a real
     * application
     */

    public boolean login(String username, String password) {
        // TODO: get login working
        return true;
    }
}
