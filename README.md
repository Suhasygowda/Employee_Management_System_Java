# 🏢 Employee Management System (EMS)

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge&logo=java)

**A comprehensive Employee Management System built with Java Swing, JDBC, and MySQL**  
*Desktop application providing complete solution for managing employee data with role-based access control*

---

[![⭐ Star this repo](https://img.shields.io/github/stars/Suhasygowda/Employee_Management_System_Java?style=social)](https://github.com/Suhasygowda/Employee_Management_System_Java)
[![🍴 Fork this repo](https://img.shields.io/github/forks/Suhasygowda/Employee_Management_System_Java?style=social)](https://github.com/Suhasygowda/Employee_Management_System_Java/fork)

</div>

---

## 🚀 **Features**

<details open>
<summary><b>🔧 Admin Features</b></summary>

> 💼 **Employee Management**: Add, edit, delete, and view all employees  
> 🔍 **Advanced Search**: Search employees by name, ID, department, or position  
> 🏢 **Department Management**: Organize employees by departments  
> 📊 **Data Export**: Export employee data to various formats  
> 👥 **User Management**: Manage system users and access levels

</details>

<details open>
<summary><b>👤 Employee Features</b></summary>

> 📋 **Personal Dashboard**: View personal information and profile  
> ✏️ **Profile Updates**: Update personal details (with admin approval)  
> 📅 **Attendance Tracking**: View attendance records  
> 🏖️ **Leave Management**: Request and track leave applications

</details>

<details open>
<summary><b>⚙️ System Features</b></summary>

> 🔐 **Secure Authentication**: Role-based login system  
> ✅ **Data Validation**: Comprehensive input validation and error handling  
> 📱 **Responsive UI**: Clean and intuitive Swing-based interface  
> 🗄️ **Database Integration**: Robust MySQL database connectivity

</details>

---

## 🛠️ **Technology Stack**

<div align="center">

| Component | Technology |
|-----------|------------|
| **Programming Language** | ![Java](https://img.shields.io/badge/Java-8+-orange?style=flat-square&logo=java) |
| **GUI Framework** | ![Swing](https://img.shields.io/badge/Java-Swing-blue?style=flat-square) |
| **Database** | ![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue?style=flat-square&logo=mysql&logoColor=white) |
| **Database Connectivity** | ![JDBC](https://img.shields.io/badge/JDBC-Connection-green?style=flat-square) |
| **Build Tool** | ![Maven](https://img.shields.io/badge/Maven/Gradle-Optional-yellow?style=flat-square) |
| **IDE** | ![IDE](https://img.shields.io/badge/Eclipse/IntelliJ-IDEA-purple?style=flat-square) |

</div>

---

## 📁 **Project Structure**

```
📦 EMSProject/
├── 📂 src/
│   ├── 📂 com.ems.db/
│   │   ├── 🔗 DatabaseConnection.java    # Database connection management
│   │   ├── 👥 EmployeeDAO.java          # Employee data access operations
│   │   └── 🔐 UserDAO.java              # User authentication operations
│   ├── 📂 com.ems.model/
│   │   ├── 👤 Employee.java             # Employee model class
│   │   ├── 🔑 User.java                 # User model class
│   │   └── 🏢 Department.java           # Department model class
│   ├── 📂 com.ems.ui/
│   │   ├── 🔓 LoginFrame.java           # Login interface
│   │   ├── 🔧 AdminDashboard.java       # Admin control panel
│   │   └── 👤 EmployeeDashboard.java    # Employee interface
│   └── 📂 com.ems.main/
│       └── ▶️ EMSApplication.java       # Main application entry point
├── 📂 lib/
│   └── 🔌 mysql-connector-java-8.0.33.jar
├── 📂 database/
│   └── 🗄️ ems_schema.sql               # Database schema file
└── 📄 README.md
```

---

## 🔧 **Installation & Setup**

### ✅ **Prerequisites**

<div align="center">

| Requirement | Version | Status |
|-------------|---------|--------|
| Java Development Kit (JDK) | 8 or higher | ✅ |
| MySQL Server | 8.0 or higher | ✅ |
| IDE | Eclipse/IntelliJ/VS Code | ✅ |

</div>

---

### 🗄️ **Database Setup**

<details>
<summary><b>Step 1: Install MySQL and start the service</b></summary>

Make sure MySQL is running on your system.

</details>

<details>
<summary><b>Step 2: Create Database</b></summary>

```sql
CREATE DATABASE employee_management_system;
USE employee_management_system;
```

</details>

<details>
<summary><b>Step 3: Create Tables</b></summary>

```sql
-- 🔐 Users table for authentication
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'EMPLOYEE') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 🏢 Departments table
CREATE TABLE departments (
    dept_id INT PRIMARY KEY AUTO_INCREMENT,
    dept_name VARCHAR(100) NOT NULL,
    dept_head VARCHAR(100),
    description TEXT
);

-- 👥 Employees table
CREATE TABLE employees (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15),
    address TEXT,
    position VARCHAR(100),
    department_id INT,
    salary DECIMAL(10,2),
    hire_date DATE,
    status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE',
    user_id INT,
    FOREIGN KEY (department_id) REFERENCES departments(dept_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
```

</details>

<details>
<summary><b>Step 4: Insert Sample Data</b></summary>

```sql
-- 🏢 Insert departments
INSERT INTO departments (dept_name, dept_head, description) VALUES
('Human Resources', 'John Smith', 'Manages employee relations and policies'),
('Information Technology', 'Sarah Johnson', 'Handles all technical operations'),
('Finance', 'Michael Brown', 'Manages financial operations and accounting');

-- 🔐 Insert admin user
INSERT INTO users (username, password, role) VALUES
('admin', 'admin123', 'ADMIN');
```

</details>

---

### 🚀 **Project Setup**

<div align="center">

### **Step-by-Step Guide**

</div>

**1️⃣ Clone the Repository**
```bash
https://github.com/Suhasygowda/Employee_Management_System_Java.git
cd EMSProject
```

**2️⃣ Import Project**
- Open your IDE (Eclipse/IntelliJ)
- Import the project as a Java project
- Ensure JDK 8+ is configured

**3️⃣ Add MySQL Connector**
- Add `mysql-connector-java-8.0.33.jar` to your project classpath
- In Eclipse: Right-click project → Properties → Java Build Path → Libraries → Add JARs

**4️⃣ Configure Database Connection**  
Update `DatabaseConnection.java` with your MySQL credentials:
```java
private static final String URL = "jdbc:mysql://localhost:3306/employee_management_system";
private static final String USERNAME = "your_mysql_username";
private static final String PASSWORD = "your_mysql_password";
```

**5️⃣ Run the Application**
- Execute `EMSApplication.java`
- Login with default credentials: `admin` / `admin123`

---

## 🎯 **Usage**

<div align="center">

### **🔐 Default Login Credentials**

| Role | Username | Password |
|------|----------|----------|
| **Admin** | `admin` | `admin123` |

</div>

---

### **👨‍💼 Admin Functions**

<div align="center">

| Function | Description | Action |
|----------|-------------|--------|
| **👀 View Employees** | Browse all employee records | Table format display |
| **➕ Add Employee** | Create new employee records | Click "Add Employee" |
| **✏️ Edit Employee** | Modify employee details | Select & click "Edit" |
| **🗑️ Delete Employee** | Remove employee records | Select & click "Delete" |
| **🔍 Search** | Find specific employees | Use search bar |

</div>

---

### **👤 Employee Functions**

> **📋 View Profile**: See personal information and employment details  
> **✏️ Update Profile**: Request profile updates (requires admin approval)

---

## 🔐 **Security Features**

<div align="center">

| Security Layer | Implementation |
|----------------|----------------|
| **🔒 Password Encryption** | User passwords are securely hashed |
| **🎭 Role-Based Access** | Different interfaces for Admin and Employee roles |
| **✅ Input Validation** | Comprehensive data validation to prevent SQL injection |
| **🔐 Session Management** | Secure user session handling |

</div>

---

## 🐛 **Troubleshooting**

<details>
<summary><b>❌ Database Connection Failed</b></summary>

- ✅ Verify MySQL service is running
- ✅ Check database credentials in `DatabaseConnection.java`
- ✅ Ensure database and tables are created

</details>

<details>
<summary><b>❌ ClassNotFoundException for MySQL Driver</b></summary>

- ✅ Verify `mysql-connector-java-8.0.33.jar` is in classpath
- ✅ Refresh project in IDE

</details>

<details>
<summary><b>❌ Login Issues</b></summary>

- ✅ Verify admin user exists in database
- ✅ Check username/password spelling

</details>

---

## 🤝 **Contributing**

<div align="center">

**We welcome contributions! Here's how you can help:**

</div>

1. **🍴 Fork** the repository
2. **🌿 Create** a feature branch (`git checkout -b feature/AmazingFeature`)
3. **💾 Commit** your changes (`git commit -m 'Add some AmazingFeature'`)
4. **🚀 Push** to the branch (`git push origin feature/AmazingFeature`)
5. **📥 Open** a Pull Request

---

## 🙋‍♂️ **Support**

<div align="center">

**Need help? We're here for you!**

If you encounter any issues or have questions:
- **📝 Create an issue** on GitHub
- **📧 Contact**: [ssuhasygowda@gmail.com]

</div>

---

## 🔮 **Future Enhancements**

<div align="center">

### **🛣️ Roadmap**

</div>

- [ ] **🌐 Web-based interface** using Spring Boot
- [ ] **🔌 REST API** development  
- [ ] **📊 Advanced reporting** features
- [ ] **📅 Employee attendance** tracking
- [ ] **💰 Payroll management** integration
- [ ] **📄 Document management** system
- [ ] **📱 Mobile application** support

---

## 📊 **Screenshots**

<div align="center">

### **🔓 Login Screen**
![Login Screen](screenshots/login.png)

### **🔧 Admin Dashboard**
![Admin Dashboard](screenshots/admin-dashboard.png)

### **👥 Employee Management**
![Employee Management](screenshots/employee-management.png)

</div>

---

<div align="center">

**Made with ❤️ by [Suhasygowda](https://github.com/Suhasygowda)**

*⭐ Star this repository if you found it helpful! ⭐*

---

[![GitHub followers](https://img.shields.io/github/followers/Suhasygowda?style=social)](https://github.com/Suhasygowda)
[![GitHub stars](https://img.shields.io/github/stars/Suhasygowda/Employee_Management_System_Java?style=social)](https://github.com/Suhasygowda/Employee_Management_System_Java)

**🚀 Thank you for visiting! Happy coding! 🚀**

</div>
