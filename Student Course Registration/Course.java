package student.course.registration;
import java.sql.Connection;
import java.sql.SQLException;
public class Course {
    private int courseId;
    private String title;
    private String details;
    private int credits;
    
    public static void addCourse(String title, String details, int credits) {
        try {
            String query = "INSERT INTO Courses (title, details, credits) VALUES (?, ?, ?)";
            var stmt = JDBC_Connection.conn.prepareStatement(query);
            stmt.setString(1, title);
            stmt.setString(2, details);
            stmt.setInt(3, credits);
            try{
                stmt.executeUpdate();
                System.out.println("Course added successfully.");
            }catch(SQLException e){
                System.out.println("Please enter valid details");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
       public static void viewAllCourses() {
        try{
            String query = "SELECT * FROM Courses";
            var stmt = JDBC_Connection.conn.createStatement();
            var resultSet = stmt.executeQuery(query);
            boolean flag=false;
            while (resultSet.next()) {
                flag=true;
                System.out.println("ID: " + resultSet.getInt("course_id"));
                System.out.println("Title: " + resultSet.getString("title"));
                System.out.println("Details: " + resultSet.getString("details"));
                System.out.println("Credits: " + resultSet.getInt("credits"));
            }if(flag==false){
                System.out.println("No course in database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
