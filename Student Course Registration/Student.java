package student.course.registration;
import java.sql.SQLException;
import java.sql.Connection;
public class Student {
     private int studentId;
    private String name;
    private String email;
    
       public static void addStudent(String name, String email) {
        try {
            String query = "INSERT INTO Students (name, email) VALUES (?, ?)";
            var stmt = JDBC_Connection.conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, email);
            try{
                stmt.executeUpdate();
                System.out.println("Student added successfully.");                
            }catch(SQLException e){
                System.out.println("This Email already exists.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       public static void viewAllStudents() {
        try{
            String query = "SELECT * FROM Students";
            var stmt = JDBC_Connection.conn.createStatement();
            var resultSet = stmt.executeQuery(query);
            
            boolean flag=false;
            while (resultSet.next()) {
                flag=true;
                System.out.println("ID: " + resultSet.getInt("student_id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));
            }
            if(flag==false){
                System.out.println("No Student Exists ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
