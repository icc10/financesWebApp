package com.example.financesApp.service;

import com.example.financesApp.model.User;
import com.example.financesApp.financeDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Service class for user authentication
 * manages user registration and login
 */
@Service
public class AuthService {

    private financeDB db;

    @Autowired
    public AuthService(financeDB db) {
        this.db = db;
    }

    /*
     * method to register a new user in the system
     * checks for existing username and creates a new user if username is unique
     * note: password storage is not secure and should use hashing in a real
     * application
     */

    /*
     * a full implementiatoin would be much more secure
     */
    public boolean login(String username, String password) {
        // check if the username and password match
        if (db.loginData.containsKey(username) && db.loginData.get(username).equals(password)) {
            return true;
        } else {
            db.addLogin(username, password);
            return true;
        }
    }
}