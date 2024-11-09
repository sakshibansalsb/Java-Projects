package student.course.registration;

import java.util.Scanner;

public class StudentCourseRegistration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Student Course Registration System!");

        while (!exit) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Add Course");
            System.out.println("4. View All Courses");
            System.out.println("5. Register Student in Course");
            System.out.println("6. View All Registrations");
            System.out.println("7. Exit");

            System.out.print("Enter Your Choice Here :  ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student email: ");
                    String email = scanner.nextLine();
                    Student.addStudent(name, email);
                    break;

                case 2:
                    System.out.println("Listing all students:");
                    Student.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter course title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter course details: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter course credits: ");
                    int credits = scanner.nextInt();
                    Course.addCourse(title, description, credits);
                    break;

                case 4:
                    System.out.println("Listing all courses:");
                    Course.viewAllCourses();
                    break;

                case 5:
                    System.out.print("Enter student ID to register: ");
                    int studentId = scanner.nextInt();
                    System.out.println("All courses are : ");
                    Course.viewAllCourses();
                    System.out.print("Enter course ID to register in: ");
                    int courseId = scanner.nextInt();
                    Registration.registerStudent(studentId, courseId);
                    break;

                case 6:
                    System.out.println("Listing all enrollments:");
                    Registration.viewRegistrations();
                    break;

                case 7:
                    exit = true;
                    JDBC_Connection.closeConnection();
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
  }
    
