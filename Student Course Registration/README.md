# Student Course Registration System

This project is a **Student Course Registration System** built in Java using JDBC for database connectivity. The application allows users to register students, add courses, and enroll students in specific courses. The backend database is powered by MySQL, supporting essential CRUD (Create, Read, Update, Delete) operations on students, courses, and registrations. It includes robust exception handling to ensure smooth operation even when unexpected errors occur.

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [System Requirements](#system-requirements)
- [Database Setup](#database-setup)
- [Getting Started](#getting-started)
- [Code Structure](#code-structure)
- [Usage](#usage)
- [Future Enhancements](#future-enhancements)

## Project Overview
The **Student Course Registration System** provides functionalities to:
- Register new students with their information.
- Add courses with relevant details.
- Register students in selected courses.
- View all students, courses, and registrations.

This system is intended to facilitate course registration for educational institutions, with extensive exception handling to manage database connectivity issues, SQL errors, and unexpected inputs.

## Features
1. **Add Student**: Add new students by providing their name and email.
2. **Add Course**: Define courses with information such as title, details, and credits.
3. **Register in Course**: Register students to specific courses.
4. **View All Students, Courses, and Registrations**: Display lists of all students, courses, and registrations.
5. **Resource Management**: Close all database resources when the application exits.
6. **Exception Handling**: Each feature implements exception handling to manage SQL errors, validation failures, and other runtime issues.
7. **Centralized Connection**: Uses a single static connection for managing database connectivity efficiently across all operations.

## System Requirements
- **Java**: Version 8 or higher
- **MySQL**: Version 5.7 or higher
- **JDBC Driver**: MySQL JDBC Driver (Connector/J)

## Database Setup

1. Install MySQL and create a database named `student_registration`.
2. Run the following SQL commands to create the required tables:

   ```sql
   CREATE DATABASE student_registration;
   USE student_registration;

   CREATE TABLE Students (
       student_id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(50),
       email VARCHAR(100) UNIQUE
   );

   CREATE TABLE Courses (
       course_id INT AUTO_INCREMENT PRIMARY KEY,
       title VARCHAR(100),
       details TEXT,
       credits INT
   );

   CREATE TABLE Registrations (
       registration_id INT AUTO_INCREMENT PRIMARY KEY,
       student_id INT,
       course_id INT,
       FOREIGN KEY (student_id) REFERENCES Students(student_id) ON DELETE CASCADE,
       FOREIGN KEY (course_id) REFERENCES Courses(course_id) ON DELETE CASCADE
   );

The Registrations table uses student_id and course_id as foreign keys to link to the Students and Courses tables, respectively. ON DELETE CASCADE ensures that if a student or course is deleted, all related records in Registrations will be automatically removed.

## Getting-Started

  - Clone the Repository
      git clone https://github.com/sakshibansalsb/student-course-registration.git <br/>
      cd student-course-registration


## Code Structure

- **Student.java**: Handles student-related operations (e.g., add, view all students).
- **Course.java**: Handles course-related operations (e.g., add, view all courses).
- **Registration.java**: Manages course registration, such as registering students in courses.
- **JDBC_Connection.java**: Manages a single database connection instance and provides database connectivity.
- **StudentCourseRegistration.java**: Main class that contains the menu-driven program for interacting with the user and performing operations on students, courses, and registrations.


## Usage

Compile and run the main program, following the menu options for adding students, courses, viewing all entities, and registering students to courses. The system includes exception handling to ensure users are notified of any SQL issues or duplicate entries.

## Future Enhancements

- Implement search functionality for students and courses.
- Add user authentication for different administrative roles.
- Add a GUI for improved usability.

This README provides comprehensive information on the project setup, database schema, and usage. Let me know if you’d like further adjustments or additions.


  
