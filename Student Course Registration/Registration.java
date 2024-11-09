package student.course.registration;
import java.sql.Connection;
import java.sql.SQLException;

public class Registration {
    public static void registerStudent(int studentId, int courseId) {
        try{
            String query = "INSERT INTO Enrollments (student_id, course_id) VALUES (?, ?)";
            var stmt = JDBC_Connection.conn.prepareStatement(query);
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            try{
                int res=stmt.executeUpdate();
                if(res>0)   System.out.println("Student enrolled successfully.");
            }catch(SQLException e){
                System.out.println("Please enter valid details");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    
      public static void viewRegistrations() {
        try {
            String query = "SELECT * FROM Enrollments";
            var stmt = JDBC_Connection.conn.createStatement();
            var resultSet = stmt.executeQuery(query);
            boolean flag =false;
            while (resultSet.next()) {
                flag=true;
                System.out.println("Registration ID: " + resultSet.getInt("enrollment_id"));
                System.out.println("Student ID: " + resultSet.getInt("student_id"));
                System.out.println("Course ID: " + resultSet.getInt("course_id"));
            }
            if(flag==false){
                System.out.println("No Student Found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
