import java.sql.*;

public class ProductDatabase {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "sit@123";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            String query = "SELECT * FROM product";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("Product ID: " + rs.getInt("prod_id"));
                System.out.println("Product Name: " + rs.getString("prod_name"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("Price: " + rs.getFloat("price"));
                System.out.println();
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}