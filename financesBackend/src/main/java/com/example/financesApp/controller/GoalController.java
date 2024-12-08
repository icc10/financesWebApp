package com.example.financesApp.controller;

import com.example.financesApp.model.Goal;
import com.example.financesApp.financeDB;
import com.example.financesApp.model.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/goal")
public class GoalController {

    private financeDB db;

    @Autowired
    public GoalController(financeDB db) {
        this.db = db;
    }

    /*
     * retrieves the user by username, returns "User not found." if user does not
     * exist
     * creates a new Goal object and sets its description and user
     * saves the goal to the repository
     */

    @PostMapping("/create")
    public String createGoal(@RequestParam String username, @RequestParam String goalName,
            @RequestParam int goalStartingAmount, @RequestParam int goalEndingAmount) {
        System.out.printf(
                "Received create goal request with username: %s, goalName: %s, goalStartingAmount: %d, goalEndingAmount: %d\n",
                username, goalName, goalStartingAmount, goalEndingAmount);

        if (!db.loginData.containsKey(username)) {
            return "User not found.";
        }

        db.addGoal(username, goalName, goalStartingAmount, goalEndingAmount);
        return "Goal added successfully.";
    }

    /*
     * retrieves the user by username, returns an empty list if user does not exist
     * retrieves and returns the list of goals for the user
     * returns an empty list if user not found
     */
    @GetMapping("/list")
    public List<Goal> listGoals(@RequestParam String username) {
        if (!db.loginData.containsKey(username)) {
            return new ArrayList<>();
        }
        List<Goal> goals = new ArrayList<>();
        List<Goal> financeGoals = db.getGoalsByUsername(username);
        for (Goal financeGoal : financeGoals) {
            goals.add(new Goal(username, financeGoal.getGoalName(), financeGoal.getGoalStartingAmount(),
                    financeGoal.getGoalEndingAmount()));
        }
        return goals;
    }
}