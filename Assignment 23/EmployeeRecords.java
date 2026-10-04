import java.sql.*;

public class EmployeeRecords {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc_demo", "root", "sit@123");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                System.out.println("Employee ID: " + rs.getInt("eid"));
                System.out.println("Name: " + rs.getString("ename"));
                System.out.println("Salary: " + rs.getDouble("esal"));
                System.out.println("--------------------");
            }

            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
