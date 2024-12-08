package com.example.financesApp.controller;

import com.example.financesApp.model.Goal;
import com.example.financesApp.model.User;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goal")
public class GoalController {

    /*
     * retrieves the user by username, returns "User not found." if user does not
     * exist
     * creates a new Goal object and sets its description and user
     * saves the goal to the repository
     */

    @PostMapping("/create")
    public String createGoal(@RequestParam String username, @RequestParam String goalName,
            @RequestParam int goalStartingAmount, @RequestParam int goalEndingAmount) {
        // TODO: implement createGoal
        return "User not found.";
    }

    /*
     * retrieves the user by username, returns an empty list if user does not exist
     * retrieves and returns the list of goals for the user
     * returns an empty list if user not found
     */
    @GetMapping("/list")
    public List<Goal> listGoals(@RequestParam String username) {
        // TODO: implement listGoals
        return null;
    }

}