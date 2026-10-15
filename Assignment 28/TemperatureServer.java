import java.rmi.*;
import java.rmi.registry.*;

public class TemperatureServer {
    public static void main(String[] args) throws Exception {
        TemperatureImpl obj = new TemperatureImpl();

        LocateRegistry.createRegistry(1099);
        Naming.rebind("Temperature", obj);

        System.out.println("Temperature server is running.");
    }
}