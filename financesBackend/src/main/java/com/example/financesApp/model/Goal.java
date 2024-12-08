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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
