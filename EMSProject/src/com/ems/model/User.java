package com.ems.model;

public class User {
    private int userId;
    private String username;
    private String password;
    private String role;
    private Integer empId;
    private boolean isActive;
    
    // Default constructor
    public User() {}
    
    // Constructor with parameters
    public User(String username, String password, String role, Integer empId) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.empId = empId;
        this.isActive = true;
    }
    
    // Getters and Setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    
    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }
    
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    
    public boolean isAdmin() { return "admin".equals(role); }
    public boolean isEmployee() { return "employee".equals(role); }
    
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", empId=" + empId +
                '}';
    }
}