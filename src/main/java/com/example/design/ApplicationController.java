package com.example.design;

public class ApplicationController {
    private static ApplicationController instance;
    private String selectedRole;
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
}
