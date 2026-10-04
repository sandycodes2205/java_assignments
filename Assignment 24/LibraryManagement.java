import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class LibraryManagement extends JFrame {
    JTextField id, title, price, publisher;
    Connection con;
    PreparedStatement ps;

    LibraryManagement() {
        setTitle("Library Management System");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 5, 5));

        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc_demo", "root", "sit@123");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        id = new JTextField();
        title = new JTextField();
        price = new JTextField();
        publisher = new JTextField();

        add(new JLabel("Book ID:"));
        add(id);
        add(new JLabel("Book Title:"));
        add(title);
        add(new JLabel("Price:"));
        add(price);
        add(new JLabel("Publisher"));
        add(publisher);

        JButton insert = new JButton("Add Book");
        JButton display = new JButton("Display Books");

        add(insert);
        add(display);

        insert.addActionListener(e -> {
            try {
                ps = con.prepareStatement(
                    "INSERT INTO books VALUES (?, ?, ?, ?)");
                ps.setInt(1, Integer.parseInt(id.getText()));
                ps.setString(2, title.getText());
                ps.setFloat(3, Float.parseFloat(price.getText()));
                ps.setString(4, publisher.getText());
                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Book added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        display.addActionListener(e -> {
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM books");
                StringBuilder data = new StringBuilder();

                while (rs.next()) {
                    data.append(rs.getInt("bid")).append("  ")
                        .append(rs.getString("bname")).append("  ")
                        .append(rs.getString("price")).append("  ")
                        .append(rs.getString("publisher")).append("\n");
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
        new LibraryManagement();
    }
}