package com.ems.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import com.ems.db.EmployeeDAOImpl;
import com.ems.model.Employee;
import com.ems.model.User;

public class AdminDashboard extends JFrame {
    private User currentUser;
    private EmployeeDAOImpl employeeDAO;
    private JTable employeeTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    
    public AdminDashboard(User user) {
        this.currentUser = user;
        this.employeeDAO = new EmployeeDAOImpl();
        initializeComponents();
        loadEmployeeData();
    }
    
    private void initializeComponents() {
        setTitle("Admin Dashboard - Employee Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        
        JLabel titleLabel = new JLabel("Employee Management System - Admin Dashboard");
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
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Search Panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Search:"));
        searchField = new JTextField(20);
        searchPanel.add(searchField);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchEmployees());
        searchPanel.add(searchButton);
        
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> loadEmployeeData());
        searchPanel.add(refreshButton);
        
        mainPanel.add(searchPanel, BorderLayout.NORTH);
        
        // Table Panel
        String[] columnNames = {"ID", "First Name", "Last Name", "Email", "Phone", 
                               "Department", "Salary", "Hire Date", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table read-only
            }
        };
        
        employeeTable = new JTable(tableModel);
        employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employeeTable.setFont(new Font("Arial", Font.PLAIN, 12));
        employeeTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        employeeTable.setRowHeight(25);
        
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        scrollPane.setPreferredSize(new Dimension(800, 400));
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        return mainPanel;
    }
    
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        JButton addButton = new JButton("Add Employee");
        addButton.setBackground(new Color(76, 175, 80));
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(e -> showAddEmployeeDialog());
        buttonPanel.add(addButton);
        
        JButton editButton = new JButton("Edit Employee");
        editButton.setBackground(new Color(255, 152, 0));
        editButton.setForeground(Color.WHITE);
        editButton.addActionListener(e -> showEditEmployeeDialog());
        buttonPanel.add(editButton);
        
        JButton deleteButton = new JButton("Delete Employee");
        deleteButton.setBackground(new Color(244, 67, 54));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.addActionListener(e -> deleteEmployee());
        buttonPanel.add(deleteButton);
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(new Color(96, 125, 139));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.addActionListener(e -> logout());
        buttonPanel.add(logoutButton);
        
        return buttonPanel;
    }
    
    private void loadEmployeeData() {
        tableModel.setRowCount(0); // Clear existing data
        List<Employee> employees = employeeDAO.getAllEmployees();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        for (Employee emp : employees) {
            Object[] rowData = {
                emp.getEmpId(),
                emp.getFirstName(),
                emp.getLastName(),
                emp.getEmail(),
                emp.getPhone(),
                emp.getDeptName(),
                String.format("$%.2f", emp.getSalary()),
                dateFormat.format(emp.getHireDate()),
                emp.getStatus()
            };
            tableModel.addRow(rowData);
        }
    }
    
    private void searchEmployees() {
        String searchTerm = searchField.getText().trim().toLowerCase();
        if (searchTerm.isEmpty()) {
            loadEmployeeData();
            return;
        }
        
        tableModel.setRowCount(0);
        List<Employee> employees = employeeDAO.getAllEmployees();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        for (Employee emp : employees) {
            if (emp.getFirstName().toLowerCase().contains(searchTerm) ||
                emp.getLastName().toLowerCase().contains(searchTerm) ||
                emp.getEmail().toLowerCase().contains(searchTerm) ||
                (emp.getDeptName() != null && emp.getDeptName().toLowerCase().contains(searchTerm))) {
                
                Object[] rowData = {
                    emp.getEmpId(),
                    emp.getFirstName(),
                    emp.getLastName(),
                    emp.getEmail(),
                    emp.getPhone(),
                    emp.getDeptName(),
                    String.format("$%.2f", emp.getSalary()),
                    dateFormat.format(emp.getHireDate()),
                    emp.getStatus()
                };
                tableModel.addRow(rowData);
            }
        }
    }
    
    private void showAddEmployeeDialog() {
        new EmployeeDialog(this, employeeDAO, null).setVisible(true);
    }
    
    private void showEditEmployeeDialog() {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an employee to edit.", 
                "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int empId = (Integer) tableModel.getValueAt(selectedRow, 0);
        Employee employee = employeeDAO.getEmployeeById(empId);
        if (employee != null) {
            new EmployeeDialog(this, employeeDAO, employee).setVisible(true);
        }
    }
    
    private void deleteEmployee() {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an employee to delete.", 
                "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int empId = (Integer) tableModel.getValueAt(selectedRow, 0);
        String empName = tableModel.getValueAt(selectedRow, 1) + " " + tableModel.getValueAt(selectedRow, 2);
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete employee: " + empName + "?", 
            "Confirm Delete", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            if (employeeDAO.deleteEmployee(empId)) {
                JOptionPane.showMessageDialog(this, "Employee deleted successfully!", 
                    "Success", JOptionPane.INFORMATION_MESSAGE);
                loadEmployeeData();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete employee.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
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
    
    public void refreshData() {
        loadEmployeeData();
    }
}