package com.example.financesApp;

import com.example.financesApp.model.Goal;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class financeDB {

    public Map<String, String> loginData;
    public Map<String, List<Goal>> userGoals;
    private static final String LOGIN_FILE = "loginData.txt";
    private static final String GOALS_FILE = "goalsData.txt";

    public financeDB() {
        loginData = new HashMap<>();
        userGoals = new HashMap<>();
        loadData();
    }

   

    public void connect() {
    }

    public void addLogin(String username, String password) {
        loginData.put(username, password);
        saveData();
    }

    public void addGoal(String username, String goalName, int startingAmount, int endingAmount) {
        Goal goal = new Goal(username, goalName, startingAmount, endingAmount);
        userGoals.computeIfAbsent(username, k -> new ArrayList<>()).add(goal);
        saveData();
    }

    public List<Goal> getGoalsByUsername(String username) {
        return userGoals.getOrDefault(username, new ArrayList<>());
    }

    private void saveData() {
        try {
            BufferedWriter loginWriter = new BufferedWriter(new FileWriter(LOGIN_FILE));
            for (Map.Entry<String, String> entry : loginData.entrySet()) {
                loginWriter.write(entry.getKey() + ":" + entry.getValue());
                loginWriter.newLine();
            }
            loginWriter.close();

            BufferedWriter goalsWriter = new BufferedWriter(new FileWriter(GOALS_FILE));
            for (Map.Entry<String, List<Goal>> entry : userGoals.entrySet()) {
                for (Goal goal : entry.getValue()) {
                    goalsWriter.write(
                            entry.getKey() + ":" + goal.getGoalName() + ":" + goal.getGoalStaringAmount() + ":" + goal.getGoalEndingAmount());
                    goalsWriter.newLine();
                }
            }
            goalsWriter.close();
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    private void loadData() {
        try {
            BufferedReader loginReader = new BufferedReader(new FileReader(LOGIN_FILE));
            String line;
            while ((line = loginReader.readLine()) != null) {
                String[] parts = line.split(":");
                loginData.put(parts[0], parts[1]);
            }
            loginReader.close();

            BufferedReader goalsReader = new BufferedReader(new FileReader(GOALS_FILE));
            while ((line = goalsReader.readLine()) != null) {
                String[] parts = line.split(":");
                String username = parts[0];
                String goalName = parts[1];
                int startingAmount = Integer.parseInt(parts[2]);
                int endingAmount = Integer.parseInt(parts[3]);
                Goal goal = new Goal(username, goalName, startingAmount, endingAmount);
                userGoals.computeIfAbsent(username, k -> new ArrayList<>()).add(goal);
            }
            goalsReader.close();
        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        financeDB app = new financeDB();
        app.addLogin("user1", "password123");
        app.addGoal("user1", "Save for vacation", 1000, 5000);

        List<Goal> goals = app.getGoalsByUsername("user1");
        System.out.println("Goals for user1:");
        for (Goal goal : goals) {
            System.out.println(goal);
        }

        app.saveData();
        app.loadData();
    }
}
