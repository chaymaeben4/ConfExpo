package com.example.design;

public class ApplicationController {
    private static ApplicationController instance;
    private String selectedRole;
    private String username;

    private ApplicationController() {
        // Private constructor to enforce singleton pattern
    }

    public static ApplicationController getInstance() {
        if (instance == null) {
            instance = new ApplicationController();
        }
        return instance;
    }

    public String getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(String role) {
        this.selectedRole = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
