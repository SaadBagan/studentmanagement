# Student Management System (JSP + Servlets + JDBC + PostgreSQL)

A simple CRUD web application built using 
->Java Servlets
->JSP
->JDBC
->PostgreSQL  
This project allows users to manage student records — Add, View, Update and Delete.

## Features

=> Add new student  
=> View all students  
=> Update student details  
=> Delete a student  
=> Basic validations  
=> MVC project structure  
=> JDBC integration with PostgreSQL  

## Tech Stack

| Layer            | Technology |
|------------------|------------|
| Frontend         | JSP, HTML, CSS |
| Backend          | Java Servlets |
| Database         | PostgreSQL |
| Build Tool       | Maven |
| Server (local)   | Apache Tomcat |
| Version Control  | Git & GitHub |

## Project Structure
```
studentmanagement/
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── stmngt
│       │           ├── db
│       │           │   └── DBConnection.java
│       │           ├── model
│       │           │   └── Student.java
│       │           └── servlet
│       │               ├── AddStudentServlet.java
│       │               ├── ViewStudentsServlet.java
│       │               ├── UpdateStudentServlet.java
│       │               └── DeleteStudentServlet.java
│       └── webapp
│           ├── index.jsp
│           ├── add.jsp
│           ├── view.jsp
│           ├── update.jsp
│           └── WEB-INF
│               └── web.xml
```

## Database Schema (students Table)

| Field  | Type    | Constraints |
|--------|---------|-------------|
| id     | INT     | Primary Key |
| name   | VARCHAR | Not Null    |
| email  | VARCHAR | Unique      |
| age    | INT     | Not Null    |
| marks  | INT     | Optional    |


--> Author
Saad Bagan
GitHub: https://github.com/SaadBagan

