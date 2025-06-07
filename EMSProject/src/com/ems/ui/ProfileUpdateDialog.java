package com.ems.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.ems.db.EmployeeDAOImpl;
import com.ems.model.Employee;

public class ProfileUpdateDialog extends JDialog {
    private Employee employee;
    private EmployeeDAOImpl employeeDAO;
    private JTextField emailField, phoneField, addressField;
    private boolean isUpdated = false;
    
    public ProfileUpdateDialog(JFrame parent, Employee employee, EmployeeDAOImpl employeeDAO) {
        super(parent, "Update Profile", true);
        this.employee = employee;
        this.employeeDAO = employeeDAO;
        initializeComponents();
    }
    
    private void initializeComponents() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(getParent());
        setLayout(new BorderLayout());
        
        // Header Panel
        JPanel headerPanel = createHeaderPanel();
        add(headerPanel, BorderLayout.NORTH);
        
        // Form Panel
        JPanel formPanel = createFormPanel();
        add(formPanel, BorderLayout.CENTER);
        
        // Button Panel
        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Populate fields with current data
        populateFields();
    }
    
    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(25, 118, 210));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        JLabel titleLabel = new JLabel("Update Your Profile");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);
        
        return headerPanel;
    }
    
    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(new Color(248, 249, 250));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Read-only fields (employee cannot change these)
        addReadOnlyField(formPanel, gbc, 0, "Employee ID:", String.valueOf(employee.getEmpId()));
        addReadOnlyField(formPanel, gbc, 1, "Full Name:", employee.getFullName());
        addReadOnlyField(formPanel, gbc, 2, "Department:", employee.getDeptName());
        
        // Editable fields
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 12));
        formPanel.add(emailLabel, gbc);
        
        gbc.gridx = 1; gbc.gridy = 3;
        emailField = new JTextField(20);
        emailField.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(emailField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 12));
        formPanel.add(phoneLabel, gbc);
        
        gbc.gridx = 1; gbc.gridy = 4;
        phoneField = new JTextField(20);
        phoneField.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(phoneField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 5;
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Arial", Font.BOLD, 12));
        formPanel.add(addressLabel, gbc);
        
        gbc.gridx = 1; gbc.gridy = 5;
        addressField = new JTextField(20);
        addressField.setFont(new Font("Arial", Font.PLAIN, 12));
        formPanel.add(addressField, gbc);
        
        return formPanel;
    }
    
    private void addReadOnlyField(JPanel panel, GridBagConstraints gbc, int row, String labelText, String value) {
        gbc.gridx = 0; gbc.gridy = row;
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(label, gbc);
        
        gbc.gridx = 1; gbc.gridy = row;
        JLabel valueLabel = new JLabel(value != null ? value : "N/A");
        valueLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        valueLabel.setForeground(Color.GRAY);
        panel.add(valueLabel, gbc);
    }
    
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        JButton updateButton = new JButton("Update");
        updateButton.setBackground(new Color(76, 175, 80));
        updateButton.setForeground(Color.WHITE);
        updateButton.setPreferredSize(new Dimension(100, 35));
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProfile();
            }
        });
        buttonPanel.add(updateButton);
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(96, 125, 139));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setPreferredSize(new Dimension(100, 35));
        cancelButton.addActionListener(e -> dispose());
        buttonPanel.add(cancelButton);
        
        return buttonPanel;
    }
    
    private void populateFields() {
        emailField.setText(employee.getEmail());
        phoneField.setText(employee.getPhone());
        addressField.setText(employee.getAddress());
    }
    
    private void updateProfile() {
        // Validate input
        if (!validateInput()) {
            return;
        }
        
        // Update employee object with new values
        employee.setEmail(emailField.getText().trim());
        employee.setPhone(phoneField.getText().trim());
        employee.setAddress(addressField.getText().trim());
        
        // Update in database
        if (employeeDAO.updateEmployeeProfile(employee)) {
            JOptionPane.showMessageDialog(this, 
                "Profile updated successfully!", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            isUpdated = true;
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, 
                "Failed to update profile. Please try again.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validateInput() {
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();
        String address = addressField.getText().trim();
        
        // Check if fields are empty
        if (email.isEmpty() || phone.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please fill in all fields.", 
                "Validation Error", 
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Basic email validation
        if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid email address.", 
                "Validation Error", 
                JOptionPane.WARNING_MESSAGE);
            emailField.requestFocus();
            return false;
        }
        
        // Basic phone validation (should contain only numbers, spaces, hyphens, and parentheses)
        if (!phone.matches("[\\d\\s\\-\\(\\)\\+]+")) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid phone number.", 
                "Validation Error", 
                JOptionPane.WARNING_MESSAGE);
            phoneField.requestFocus();
            return false;
        }
        
        return true;
    }
    
    public boolean isUpdated() {
        return isUpdated;
    }
}