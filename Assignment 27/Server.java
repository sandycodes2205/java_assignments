import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server is waiting...");

        Socket s = ss.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(
            new InputStreamReader(System.in));

        String msg;

        while (true) {
            msg = in.readLine();
            System.out.println("Client: " + msg);

            if (msg.equalsIgnoreCase("exit"))
                break;

            System.out.print("Server: ");
            msg = keyboard.readLine();
            out.println(msg);

            if (msg.equalsIgnoreCase("exit"))
                break;
        }

        s.close();
        ss.close();
    }
}