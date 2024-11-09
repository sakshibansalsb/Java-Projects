package student.course.registration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
    public class JDBC_Connection {
    private static final String URL = "jdbc:mysql://localhost:3306/your-database-name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";
    public static Connection conn;
    
    static{
        try{
         conn=DriverManager.getConnection(url,username,password);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void closeConnection(){
       try{
           JDBC_Connection.conn.close();
       }catch(SQLException e){
            System.out.println(e.getMessage());
        }
                     
    }             
}
