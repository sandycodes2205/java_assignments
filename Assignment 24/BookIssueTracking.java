import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class BookIssueTracking extends JFrame {
    JTextField bookId, student, issueDate, returnDate;
    Connection con;

    BookIssueTracking() {
        setTitle("Book Issue Tracking System");
        setSize(450, 300);
        setLayout(new GridLayout(6, 2, 5, 5));

        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc_demo", "root", "sit@123");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        bookId = new JTextField();
        student = new JTextField();
        issueDate = new JTextField();
        returnDate = new JTextField();

        add(new JLabel("Book ID:"));
        add(bookId);
        add(new JLabel("Student Name:"));
        add(student);
        add(new JLabel("Issue Date (YYYY-MM-DD):"));
        add(issueDate);
        add(new JLabel("Return Date (YYYY-MM-DD):"));
        add(returnDate);

        JButton insert = new JButton("Issue Book");
        JButton display = new JButton("Display Records");

        add(insert);
        add(display);

        insert.addActionListener(e -> {
            try {
                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO book_issue VALUES (?, ?, ?, ?)");

                ps.setInt(1, Integer.parseInt(bookId.getText()));
                ps.setString(2, student.getText());
                ps.setDate(3, Date.valueOf(issueDate.getText()));
                ps.setDate(4, Date.valueOf(returnDate.getText()));

                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Record added successfully!");
                ps.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        display.addActionListener(e -> {
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM book_issue");
                StringBuilder data = new StringBuilder();

                while (rs.next()) {
                    data.append("Book ID: ").append(rs.getInt("book_id"))
                        .append(", Student: ").append(rs.getString("student"))
                        .append(", Issue Date: ").append(rs.getDate("issueDate"))
                        .append(", Return Date: ").append(rs.getDate("returnDate"))
                        .append("\n");
                }

                JOptionPane.showMessageDialog(this, data.toString());
                rs.close();
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BookIssueTracking();
    }
}
