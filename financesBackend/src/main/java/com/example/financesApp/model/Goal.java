package com.example.financesApp.model;

/*
 * models a goal for a user
 * sql table is created with id, description, and user_id columns
 */
public class Goal {

    private String username;
    private String goalName;
    private int goalStartingAmount;
    private int goalEndingAmount;

    public Goal() {
    }

    public Goal(String user, String goalName, int goalStartingAmount, int goalEndingAmount) {
        this.username = user;
        this.goalName = goalName;
        this.goalStartingAmount = goalStartingAmount;
        this.goalEndingAmount = goalEndingAmount;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public int getGoalStartingAmount() {
        return goalStartingAmount;
    }

    public void setGoalStartingAmount(int goalStartingAmount) {
        this.goalStartingAmount = goalStartingAmount;
    }

    public int getGoalEndingAmount() {
        return goalEndingAmount;
    }

    public void setGoalEndingAmount(int goalEndingAmount) {
        this.goalEndingAmount = goalEndingAmount;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String user) {
        this.username = user;
    }
}