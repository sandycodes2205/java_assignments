import java.sql.*;
import java.util.Scanner;

public class Student_CRUD {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "sit@123";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            int choice;

            do {
                System.out.println("\n1. Insert Student");
                System.out.println("2. Display Students");
                System.out.println("3. Update Student Marks");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    float marks = sc.nextFloat();

                    PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO student VALUES (?, ?, ?, ?)");

                    ps.setInt(1, roll);
                    ps.setString(2, name);
                    ps.setString(3, course);
                    ps.setFloat(4, marks);

                    ps.executeUpdate();
                    System.out.println("Student inserted successfully.");
                }

                else if (choice == 2) {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM student");

                    while (rs.next()) {
                        System.out.println(
                            rs.getInt("roll") + " " +
                            rs.getString("name") + " " +
                            rs.getString("course") + " " +
                            rs.getFloat("marks"));
                    }
                }

                else if (choice == 3) {
                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    sc.nextLine();

                    System.out.print("Enter New Marks: ");
                    float marks = sc.nextFloat();
                    sc.nextLine();

                    PreparedStatement ps = con.prepareStatement(
                        "UPDATE student SET marks = ? WHERE roll = ?");

                    ps.setFloat(1, marks);
                    ps.setInt(2, roll);

                    ps.executeUpdate();
                    System.out.println("Student marks updated.");
                }

                else if (choice == 4) {
                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM student WHERE roll_ = ?");

                    ps.setInt(1, roll);
                    ps.executeUpdate();
                    System.out.println("Student deleted.");
                }

            } while (choice != 5);

            con.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        sc.close();
    }
}