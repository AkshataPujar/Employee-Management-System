# Employee Management System

A console-based Employee Management System developed using Core Java.

## Project Overview

This project demonstrates fundamental Java programming and object-oriented programming concepts through a simple employee management application.

The application allows users to:

- Add employees
- View all employees
- Search employees by ID
- Search employees by department
- Update employee details
- Delete employees
- Validate user input

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- Exception Handling
- Git/GitHub

## Java Concepts Demonstrated

- Classes and objects
- Encapsulation
- Constructors
- Getters and setters
- Method overriding
- Collections (`ArrayList`)
- Loops and conditional statements
- Methods
- Exception handling
- Input validation

## Project Structure

```text
Employee-Management-System-Java/
├── src/
│   ├── Employee.java
│   ├── EmployeeManager.java
│   └── Main.java
├── .gitignore
└── README.md
```

## How to Run

### Prerequisite

Install JDK 17 or later.

### Compile

Open a terminal in the project directory and run:

```bash
javac -d out src/*.java
```

### Run

```bash
java -cp out Main
```

## Example Features

### Add Employee

The user enters:

- Employee ID
- Name
- Department
- Salary

The application checks that the employee ID is unique.

### Search Employee

An employee can be searched using the employee ID.

### Search by Department

The application returns all employees belonging to a specified department.

### Update Employee

Existing employee details can be modified.

### Delete Employee

Employees can be removed using their employee ID.

## Limitations

This version stores data in memory using `ArrayList`. Data is lost when the application exits.

## Future Enhancements

- MySQL database integration using JDBC
- Login/authentication
- REST API using Spring Boot
- GUI/web interface
- Employee attendance and payroll modules
- Unit testing using JUnit

## Author

Vijaykumar Pujar
## hi