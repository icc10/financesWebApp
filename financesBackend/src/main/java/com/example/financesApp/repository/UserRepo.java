package com.example.financesApp.repository;

import com.example.financesApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

//interface for managing users
//extends JpaRepository which provides CRUD operations
public interface UserRepo extends JpaRepository<User, Long> {

    //find user by username
    Optional<User> findByUsername(String username);
}
