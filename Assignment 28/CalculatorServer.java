import java.rmi.*;
import java.rmi.registry.*;

public class CalculatorServer {
    public static void main(String[] args) throws Exception {
        CalculatorImpl obj = new CalculatorImpl();

        LocateRegistry.createRegistry(1099);
        Naming.rebind("Calculator", obj);

        System.out.println("Calculator server is running.");
    }
}