import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeCrud {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        Connection con = jdbc_con.getConnection();
                
        while (true) {
        
            System.out.println("\n==== Employee MENU ====");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. View Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
        switch (choice) {
                case 1:
                    try{
                        System.out.print("Enter id: ");
                        int eid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter name: ");
                        String ename = scanner.nextLine();
                        System.out.print("Enter salary: ");
                        int esalary = scanner.nextInt();

                        String sql = "INSERT INTO employee (eid, ename, esal) VALUES (?, ?, ?)";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setInt(1, eid);
                        ps.setString(2, ename);
                        ps.setInt(3, esalary);
                        int i = ps.executeUpdate();
                        if(i > 0){
                            System.out.println("Employee added successfully!");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:

                    System.out.print("Enter employee id to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new salary: ");
                    int newSalary = scanner.nextInt();
                    try {
                        String updateSql = "UPDATE employee SET ename = ?, esal = ? WHERE eid = ?";
                        PreparedStatement updatePs = con.prepareStatement(updateSql);
                        updatePs.setString(1, newName);
                        updatePs.setInt(2, newSalary);
                        updatePs.setInt(3, updateId);
                        int i = updatePs.executeUpdate();
                        if (i > 0) {
                            System.out.println("Employee updated successfully!");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;
                case 3:
                    System.out.print("Enter employee id to delete: ");
                    int eid = scanner.nextInt();
                    try {
                        String deleteSql = "DELETE FROM employee WHERE eid = ?";
                        PreparedStatement deletePs = con.prepareStatement(deleteSql);
                        deletePs.setInt(1, eid);
                        int i = deletePs.executeUpdate();
                        if (i > 0) {
                            System.out.println("Employee deleted successfully!");
                        }

                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;
                case 4:
                    try {
                        System.out.println("\n==== Employee List ====");
                        String selectSql = "SELECT * FROM employee";
                        PreparedStatement selectPs = con.prepareStatement(selectSql);
                        ResultSet rs = selectPs.executeQuery();
                        while(rs.next()){
                            System.out.println("ID: " + rs.getInt("eid") + ", Name: " + rs.getString("ename") + ", Salary: " + rs.getInt("esal"));
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
