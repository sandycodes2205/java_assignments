import java.rmi.*;
import java.util.Scanner;

public class TemperatureClient {
    public static void main(String[] args) throws Exception {
        Temperature t = (Temperature)
            Naming.lookup("rmi://localhost/Temperature");

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();

        if (choice == 1)
            System.out.println("Fahrenheit: " + t.celsiusToFahrenheit(temp));
        else if (choice == 2)
            System.out.println("Celsius: " + t.fahrenheitToCelsius(temp));
        else
            System.out.println("Invalid choice.");

        sc.close();
    }
}