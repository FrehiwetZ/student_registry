# Student Registry

A simple Java Servlet web application for managing student registrations. The app accepts student details from a form and stores them in a database using JDBC.

 Features

Add/register new students via a web form

Store student data in a relational database (e.g., MySQL)

Java Servlet handles form submission and database logic

Clean project structure using standard Java web conventions

 Technologies Used

✔ Java (Servlets)
✔ JDBC (Database connectivity)
✔ Apache Tomcat (Servlet container)
✔ MySQL / any relational DB
✔ Maven or manual build tools if used
✔ HTML/CSS for frontend form

# Getting Started
Requirements

Make sure you have installed:

Java JDK 8 or higher

Apache Tomcat (or any compatible servlet container)

MySQL Server (or another supported RDBMS)

IDE like Eclipse / IntelliJ (optional)

1️⃣ Clone the Repository
git clone https://github.com/FrehiwetZ/student_registry.git

2️⃣ Database Setup

Create the database and table used by the servlet.

Example using MySQL:

CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    age INT,
    course VARCHAR(100)
);


Update database config (JDBC URL, username, password) in your servlet or config class.

3️⃣ Configure Database Credentials

In your servlet (e.g., StudentRegistry.java), update:

String url = "jdbc:mysql://localhost:3306/studentdb";
String username = "your-db-user";
String password = "your-db-password";

4️⃣ Build & Deploy

Build the project with your IDE or using Maven/Ant

Deploy WAR (if using) to Tomcat

Start Tomcat server

5️⃣ Run the App

Open your browser and go to something like:

http://localhost:8080/student_registry/


Navigate to the registration form, fill it out, and submit to save student data.

# How It Works

A user fills out the student registration form

The form sends a POST request to a Java Servlet

Servlet reads the form parameters

Using JDBC, data is inserted into the database

A response page confirms success or failure

This pattern (HTML form → Servlet controller → JDBC → DB) is standard in Java web apps. 
GitHub

# Project Structure (Example)
student_registry/
│
├─ src/main/java/                ← Java sources
│   └─ com/example/servlet/
│      └─ StudentRegistry.java
│
├─ WebContent/ (or webapp/)      ← HTML & JSP pages
│   ├─ index.html
│   └─ register.jsp
│
├─ WEB-INF/
│   └─ web.xml                   ← Servlet mappings
│
├─ pom.xml (if using Maven)
└─ README.md

 Notes

Ensure the JDBC driver .jar (e.g., mysql-connector-java.jar) is in your project classpath.

You can expand features later (list students, update, delete, search, etc.).

Adjust form fields and database schema as needed.

 Contributors

FrehiwetZ – Original project

Feel free to fork, improve, and submit pull requests!
