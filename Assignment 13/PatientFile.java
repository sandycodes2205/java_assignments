import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PatientFile {

    public static void main(String[] args) {

        try {
            FileWriter fw = new FileWriter("patient.txt");
            fw.write("Patient ID: 201\n");
            fw.write("Name: Riya\n");
            fw.write("Age: 25\n");
            fw.write("Diagnosis: Fever\n");
            fw.close();

            System.out.println("Patient details written to file.\n");

            // Reading from file
            FileReader fr = new FileReader("patient.txt");
            int ch;

            System.out.println("Patient Details:");
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }

            fr.close();

        } catch (IOException e) {
            System.out.println("File Error");
        }
    }
}