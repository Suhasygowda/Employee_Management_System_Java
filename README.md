<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Management System (EMS)</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            line-height: 1.6;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            color: #333;
            overflow-x: hidden;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
            background: rgba(255, 255, 255, 0.95);
            backdrop-filter: blur(10px);
            border-radius: 20px;
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
            margin-bottom: 20px;
            animation: slideInUp 1s ease-out;
        }

        @keyframes slideInUp {
            from {
                opacity: 0;
                transform: translateY(50px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        h1 {
            text-align: center;
            font-size: 3rem;
            background: linear-gradient(45deg, #667eea, #764ba2);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            background-clip: text;
            margin-bottom: 30px;
            animation: glow 2s ease-in-out infinite alternate;
            position: relative;
        }

        h1::after {
            content: '';
            position: absolute;
            bottom: -10px;
            left: 50%;
            transform: translateX(-50%);
            width: 100px;
            height: 4px;
            background: linear-gradient(45deg, #667eea, #764ba2);
            border-radius: 2px;
            animation: expandLine 1.5s ease-out;
        }

        @keyframes glow {
            from {
                text-shadow: 0 0 20px rgba(102, 126, 234, 0.5);
            }
            to {
                text-shadow: 0 0 30px rgba(118, 75, 162, 0.8);
            }
        }

        @keyframes expandLine {
            from {
                width: 0;
            }
            to {
                width: 100px;
            }
        }

        .subtitle {
            text-align: center;
            font-size: 1.2rem;
            color: #666;
            margin-bottom: 40px;
            animation: fadeInDelay 1.5s ease-out;
        }

        @keyframes fadeInDelay {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        h2 {
            color: #333;
            border-left: 5px solid #667eea;
            padding-left: 15px;
            margin: 30px 0 20px 0;
            font-size: 1.8rem;
            animation: slideInLeft 0.8s ease-out;
            position: relative;
            overflow: hidden;
        }

        h2::before {
            content: '';
            position: absolute;
            top: 0;
            left: -100%;
            width: 100%;
            height: 100%;
            background: linear-gradient(90deg, transparent, rgba(102, 126, 234, 0.1), transparent);
            animation: shimmer 2s infinite;
        }

        @keyframes slideInLeft {
            from {
                opacity: 0;
                transform: translateX(-30px);
            }
            to {
                opacity: 1;
                transform: translateX(0);
            }
        }

        @keyframes shimmer {
            0% {
                left: -100%;
            }
            100% {
                left: 100%;
            }
        }

        h3 {
            color: #764ba2;
            margin: 20px 0 10px 0;
            font-size: 1.3rem;
            animation: bounceIn 1s ease-out;
        }

        @keyframes bounceIn {
            0% {
                opacity: 0;
                transform: scale(0.3);
            }
            50% {
                opacity: 1;
                transform: scale(1.05);
            }
            70% {
                transform: scale(0.9);
            }
            100% {
                opacity: 1;
                transform: scale(1);
            }
        }

        .features-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 20px;
            margin: 30px 0;
        }

        .feature-card {
            background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);
            padding: 25px;
            border-radius: 15px;
            color: white;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
            transition: all 0.3s ease;
            animation: cardSlideIn 1s ease-out;
            position: relative;
            overflow: hidden;
        }

        .feature-card::before {
            content: '';
            position: absolute;
            top: -50%;
            left: -50%;
            width: 200%;
            height: 200%;
            background: radial-gradient(circle, rgba(255, 255, 255, 0.1) 0%, transparent 70%);
            transform: rotate(45deg);
            transition: all 0.6s ease;
            opacity: 0;
        }

        .feature-card:hover::before {
            opacity: 1;
            transform: rotate(45deg) translate(50px, 50px);
        }

        .feature-card:hover {
            transform: translateY(-10px) scale(1.02);
            box-shadow: 0 20px 50px rgba(0, 0, 0, 0.3);
        }

        @keyframes cardSlideIn {
            from {
                opacity: 0;
                transform: translateY(30px) rotateX(20deg);
            }
            to {
                opacity: 1;
                transform: translateY(0) rotateX(0);
            }
        }

        .tech-stack {
            display: flex;
            flex-wrap: wrap;
            gap: 15px;
            margin: 20px 0;
        }

        .tech-item {
            background: linear-gradient(45deg, #667eea, #764ba2);
            color: white;
            padding: 12px 20px;
            border-radius: 25px;
            font-weight: bold;
            box-shadow: 0 5px 15px rgba(102, 126, 234, 0.3);
            transition: all 0.3s ease;
            animation: techFloat 2s ease-in-out infinite;
            position: relative;
        }

        .tech-item:nth-child(odd) {
            animation-delay: 0.5s;
        }

        .tech-item:nth-child(even) {
            animation-delay: 1s;
        }

        .tech-item:hover {
            transform: translateY(-5px) scale(1.1);
            box-shadow: 0 10px 25px rgba(102, 126, 234, 0.5);
        }

        @keyframes techFloat {
            0%, 100% {
                transform: translateY(0);
            }
            50% {
                transform: translateY(-5px);
            }
        }

        .code-block {
            background: #1e1e1e;
            color: #f8f8f2;
            padding: 20px;
            border-radius: 10px;
            margin: 20px 0;
            overflow-x: auto;
            position: relative;
            animation: codeAppear 1.2s ease-out;
        }

        .code-block::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            height: 3px;
            background: linear-gradient(90deg, #667eea, #764ba2, #667eea);
            background-size: 200% 100%;
            animation: codeProgress 3s linear infinite;
        }

        @keyframes codeAppear {
            from {
                opacity: 0;
                transform: translateX(-20px);
            }
            to {
                opacity: 1;
                transform: translateX(0);
            }
        }

        @keyframes codeProgress {
            0% {
                background-position: 200% 0;
            }
            100% {
                background-position: -200% 0;
            }
        }

        .installation-steps {
            counter-reset: step-counter;
        }

        .step {
            counter-increment: step-counter;
            padding: 20px;
            margin: 15px 0;
            background: linear-gradient(135deg, rgba(102, 126, 234, 0.1), rgba(118, 75, 162, 0.1));
            border-radius: 10px;
            border-left: 5px solid #667eea;
            position: relative;
            animation: stepSlide 0.8s ease-out;
            transition: all 0.3s ease;
        }

        .step::before {
            content: counter(step-counter);
            position: absolute;
            left: -15px;
            top: 50%;
            transform: translateY(-50%);
            background: linear-gradient(45deg, #667eea, #764ba2);
            color: white;
            width: 30px;
            height: 30px;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            font-weight: bold;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
            animation: pulse 2s infinite;
        }

        .step:hover {
            background: linear-gradient(135deg, rgba(102, 126, 234, 0.2), rgba(118, 75, 162, 0.2));
            transform: translateX(10px);
        }

        @keyframes stepSlide {
            from {
                opacity: 0;
                transform: translateX(-30px);
            }
            to {
                opacity: 1;
                transform: translateX(0);
            }
        }

        @keyframes pulse {
            0%, 100% {
                transform: translateY(-50%) scale(1);
            }
            50% {
                transform: translateY(-50%) scale(1.1);
            }
        }

        .security-badge {
            display: inline-block;
            background: linear-gradient(45deg, #28a745, #20c997);
            color: white;
            padding: 8px 15px;
            border-radius: 20px;
            font-size: 0.9rem;
            margin: 5px;
            animation: securityGlow 2s ease-in-out infinite alternate;
            box-shadow: 0 5px 15px rgba(40, 167, 69, 0.3);
        }

        @keyframes securityGlow {
            from {
                box-shadow: 0 5px 15px rgba(40, 167, 69, 0.3);
            }
            to {
                box-shadow: 0 8px 25px rgba(40, 167, 69, 0.6);
            }
        }

        .future-enhancement {
            background: linear-gradient(135deg, #ffecd2 0%, #fcb69f 100%);
            padding: 15px;
            border-radius: 10px;
            margin: 10px 0;
            border-left: 4px solid #ff6b6b;
            animation: enhancementFade 1s ease-out;
            transition: all 0.3s ease;
            position: relative;
            overflow: hidden;
        }

        .future-enhancement::before {
            content: '🚀';
            position: absolute;
            right: 15px;
            top: 50%;
            transform: translateY(-50%);
            font-size: 1.5rem;
            animation: rocket 2s ease-in-out infinite;
        }

        .future-enhancement:hover {
            transform: translateX(10px);
            box-shadow: 0 10px 30px rgba(255, 107, 107, 0.3);
        }

        @keyframes enhancementFade {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes rocket {
            0%, 100% {
                transform: translateY(-50%) translateX(0);
            }
            50% {
                transform: translateY(-50%) translateX(5px);
            }
        }

        .footer {
            text-align: center;
            margin-top: 50px;
            padding: 30px;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border-radius: 15px;
            animation: footerSlide 1.5s ease-out;
            position: relative;
            overflow: hidden;
        }

        .footer::before {
            content: '';
            position: absolute;
            top: 0;
            left: -100%;
            width: 100%;
            height: 100%;
            background: linear-gradient(90deg, transparent, rgba(255, 255, 255, 0.1), transparent);
            animation: footerShine 3s infinite;
        }

        @keyframes footerSlide {
            from {
                opacity: 0;
                transform: translateY(30px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes footerShine {
            0% {
                left: -100%;
            }
            100% {
                left: 100%;
            }
        }

        .star-animation {
            display: inline-block;
            animation: starTwinkle 1.5s ease-in-out infinite;
            font-size: 1.2rem;
        }

        @keyframes starTwinkle {
            0%, 100% {
                transform: scale(1) rotate(0deg);
                opacity: 1;
            }
            50% {
                transform: scale(1.2) rotate(180deg);
                opacity: 0.7;
            }
        }

        .emoji-float {
            display: inline-block;
            animation: emojiFloat 3s ease-in-out infinite;
        }

        @keyframes emojiFloat {
            0%, 100% {
                transform: translateY(0) rotate(0deg);
            }
            25% {
                transform: translateY(-3px) rotate(5deg);
            }
            75% {
                transform: translateY(3px) rotate(-5deg);
            }
        }

        /* Parallax scrolling effect */
        .parallax-bg {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            z-index: -1;
            animation: parallaxMove 20s linear infinite;
        }

        @keyframes parallaxMove {
            0% {
                background-position: 0% 50%;
            }
            50% {
                background-position: 100% 50%;
            }
            100% {
                background-position: 0% 50%;
            }
        }

        /* Responsive design */
        @media (max-width: 768px) {
            .container {
                margin: 10px;
                padding: 15px;
            }
            
            h1 {
                font-size: 2rem;
            }
            
            .features-grid {
                grid-template-columns: 1fr;
            }
            
            .tech-stack {
                justify-content: center;
            }
        }
    </style>
</head>
<body>
    <div class="parallax-bg"></div>
    
    <div class="container">
        <h1>Employee Management System (EMS)</h1>
        <p class="subtitle">A comprehensive Employee Management System built with Java Swing, JDBC, and MySQL. This desktop application provides a complete solution for managing employee data with role-based access control.</p>

        <h2><span class="emoji-float">🚀</span> Features</h2>
        
        <div class="features-grid">
            <div class="feature-card">
                <h3>Admin Features</h3>
                <ul>
                    <li><strong>Employee Management</strong>: Add, edit, delete, and view all employees</li>
                    <li><strong>Advanced Search</strong>: Search employees by name, ID, department, or position</li>
                    <li><strong>Department Management</strong>: Organize employees by departments</li>
                    <li><strong>Data Export</strong>: Export employee data to various formats</li>
                    <li><strong>User Management</strong>: Manage system users and access levels</li>
                </ul>
            </div>
            
            <div class="feature-card">
                <h3>Employee Features</h3>
                <ul>
                    <li><strong>Personal Dashboard</strong>: View personal information and profile</li>
                    <li><strong>Profile Updates</strong>: Update personal details (with admin approval)</li>
                    <li><strong>Attendance Tracking</strong>: View attendance records</li>
                    <li><strong>Leave Management</strong>: Request and track leave applications</li>
                </ul>
            </div>
            
            <div class="feature-card">
                <h3>System Features</h3>
                <ul>
                    <li><strong>Secure Authentication</strong>: Role-based login system</li>
                    <li><strong>Data Validation</strong>: Comprehensive input validation and error handling</li>
                    <li><strong>Responsive UI</strong>: Clean and intuitive Swing-based interface</li>
                    <li><strong>Database Integration</strong>: Robust MySQL database connectivity</li>
                </ul>
            </div>
        </div>

        <h2><span class="emoji-float">🛠️</span> Technology Stack</h2>
        <div class="tech-stack">
            <div class="tech-item">Java 8+</div>
            <div class="tech-item">Java Swing</div>
            <div class="tech-item">MySQL 8.0+</div>
            <div class="tech-item">JDBC</div>
            <div class="tech-item">Maven/Gradle</div>
            <div class="tech-item">Eclipse/IntelliJ IDEA</div>
        </div>

        <h2><span class="emoji-float">📁</span> Project Structure</h2>
        <div class="code-block">
<pre>EMSProject/
├── src/
│   ├── com.ems.db/
│   │   ├── DatabaseConnection.java    # Database connection management
│   │   ├── EmployeeDAO.java          # Employee data access operations
│   │   └── UserDAO.java              # User authentication operations
│   ├── com.ems.model/
│   │   ├── Employee.java             # Employee model class
│   │   ├── User.java                 # User model class
│   │   └── Department.java           # Department model class
│   ├── com.ems.ui/
│   │   ├── LoginFrame.java           # Login interface
│   │   ├── AdminDashboard.java       # Admin control panel
│   │   └── EmployeeDashboard.java    # Employee interface
│   └── com.ems.main/
│       └── EMSApplication.java       # Main application entry point
├── lib/
│   └── mysql-connector-java-8.0.33.jar
├── database/
│   └── ems_schema.sql               # Database schema file
└── README.md</pre>
        </div>

        <h2><span class="emoji-float">🔧</span> Installation & Setup</h2>
        
        <h3>Prerequisites</h3>
        <div class="tech-stack">
            <div class="tech-item">Java Development Kit (JDK) 8 or higher</div>
            <div class="tech-item">MySQL Server 8.0 or higher</div>
            <div class="tech-item">IDE (Eclipse, IntelliJ IDEA, or VS Code)</div>
        </div>

        <h3>Database Setup</h3>
        <div class="installation-steps">
            <div class="step">
                <strong>Install MySQL</strong> and start the MySQL service
            </div>
            
            <div class="step">
                <strong>Create Database</strong>:
                <div class="code-block">
<pre>CREATE DATABASE employee_management_system;
USE employee_management_system;</pre>
                </div>
            </div>
            
            <div class="step">
                <strong>Create Tables</strong>:
                <div class="code-block">
<pre>-- Users table for authentication
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'EMPLOYEE') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Departments table
CREATE TABLE departments (
    dept_id INT PRIMARY KEY AUTO_INCREMENT,
    dept_name VARCHAR(100) NOT NULL,
    dept_head VARCHAR(100),
    description TEXT
);

-- Employees table
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
);</pre>
                </div>
            </div>
            
            <div class="step">
                <strong>Insert Sample Data</strong>:
                <div class="code-block">
<pre>-- Insert departments
INSERT INTO departments (dept_name, dept_head, description) VALUES
('Human Resources', 'John Smith', 'Manages employee relations and policies'),
('Information Technology', 'Sarah Johnson', 'Handles all technical operations'),
('Finance', 'Michael Brown', 'Manages financial operations and accounting');

-- Insert admin user
INSERT INTO users (username, password, role) VALUES
('admin', 'admin123', 'ADMIN');</pre>
                </div>
            </div>
        </div>

        <h3>Project Setup</h3>
        <div class="installation-steps">
            <div class="step">
                <strong>Clone the Repository</strong>:
                <div class="code-block">
<pre>https://github.com/Suhasygowda/Employee_Management_System_Java.git
cd EMSProject</pre>
                </div>
            </div>
            
            <div class="step">
                <strong>Import Project</strong>:
                <ul>
                    <li>Open your IDE (Eclipse/IntelliJ)</li>
                    <li>Import the project as a Java project</li>
                    <li>Ensure JDK 8+ is configured</li>
                </ul>
            </div>
            
            <div class="step">
                <strong>Add MySQL Connector</strong>:
                <ul>
                    <li>Add <code>mysql-connector-java-8.0.33.jar</code> to your project classpath</li>
                    <li>In Eclipse: Right-click project → Properties → Java Build Path → Libraries → Add JARs</li>
                </ul>
            </div>
            
            <div class="step">
                <strong>Configure Database Connection</strong>:
                Update <code>DatabaseConnection.java</code> with your MySQL credentials:
                <div class="code-block">
<pre>private static final String URL = "jdbc:mysql://localhost:3306/employee_management_system";
private static final String USERNAME = "your_mysql_username";
private static final String PASSWORD = "your_mysql_password";</pre>
                </div>
            </div>
            
            <div class="step">
                <strong>Run the Application</strong>:
                <ul>
                    <li>Execute <code>EMSApplication.java</code></li>
                    <li>Login with default credentials: <code>admin</code> / <code>admin123</code></li>
                </ul>
            </div>
        </div>

        <h2><span class="emoji-float">🎯</span> Usage</h2>
        
        <h3>Admin Login</h3>
        <div class="tech-stack">
            <div class="tech-item">Username: admin</div>
            <div class="tech-item">Password: admin123</div>
        </div>

        <h3>Admin Functions</h3>
        <div class="installation-steps">
            <div class="step"><strong>View Employees</strong>: Browse all employee records in a table format</div>
            <div class="step"><strong>Add Employee</strong>: Click "Add Employee" to create new employee records</div>
            <div class="step"><strong>Edit Employee</strong>: Select an employee and click "Edit" to modify details</div>
            <div class="step"><strong>Delete Employee</strong>: Select an employee and click "Delete" to remove records</div>
            <div class="step"><strong>Search</strong>: Use the search bar to find specific employees</div>
        </div>

        <h3>Employee Functions</h3>
        <div class="installation-steps">
            <div class="step"><strong>View Profile</strong>: See personal information and employment details</div>
            <div class="step"><strong>Update Profile</strong>: Request profile updates (requires admin approval)</div>
        </div>

        <h2><span class="emoji-float">🔐</span> Security Features</h2>
        <div class="security-badge">Password Encryption</div>
        <div class="security-badge">Role-Based Access</div>
        <div class="security-badge">Input Validation</div>
        <div class="security-badge">Session Management</div>

        <h2><span class="emoji-float">🐛</span> Troubleshooting</h2>
        
        <h3>Common Issues</h3>
        <div class="installation-steps">
            <div class="step">
                <strong>Database Connection Failed</strong>:
                <ul>
                    <li>Verify MySQL service is running</li>
                    <li>Check database credentials in <code>DatabaseConnection.java</code></li>
                    <li>Ensure database and tables are created</li>
                </ul>
            </div>
            
            <div class="step">
                <strong>ClassNotFoundException for MySQL Driver</strong>:
                <ul>
                    <li>Verify <code>mysql-connector-java-8.0.33.jar</code> is in classpath</li>
                    <li>Refresh project in IDE</li>
                </ul>
            </div>
            
            <div class="step">
                <strong>Login Issues</strong>:
                <ul>
                    <li>Verify admin user exists in database</li>
                    <li>Check username/password spelling</li>
                </ul>
            </div>
        </div>

        <h2><span class="emoji-float">🤝</span> Contributing</h2>
        <div class="installation-steps">
            <div class="step">Fork the repository</div>
            <div class="step">Create a feature branch (<code>git checkout -b feature/AmazingFeature</code>)</div>
            <div class="step">Commit your changes (<code>git commit -m 'Add some AmazingFeature'</code>)</div>
            <div class="step">Push to the branch (<code>git push origin feature/AmazingFeature</code>)</div>
            <div class="step">Open a Pull Request</div>
        </div>

        <h2><span class="emoji-float">🙋‍♂️</span> Support</h2>
        <p>If you encounter any issues or have questions:</p>
        <ul>
            <li>Create an issue on GitHub</li>
            <li>Contact: ssuhasygowda@gmail.com</li>
        </ul>

        <h2><span class="emoji-float">🔮</span> Future Enhancements</h2>
        <div class="future-enhancement">Web-based interface using Spring Boot</div>
        <div class="future-enhancement">REST API development</div>
        <div class="future-enhancement">Advanced reporting features</div>
        <div class="future-enhancement">Employee attendance tracking</div>
        <div class="future-enhancement">Payroll management integration</div>
        <div class="future-enhancement">Document management system</div>
        <div class="future-enhancement">Mobile application support</div>

        <h2><span class="emoji-float">📊</span> Screenshots</h2>
        <div class="installation-steps">
            <div class="step"><strong>Login Screen</strong><br>![Login Screen](screenshots/login.png)</div>
            <div class="step"><strong>Admin Dashboard</strong><br>![Admin Dashboard](screenshots/admin-dashboard.png)</div>
            <div class="step"><strong>Employee Management</strong><br>![Employee Management](screenshots/employee-management.png)</div>
        </div>

        <div class="footer">
            <p><strong>Made with <span class="emoji-float">❤️</span> by Suhasygowda</strong></p>
            <p><em><span class="star-animation">⭐</span> Star this repository if you found it helpful! <span class="star-animation">⭐</span></em></p>
        </div>
    </div>

    <script>
        // Add smooth scrolling animation for anchor links
        document.querySelectorAll('a[href^="#"]').forEach(anchor => {
            anchor.addEventListener('click', function (e) {
                e.preventDefault();
                document.querySelector(this.getAttribute('href')).scrollIntoView({
                    behavior: 'smooth'
                });
            });
        });

        // Add scroll-triggered animations
        const observerOptions = {
            threshold: 0.1,
            rootMargin: '0px 0px -50px 0px'
        };

        const observer = new IntersectionObserver((entries) => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    entry.target.style.opacity = '1';
                    entry.target.style.transform = 'translateY(0)';
                }
            });
        }, observerOptions);

        // Observe all animated elements
        document.querySelectorAll('.feature-card, .step, .future-enhancement').forEach(el => {
            el.style.opacity = '0';
            el.style.transform = 'translateY(20px)';
            el.style.transition = 'opacity 0.6s ease, transform 0.6s ease';
            observer.observe(el);
        });

        // Add hover effect to tech items
        document.querySelectorAll('.tech-item').forEach(item => {
            item.addEventListener('mouseenter', function() {
                this.style.transform = 'translateY(-5px) scale(1.1)';
            });
            
            item.addEventListener('mouseleave', function() {
                this.style.transform = 'translateY(0) scale(1)';
            });
        });

        // Add click effect to buttons
        document.querySelectorAll('.security-badge').forEach(badge => {
            badge.addEventListener('click', function() {
                this.style.animation = 'none';
                setTimeout(() => {
                    this.style.animation = 'securityGlow 2s ease-in-out infinite alternate';
                }, 100);
            });
        });

        // Add typing effect to the title
        function typeWriter(element, text, speed = 100) {
            let i = 0;
            element.innerHTML = '';
            
            function type() {
                if (i < text.length) {
                    element.innerHTML += text.charAt(i);
                    i++;
                    setTimeout(type, speed);
                }
            }
            type();
        }

        // Initialize typing effect when page loads
        window.addEventListener('load', function() {
            const title = document.querySelector('h1');
            const originalText = title.textContent;
            typeWriter(title, originalText, 80);
        });

        // Add parallax effect to background
        window.addEventListener('scroll', function() {
            const scrolled = window.pageYOffset;
            const parallaxBg = document.querySelector('.parallax-bg');
            if (parallaxBg) {
                parallaxBg.style.transform = `translateY(${scrolled * 0.5}px)`;
            }
        });

        // Add floating animation to emojis
        document.querySelectorAll('.emoji-float').forEach((emoji, index) => {
            emoji.style.animationDelay = `${index * 0.5}s`;
        });

        // Add click-to-copy functionality for code blocks
        document.querySelectorAll('.code-block').forEach(block => {
            block.addEventListener('click', function() {
                const text = this.textContent;
                navigator.clipboard.writeText(text).then(() => {
                    // Show copy notification
                    const notification = document.createElement('div');
                    notification.textContent = 'Code copied to clipboard!';
                    notification.style.cssText = `
                        position: fixed;
                        top: 20px;
                        right: 20px;
                        background: #28a745;
                        color: white;
                        padding: 10px 20px;
                        border-radius: 5px;
                        z-index: 1000;
                        animation: slideInRight 0.3s ease;
                    `;
                    document.body.appendChild(notification);
                    
                    setTimeout(() => {
                        notification.remove();
                    }, 2000);
                });
            });
            
            // Add cursor pointer to indicate clickable
            block.style.cursor = 'pointer';
            block.title = 'Click to copy code';
        });

        // Add dynamic star animation count
        document.querySelectorAll('.star-animation').forEach(star => {
            star.addEventListener('click', function() {
                // Create floating stars effect
                for (let i = 0; i < 5; i++) {
                    const floatingStar = document.createElement('span');
                    floatingStar.textContent = '⭐';
                    floatingStar.style.cssText = `
                        position: absolute;
                        pointer-events: none;
                        animation: floatUp 2s ease-out forwards;
                        left: ${Math.random() * 100}px;
                        top: ${Math.random() * 100}px;
                    `;
                    this.parentElement.appendChild(floatingStar);
                    
                    setTimeout(() => {
                        floatingStar.remove();
                    }, 2000);
                }
            });
        });

        // Add CSS for floating stars animation
        const style = document.createElement('style');
        style.textContent = `
            @keyframes floatUp {
                0% {
                    opacity: 1;
                    transform: translateY(0) scale(1);
                }
                100% {
                    opacity: 0;
                    transform: translateY(-100px) scale(0.5);
                }
            }
            
            @keyframes slideInRight {
                from {
                    opacity: 0;
                    transform: translateX(100px);
                }
                to {
                    opacity: 1;
                    transform: translateX(0);
                }
            }
        `;
        document.head.appendChild(style);

        // Add progress bar for page scroll
        const progressBar = document.createElement('div');
        progressBar.style.cssText = `
            position: fixed;
            top: 0;
            left: 0;
            width: 0%;
            height: 4px;
            background: linear-gradient(90deg, #667eea, #764ba2);
            z-index: 1000;
            transition: width 0.1s ease;
        `;
        document.body.appendChild(progressBar);

        window.addEventListener('scroll', function() {
            const scrollProgress = (window.scrollY / (document.body.scrollHeight - window.innerHeight)) * 100;
            progressBar.style.width = scrollProgress + '%';
        });
    </script>
</body>
</html>
