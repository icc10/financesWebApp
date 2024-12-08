package com.example.financesApp.model;

/*
 * models a goal for a user
 * sql table is created with id, description, and user_id columns
 */
public class Goal {

    private User user;

    private String goalName;

    private int goalStaringAmount;

    private int goalEndingAmount;

    public Goal() {
    }

    public Goal(User user, String goalName, int goalStaringAmount, int goalEndingAmount) {
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
