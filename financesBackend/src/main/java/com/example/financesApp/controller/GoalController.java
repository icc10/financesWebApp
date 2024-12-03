package com.example.financesApp.controller;

import com.example.financesApp.model.Goal;
import com.example.financesApp.model.User;
import com.example.financesApp.repository.GoalRepo;
import com.example.financesApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goal")
public class GoalController {

    @Autowired
    private GoalRepo goalRepository; // injects the GoalRepository dependency

    @Autowired
    private UserRepo userRepository; // injects the UserRepository dependency
    /*
     * retrieves the user by username, returns "User not found." if user does not
     * exist
     * creates a new Goal object and sets its description and user
     * saves the goal to the repository
     */

    @PostMapping("/create")
    public String createGoal(@RequestParam String username, @RequestParam String description) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            return "User not found.";
        }
        Goal goal = new Goal();
        goal.setDescription(description);
        goal.setUser(user);
        goalRepository.save(goal);
        return "Goal created successfully.";
    }

    /*
     * retrieves the user by username, returns an empty list if user does not exist
     * retrieves and returns the list of goals for the user
     * returns an empty list if user not found
     */
    @GetMapping("/list")
    public List<Goal> listGoals(@RequestParam String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            return List.of(); // Return an empty list if user is not found
        }
        return goalRepository.findByUserId(user.getId());
    }

}