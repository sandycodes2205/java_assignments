import java.sql.*;

public class Database_Connection {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc_demo",
                "root",
                "sit@123"
            );

            if (con != null) {
                System.out.println("Database connected successfully!");
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Connection failed!");
            System.out.println(e.getMessage());
        }
    }
}

