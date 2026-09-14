import javax.swing.*;
import java.awt.*;

public class StudentRegistration {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Registration Form");

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel rollLabel = new JLabel("Roll No:");
        JTextField rollField = new JTextField();

        JLabel courseLabel = new JLabel("Course:");
        JTextField courseField = new JTextField();

        JButton button = new JButton("Register");

        frame.setLayout(new GridLayout(4, 2));

        frame.add(nameLabel);
        frame.add(nameField);

        frame.add(rollLabel);
        frame.add(rollField);

        frame.add(courseLabel);
        frame.add(courseField);

        frame.add(button);

        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame,
                    "Student Registered Successfully!\n" +
                    "Name: " + nameField.getText() +
                    "\nRoll No: " + rollField.getText() +
                    "\nCourse: " + courseField.getText());
        });

        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
