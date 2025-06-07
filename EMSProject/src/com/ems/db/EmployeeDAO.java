//package com.ems.db;
//
//import java.util.List;
//import com.ems.model.Employee;
//
//public interface EmployeeDAO {
//    boolean addEmployee(Employee employee);
//    Employee getEmployeeById(int empId);
//    Employee getEmployeeByEmail(String email);
//    List<Employee> getAllEmployees();
//    boolean updateEmployee(Employee employee);
//    boolean deleteEmployee(int empId);
//    List<Employee> getEmployeesByDepartment(int deptId);
//}
package com.ems.db;

import java.util.List;
import com.ems.model.Employee;

public interface EmployeeDAO {
    boolean addEmployee(Employee employee);
    Employee getEmployeeById(int empId);
    Employee getEmployeeByEmail(String email);
    List<Employee> getAllEmployees();
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(int empId);
    List<Employee> getEmployeesByDepartment(int deptId);
    
    // New method for profile updates (limited fields that employees can update)
    boolean updateEmployeeProfile(Employee employee);
}