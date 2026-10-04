import java.sql.*;
import java.util.Scanner;

public class Hospital_Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc_demo", "root", "sit@123");

            System.out.print("Enter Login ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            String query = "SELECT * FROM staff WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, id);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");

                if (role.equalsIgnoreCase("doctor")) {
                    System.out.println("Doctor login successful. Access granted.");
                } else if (role.equalsIgnoreCase("nurse")) {
                    System.out.println("Nurse login successful. Access granted.");
                } else {
                    System.out.println("Staff authenticated successfully.");
                }
            } else {
                System.out.println("Invalid Login ID or Password.");
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
