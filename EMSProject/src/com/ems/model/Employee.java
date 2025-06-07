package com.ems.model;

import java.util.Date;

public class Employee {
    private int empId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Date hireDate;
    private double salary;
    private int deptId;
    private String status;
    private String deptName; // For display purposes
    
    // Default constructor
    public Employee() {}
    
    // Constructor with parameters
    public Employee(String firstName, String lastName, String email, String phone, 
                   String address, Date hireDate, double salary, int deptId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.hireDate = hireDate;
        this.salary = salary;
        this.deptId = deptId;
        this.status = "Active";
    }
    
    // Getters and Setters
    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getFullName() { return firstName + " " + lastName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }
    
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    
    public int getDeptId() { return deptId; }
    public void setDeptId(int deptId) { this.deptId = deptId; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }
    
    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + getFullName() + '\'' +
                ", email='" + email + '\'' +
                ", department='" + deptName + '\'' +
                ", salary=" + salary +
                '}';
    }
}