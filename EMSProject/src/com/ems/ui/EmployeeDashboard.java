//package com.ems.ui;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.text.SimpleDateFormat;
//import com.ems.db.EmployeeDAOImpl;
//import com.ems.model.Employee;
//import com.ems.model.User;
//
//public class EmployeeDashboard extends JFrame {
//    private User currentUser;
//    private Employee currentEmployee;
//    private EmployeeDAOImpl employeeDAO;
//    private JLabel nameLabel, emailLabel, phoneLabel, addressLabel;
//    private JLabel hireDateLabel, salaryLabel, departmentLabel, statusLabel;
//    
//    public EmployeeDashboard(User user) {
//        this.currentUser = user;
//        this.employeeDAO = new EmployeeDAOImpl();
//        loadEmployeeData();
//        initializeComponents();
//    }
//    
//    private void loadEmployeeData() {
//        if (currentUser.getEmpId() != null) {
//            currentEmployee = employeeDAO.getEmployeeById(currentUser.getEmpId());
//        }
//    }
//    
//    private void initializeComponents() {
//        setTitle("Employee Dashboard - Employee Management System");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(800, 600);
//        setLocationRelativeTo(null);
//        setLayout(new BorderLayout());
//        
//        // Header Panel
//        JPanel headerPanel = createHeaderPanel();
//        add(headerPanel, BorderLayout.NORTH);
//        
//        // Main Content Panel
//        JPanel mainPanel = createMainPanel();
//        add(mainPanel, BorderLayout.CENTER);
//        
//        // Button Panel
//        JPanel buttonPanel = createButtonPanel();
//        add(buttonPanel, BorderLayout.SOUTH);
//    }
//    
//    private JPanel createHeaderPanel() {
//        JPanel headerPanel = new JPanel(new BorderLayout());
//        headerPanel.setBackground(new Color(25, 118, 210));
//        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
//        
//        JLabel titleLabel = new JLabel("Employee Dashboard");
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
//        titleLabel.setForeground(Color.WHITE);
//        headerPanel.add(titleLabel, BorderLayout.WEST);
//        
//        JLabel userLabel = new JLabel("Welcome, " + currentUser.getUsername());
//        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
//        userLabel.setForeground(Color.WHITE);
//        headerPanel.add(userLabel, BorderLayout.EAST);
//        
//        return headerPanel;
//    }
//    
//    private JPanel createMainPanel() {
//        JPanel mainPanel = new JPanel(new GridBagLayout());
//        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
//        mainPanel.setBackground(new Color(248, 249, 250));
//        
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(10, 10, 10, 10);
//        gbc.anchor = GridBagConstraints.WEST;
//        
//        // Title
//        JLabel profileTitle = new JLabel("My Profile Information");
//        profileTitle.setFont(new Font("Arial", Font.BOLD, 18));
//        profileTitle.setForeground(new Color(25, 118, 210));
//        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
//        mainPanel.add(profileTitle, gbc);
//        
//        gbc.gridwidth = 1;
//        
//        if (currentEmployee != null) {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            
//            // Name
//            addLabelAndValue(mainPanel, gbc, 1, "Full Name:", currentEmployee.getFullName());
//            
//            // Email
//            addLabelAndValue(mainPanel, gbc, 2, "Email:", currentEmployee.getEmail());
//            
//            // Phone
//            addLabelAndValue(mainPanel, gbc, 3, "Phone:", currentEmployee.getPhone());
//            
//            // Address
//            addLabelAndValue(mainPanel, gbc, 4, "Address:", currentEmployee.getAddress());
//            
//            // Department
//            addLabelAndValue(mainPanel, gbc, 5, "Department:", currentEmployee.getDeptName());
//            
//            // Hire Date
//            addLabelAndValue(mainPanel, gbc, 6, "Hire Date:", dateFormat.format(currentEmployee.getHireDate()));
//            
//            // Salary
//            addLabelAndValue(mainPanel, gbc, 7, "Salary:", String.format("$%.2f", currentEmployee.getSalary()));
//            
//            // Status
//            addLabelAndValue(mainPanel, gbc, 8, "Status:", currentEmployee.getStatus());
//            
//        } else {
//            JLabel noDataLabel = new JLabel("No employee data found.");
//            noDataLabel.setFont(new Font("Arial", Font.ITALIC, 14));
//            gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
//            mainPanel.add(noDataLabel, gbc);
//        }
//        
//        return mainPanel;
//    }
//    
//    private void addLabelAndValue(JPanel panel, GridBagConstraints gbc, int row, String labelText, String value) {
//        gbc.gridx = 0; gbc.gridy = row;
//        JLabel label = new JLabel(labelText);
//        label.setFont(new Font("Arial", Font.BOLD, 14));
//        panel.add(label, gbc);
//        
//        gbc.gridx = 1; gbc.gridy = row;
//        JLabel valueLabel = new JLabel(value != null ? value : "N/A");
//        valueLabel.setFont(new Font("Arial", Font.PLAIN, 14));
//        panel.add(valueLabel, gbc);
//    }
//    
//    private JPanel createButtonPanel() {
//        JPanel buttonPanel = new JPanel(new FlowLayout());
//        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
//        
//        JButton refreshButton = new JButton("Refresh Profile");
//        refreshButton.setBackground(new Color(25, 118, 210));
//        refreshButton.setForeground(Color.WHITE);
//        refreshButton.addActionListener(e -> {
//            loadEmployeeData();
//            dispose();
//            new EmployeeDashboard(currentUser).setVisible(true);
//        });
//        buttonPanel.add(refreshButton);
//        
//        JButton logoutButton = new JButton("Logout");
//        logoutButton.setBackground(new Color(96, 125, 139));
//        logoutButton.setForeground(Color.WHITE);
//        logoutButton.addActionListener(e -> logout());
//        buttonPanel.add(logoutButton);
//        
//        return buttonPanel;
//    }
//    
//    private void logout() {
//        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", 
//            "Confirm Logout", JOptionPane.YES_NO_OPTION);
//        
//        if (confirm == JOptionPane.YES_OPTION) {
//            dispose();
//            new LoginFrame().setVisible(true);
//        }
//    }
//}
package com.ems.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import com.ems.db.EmployeeDAOImpl;
import com.ems.model.Employee;
import com.ems.model.User;

public class EmployeeDashboard extends JFrame {
    private User currentUser;
    private Employee currentEmployee;
    private EmployeeDAOImpl employeeDAO;
    private JLabel nameLabel, emailLabel, phoneLabel, addressLabel;
    private JLabel hireDateLabel, salaryLabel, departmentLabel, statusLabel;
    
    public EmployeeDashboard(User user) {
        this.currentUser = user;
        this.employeeDAO = new EmployeeDAOImpl();
        loadEmployeeData();
        initializeComponents();
    }
    
    private void loadEmployeeData() {
        if (currentUser.getEmpId() != null) {
            currentEmployee = employeeDAO.getEmployeeById(currentUser.getEmpId());
        }
    }
    
    private void initializeComponents() {
        setTitle("Employee Dashboard - Employee Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        // Header Panel
        JPanel headerPanel = createHeaderPanel();
        add(headerPanel, BorderLayout.NORTH);
        
        // Main Content Panel
        JPanel mainPanel = createMainPanel();
        add(mainPanel, BorderLayout.CENTER);
        
        // Button Panel
        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(25, 118, 210));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        JLabel titleLabel = new JLabel("Employee Dashboard");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel, BorderLayout.WEST);
        
        JLabel userLabel = new JLabel("Welcome, " + currentUser.getUsername());
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        userLabel.setForeground(Color.WHITE);
        headerPanel.add(userLabel, BorderLayout.EAST);
        
        return headerPanel;
    }
    
    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        mainPanel.setBackground(new Color(248, 249, 250));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Title
        JLabel profileTitle = new JLabel("My Profile Information");
        profileTitle.setFont(new Font("Arial", Font.BOLD, 18));
        profileTitle.setForeground(new Color(25, 118, 210));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        mainPanel.add(profileTitle, gbc);
        
        gbc.gridwidth = 1;
        
        if (currentEmployee != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            // Name
            addLabelAndValue(mainPanel, gbc, 1, "Full Name:", currentEmployee.getFullName());
            
            // Email
            addLabelAndValue(mainPanel, gbc, 2, "Email:", currentEmployee.getEmail());
            
            // Phone
            addLabelAndValue(mainPanel, gbc, 3, "Phone:", currentEmployee.getPhone());
            
            // Address
            addLabelAndValue(mainPanel, gbc, 4, "Address:", currentEmployee.getAddress());
            
            // Department
            addLabelAndValue(mainPanel, gbc, 5, "Department:", currentEmployee.getDeptName());
            
            // Hire Date
            addLabelAndValue(mainPanel, gbc, 6, "Hire Date:", dateFormat.format(currentEmployee.getHireDate()));
            
            // Salary
            addLabelAndValue(mainPanel, gbc, 7, "Salary:", String.format("$%.2f", currentEmployee.getSalary()));
            
            // Status
            addLabelAndValue(mainPanel, gbc, 8, "Status:", currentEmployee.getStatus());
            
        } else {
            JLabel noDataLabel = new JLabel("No employee data found.");
            noDataLabel.setFont(new Font("Arial", Font.ITALIC, 14));
            gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
            mainPanel.add(noDataLabel, gbc);
        }
        
        return mainPanel;
    }
    
    private void addLabelAndValue(JPanel panel, GridBagConstraints gbc, int row, String labelText, String value) {
        gbc.gridx = 0; gbc.gridy = row;
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(label, gbc);
        
        gbc.gridx = 1; gbc.gridy = row;
        JLabel valueLabel = new JLabel(value != null ? value : "N/A");
        valueLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(valueLabel, gbc);
    }
    
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        // NEW: Update Profile Button
        JButton updateProfileButton = new JButton("Update Profile");
        updateProfileButton.setBackground(new Color(76, 175, 80));
        updateProfileButton.setForeground(Color.WHITE);
        updateProfileButton.addActionListener(e -> openUpdateProfileDialog());
        buttonPanel.add(updateProfileButton);
        
        JButton refreshButton = new JButton("Refresh Profile");
        refreshButton.setBackground(new Color(25, 118, 210));
        refreshButton.setForeground(Color.WHITE);
        refreshButton.addActionListener(e -> {
            loadEmployeeData();
            dispose();
            new EmployeeDashboard(currentUser).setVisible(true);
        });
        buttonPanel.add(refreshButton);
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(new Color(96, 125, 139));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.addActionListener(e -> logout());
        buttonPanel.add(logoutButton);
        
        return buttonPanel;
    }
    
    // NEW METHOD: Open the update profile dialog
    private void openUpdateProfileDialog() {
        if (currentEmployee != null) {
            ProfileUpdateDialog dialog = new ProfileUpdateDialog(this, currentEmployee, employeeDAO);
            dialog.setVisible(true);
            
            // Refresh the dashboard after updating
            loadEmployeeData();
            dispose();
            new EmployeeDashboard(currentUser).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No employee data found to update.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", 
            "Confirm Logout", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            dispose();
            new LoginFrame().setVisible(true);
        }
    }
}