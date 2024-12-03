package com.example.financesApp.repository;

import com.example.financesApp.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

//interface for managing goals
//extends JpaRepository which provides CRUD operations
// JPA (Java Persistence API) is an abstraction layer that 
    //simplifies how Java applications interact with a database.
public interface GoalRepo extends JpaRepository<Goal, Long> {

    //find goals by user id
    List<Goal> findByUserId(Long userId);
}
