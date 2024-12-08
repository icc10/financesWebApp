package com.example.financesApp.model;

/*
 * models a goal for a user
 * sql table is created with id, description, and user_id columns
 */
public class Goal {

    private String username;

    private String goalName;

    private int goalStaringAmount;

    private int goalEndingAmount;

    public Goal() {
    }

    public Goal(String user, String goalName, int goalStaringAmount, int goalEndingAmount) {
        this.username = user;
        this.goalName = goalName;
        this.goalStaringAmount = goalStaringAmount;
        this.goalEndingAmount = goalEndingAmount;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public int getGoalStaringAmount() {
        return goalStaringAmount;
    }

    public void setGoalStaringAmount(int goalStaringAmount) {
        this.goalStaringAmount = goalStaringAmount;
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
