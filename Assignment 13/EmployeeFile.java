import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeFile {

    public static void main(String[] args) {

        try {
            FileWriter fw = new FileWriter("employee.txt");
            fw.write("Employee ID: 101\n");
            fw.write("Name: Rahul\n");
            fw.write("Department: IT\n");
            fw.close();

            System.out.println("Employee details written to file.\n");

            // Reading from file
            FileReader fr = new FileReader("employee.txt");
            int ch;

            System.out.println("Employee Details:");
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }

            fr.close();

        } catch (IOException e) {
            System.out.println("File Error");
        }
    }
}