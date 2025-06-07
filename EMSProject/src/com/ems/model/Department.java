package com.ems.model;

public class Department {
    private int deptId;
    private String deptName;
    private String deptDescription;
    
    // Default constructor
    public Department() {}
    
    // Constructor with parameters
    public Department(String deptName, String deptDescription) {
        this.deptName = deptName;
        this.deptDescription = deptDescription;
    }
    
    // Getters and Setters
    public int getDeptId() { return deptId; }
    public void setDeptId(int deptId) { this.deptId = deptId; }
    
    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }
    
    public String getDeptDescription() { return deptDescription; }
    public void setDeptDescription(String deptDescription) { this.deptDescription = deptDescription; }
    
    @Override
    public String toString() {
        return deptName; // For ComboBox display
    }
}