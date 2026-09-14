import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorExp extends JFrame implements ActionListener {

    JTextField num1, num2, result;
    JButton add, subtract;

    CalculatorExp() {
        setTitle("Simple Calculator");
        setLayout(new GridLayout(4, 2));

        add(new JLabel("First Number:"));
        num1 = new JTextField();
        add(num1);

        add(new JLabel("Second Number:"));
        num2 = new JTextField();
        add(num2);

        add = new JButton("Addition");
        subtract = new JButton("Subtraction");

        add(add);
        add(subtract);

        add(new JLabel("Result:"));
        result = new JTextField();
        result.setEditable(false);
        add(result);

        add.addActionListener(this);
        subtract.addActionListener(this);

        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        double a = Double.parseDouble(num1.getText());
        double b = Double.parseDouble(num2.getText());

        if (e.getSource() == add) {
            result.setText("" + (a + b));
        }

        if (e.getSource() == subtract) {
            result.setText("" + (a - b));
        }
    }

    public static void main(String[] args) {
        new CalculatorExp();
    }
}