//package com.ems.db;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import com.ems.model.Employee;
//
//public class EmployeeDAOImpl implements EmployeeDAO {
//    private Connection connection;
//    
//    public EmployeeDAOImpl() {
//        this.connection = DatabaseConnection.getConnection();
//    }
//    
//    @Override
//    public boolean addEmployee(Employee employee) {
//        String sql = "INSERT INTO employees (first_name, last_name, email, phone, address, hire_date, salary, dept_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, employee.getFirstName());
//            stmt.setString(2, employee.getLastName());
//            stmt.setString(3, employee.getEmail());
//            stmt.setString(4, employee.getPhone());
//            stmt.setString(5, employee.getAddress());
//            stmt.setDate(6, new java.sql.Date(employee.getHireDate().getTime()));
//            stmt.setDouble(7, employee.getSalary());
//            stmt.setInt(8, employee.getDeptId());
//            
//            return stmt.executeUpdate() > 0;
//        } catch (SQLException e) {
//            System.err.println("Error adding employee: " + e.getMessage());
//            return false;
//        }
//    }
//    
//    @Override
//    public Employee getEmployeeById(int empId) {
//        String sql = "SELECT e.*, d.dept_name FROM employees e LEFT JOIN departments d ON e.dept_id = d.dept_id WHERE e.emp_id = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setInt(1, empId);
//            ResultSet rs = stmt.executeQuery();
//            
//            if (rs.next()) {
//                return mapResultSetToEmployee(rs);
//            }
//        } catch (SQLException e) {
//            System.err.println("Error getting employee by ID: " + e.getMessage());
//        }
//        return null;
//    }
//    
//    @Override
//    public Employee getEmployeeByEmail(String email) {
//        String sql = "SELECT e.*, d.dept_name FROM employees e LEFT JOIN departments d ON e.dept_id = d.dept_id WHERE e.email = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, email);
//            ResultSet rs = stmt.executeQuery();
//            
//            if (rs.next()) {
//                return mapResultSetToEmployee(rs);
//            }
//        } catch (SQLException e) {
//            System.err.println("Error getting employee by email: " + e.getMessage());
//        }
//        return null;
//    }
//    
//    @Override
//    public List<Employee> getAllEmployees() {
//        List<Employee> employees = new ArrayList<>();
//        String sql = "SELECT e.*, d.dept_name FROM employees e LEFT JOIN departments d ON e.dept_id = d.dept_id ORDER BY e.emp_id";
//        
//        try (Statement stmt = connection.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//            
//            while (rs.next()) {
//                employees.add(mapResultSetToEmployee(rs));
//            }
//        } catch (SQLException e) {
//            System.err.println("Error getting all employees: " + e.getMessage());
//        }
//        return employees;
//    }
//    
//    @Override
//    public boolean updateEmployee(Employee employee) {
//        String sql = "UPDATE employees SET first_name=?, last_name=?, email=?, phone=?, address=?, salary=?, dept_id=? WHERE emp_id=?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, employee.getFirstName());
//            stmt.setString(2, employee.getLastName());
//            stmt.setString(3, employee.getEmail());
//            stmt.setString(4, employee.getPhone());
//            stmt.setString(5, employee.getAddress());
//            stmt.setDouble(6, employee.getSalary());
//            stmt.setInt(7, employee.getDeptId());
//            stmt.setInt(8, employee.getEmpId());
//            
//            return stmt.executeUpdate() > 0;
//        } catch (SQLException e) {
//            System.err.println("Error updating employee: " + e.getMessage());
//            return false;
//        }
//    }
//    
//    @Override
//    public boolean deleteEmployee(int empId) {
//        String sql = "DELETE FROM employees WHERE emp_id = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setInt(1, empId);
//            return stmt.executeUpdate() > 0;
//        } catch (SQLException e) {
//            System.err.println("Error deleting employee: " + e.getMessage());
//            return false;
//        }
//    }
//    
//    @Override
//    public List<Employee> getEmployeesByDepartment(int deptId) {
//        List<Employee> employees = new ArrayList<>();
//        String sql = "SELECT e.*, d.dept_name FROM employees e LEFT JOIN departments d ON e.dept_id = d.dept_id WHERE e.dept_id = ?";
//        
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setInt(1, deptId);
//            ResultSet rs = stmt.executeQuery();
//            
//            while (rs.next()) {
//                employees.add(mapResultSetToEmployee(rs));
//            }
//        } catch (SQLException e) {
//            System.err.println("Error getting employees by department: " + e.getMessage());
//        }
//        return employees;
//    }
//    
//    private Employee mapResultSetToEmployee(ResultSet rs) throws SQLException {
//        Employee employee = new Employee();
//        employee.setEmpId(rs.getInt("emp_id"));
//        employee.setFirstName(rs.getString("first_name"));
//        employee.setLastName(rs.getString("last_name"));
//        employee.setEmail(rs.getString("email"));
//        employee.setPhone(rs.getString("phone"));
//        employee.setAddress(rs.getString("address"));
//        employee.setHireDate(rs.getDate("hire_date"));
//        employee.setSalary(rs.getDouble("salary"));
//        employee.setDeptId(rs.getInt("dept_id"));
//        employee.setStatus(rs.getString("status"));
//        employee.setDeptName(rs.getString("dept_name"));
//        return employee;
//    }
//}
package com.ems.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.ems.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;
    
    public EmployeeDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }
    
    @Override
    public boolean addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (first_name, last_name, email, phone, address, hire_date, salary, dept_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getPhone());
            stmt.setString(5, employee.getAddress());
            stmt.setDate(6, new java.sql.Date(employee.getHireDate().getTime()));
            stmt.setDouble(7, employee.getSalary());
            stmt.setInt(8, employee.getDeptId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error adding employee: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public Employee getEmployeeById(int empId) {
        String sql = "SELECT e.*, d.dept_name FROM employees e LEFT JOIN departments d ON e.dept_id = d.dept_id WHERE e.emp_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, empId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapResultSetToEmployee(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error getting employee by ID: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public Employee getEmployeeByEmail(String email) {
        String sql = "SELECT e.*, d.dept_name FROM employees e LEFT JOIN departments d ON e.dept_id = d.dept_id WHERE e.email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapResultSetToEmployee(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error getting employee by email: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT e.*, d.dept_name FROM employees e LEFT JOIN departments d ON e.dept_id = d.dept_id ORDER BY e.emp_id";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                employees.add(mapResultSetToEmployee(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error getting all employees: " + e.getMessage());
        }
        return employees;
    }
    
    @Override
    public boolean updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET first_name=?, last_name=?, email=?, phone=?, address=?, salary=?, dept_id=? WHERE emp_id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getPhone());
            stmt.setString(5, employee.getAddress());
            stmt.setDouble(6, employee.getSalary());
            stmt.setInt(7, employee.getDeptId());
            stmt.setInt(8, employee.getEmpId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updating employee: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean deleteEmployee(int empId) {
        String sql = "DELETE FROM employees WHERE emp_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, empId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting employee: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public List<Employee> getEmployeesByDepartment(int deptId) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT e.*, d.dept_name FROM employees e LEFT JOIN departments d ON e.dept_id = d.dept_id WHERE e.dept_id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, deptId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                employees.add(mapResultSetToEmployee(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error getting employees by department: " + e.getMessage());
        }
        return employees;
    }
    
    // NEW METHOD: Update profile (limited fields that employees can update themselves)
    @Override
    public boolean updateEmployeeProfile(Employee employee) {
        String sql = "UPDATE employees SET email=?, phone=?, address=? WHERE emp_id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, employee.getEmail());
            stmt.setString(2, employee.getPhone());
            stmt.setString(3, employee.getAddress());
            stmt.setInt(4, employee.getEmpId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updating employee profile: " + e.getMessage());
            return false;
        }
    }
    
    private Employee mapResultSetToEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setEmpId(rs.getInt("emp_id"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setEmail(rs.getString("email"));
        employee.setPhone(rs.getString("phone"));
        employee.setAddress(rs.getString("address"));
        employee.setHireDate(rs.getDate("hire_date"));
        employee.setSalary(rs.getDouble("salary"));
        employee.setDeptId(rs.getInt("dept_id"));
        employee.setStatus(rs.getString("status"));
        employee.setDeptName(rs.getString("dept_name"));
        return employee;
    }
}