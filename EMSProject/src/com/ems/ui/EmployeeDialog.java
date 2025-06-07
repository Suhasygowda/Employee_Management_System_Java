package com.ems.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.ems.db.EmployeeDAOImpl;
import com.ems.model.Employee;

public class EmployeeDialog extends JDialog {
    private Employee employee;
    private EmployeeDAOImpl employeeDAO;
    private AdminDashboard parentFrame;
    
    private JTextField firstNameField, lastNameField, emailField, phoneField;
    private JTextArea addressArea;
    private JTextField hireDateField, salaryField;
    private JComboBox<String> departmentCombo, statusCombo;
    private JButton saveButton, cancelButton;
    
    public EmployeeDialog(AdminDashboard parent, EmployeeDAOImpl dao, Employee emp) {
        super(parent, emp == null ? "Add Employee" : "Edit Employee", true);
        this.parentFrame = parent;
        this.employeeDAO = dao;
        this.employee = emp;
        
        initializeComponents();
        if (employee != null) {
            populateFields();
        }
    }
    
    private void initializeComponents() {
        setLayout(new BorderLayout());
        setSize(450, 500);
        setLocationRelativeTo(getParent());
        
        // Main panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // First Name
        addFormField(mainPanel, gbc, 0, "First Name:", firstNameField = new JTextField(20));
        
        // Last Name
        addFormField(mainPanel, gbc, 1, "Last Name:", lastNameField = new JTextField(20));
        
        // Email
        addFormField(mainPanel, gbc, 2, "Email:", emailField = new JTextField(20));
        
        // Phone
        addFormField(mainPanel, gbc, 3, "Phone:", phoneField = new JTextField(20));
        
        // Address
        gbc.gridx = 0; gbc.gridy = 4;
        mainPanel.add(new JLabel("Address:"), gbc);
        addressArea = new JTextArea(3, 20);
        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true);
        JScrollPane addressScroll = new JScrollPane(addressArea);
        gbc.gridx = 1; gbc.gridy = 4;
        mainPanel.add(addressScroll, gbc);
        
        // Hire Date
        addFormField(mainPanel, gbc, 5, "Hire Date (YYYY-MM-DD):", hireDateField = new JTextField(20));
        
        // Salary
        addFormField(mainPanel, gbc, 6, "Salary:", salaryField = new JTextField(20));
        
        // Department
        gbc.gridx = 0; gbc.gridy = 7;
        mainPanel.add(new JLabel("Department:"), gbc);
        String[] departments = {"IT", "HR", "Finance", "Marketing"};
        departmentCombo = new JComboBox<>(departments);
        gbc.gridx = 1; gbc.gridy = 7;
        mainPanel.add(departmentCombo, gbc);
        
        // Status
        gbc.gridx = 0; gbc.gridy = 8;
        mainPanel.add(new JLabel("Status:"), gbc);
        String[] statuses = {"Active", "Inactive"};
        statusCombo = new JComboBox<>(statuses);
        gbc.gridx = 1; gbc.gridy = 8;
        mainPanel.add(statusCombo, gbc);
        
        add(mainPanel, BorderLayout.CENTER);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        saveButton = new JButton(employee == null ? "Add Employee" : "Update Employee");
        saveButton.setBackground(new Color(76, 175, 80));
        saveButton.setForeground(Color.WHITE);
        saveButton.addActionListener(e -> saveEmployee());
        
        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(96, 125, 139));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(e -> dispose());
        
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void addFormField(JPanel panel, GridBagConstraints gbc, int row, String labelText, JTextField field) {
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel(labelText), gbc);
        gbc.gridx = 1; gbc.gridy = row;
        panel.add(field, gbc);
    }
    
    private void populateFields() {
        firstNameField.setText(employee.getFirstName());
        lastNameField.setText(employee.getLastName());
        emailField.setText(employee.getEmail());
        phoneField.setText(employee.getPhone());
        addressArea.setText(employee.getAddress());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        hireDateField.setText(dateFormat.format(employee.getHireDate()));
        
        salaryField.setText(String.valueOf(employee.getSalary()));
        statusCombo.setSelectedItem(employee.getStatus());
        
        // Set department based on deptId
        switch (employee.getDeptId()) {
            case 1: departmentCombo.setSelectedItem("HR"); break;
            case 2: departmentCombo.setSelectedItem("IT"); break;
            case 3: departmentCombo.setSelectedItem("Finance"); break;
            case 4: departmentCombo.setSelectedItem("Marketing"); break;
        }
    }
    
    private void saveEmployee() {
        try {
            // Validate fields
            if (!validateFields()) {
                return;
            }
            
            // Create or update employee object
            if (employee == null) {
                employee = new Employee();
            }
            
            employee.setFirstName(firstNameField.getText().trim());
            employee.setLastName(lastNameField.getText().trim());
            employee.setEmail(emailField.getText().trim());
            employee.setPhone(phoneField.getText().trim());
            employee.setAddress(addressArea.getText().trim());
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            employee.setHireDate(dateFormat.parse(hireDateField.getText().trim()));
            
            employee.setSalary(Double.parseDouble(salaryField.getText().trim()));
            employee.setStatus((String) statusCombo.getSelectedItem());
            
            // Set department ID based on selection
            String selectedDept = (String) departmentCombo.getSelectedItem();
            switch (selectedDept) {
                case "HR": employee.setDeptId(1); break;
                case "IT": employee.setDeptId(2); break;
                case "Finance": employee.setDeptId(3); break;
                case "Marketing": employee.setDeptId(4); break;
            }
            
            // Save to database
            boolean success;
            if (employee.getEmpId() == 0) {
                success = employeeDAO.addEmployee(employee);
            } else {
                success = employeeDAO.updateEmployee(employee);
            }
            
            if (success) {
                JOptionPane.showMessageDialog(this, 
                    employee.getEmpId() == 0 ? "Employee added successfully!" : "Employee updated successfully!", 
                    "Success", JOptionPane.INFORMATION_MESSAGE);
                parentFrame.refreshData();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Failed to save employee data.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, 
                "Invalid date format. Please use YYYY-MM-DD format.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Invalid salary format. Please enter a valid number.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validateFields() {
        if (firstNameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "First name is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (lastNameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Last name is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (emailField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (hireDateField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hire date is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (salaryField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Salary is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}