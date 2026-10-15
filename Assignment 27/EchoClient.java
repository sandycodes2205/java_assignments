import java.net.*;
import java.io.*;

public class EchoClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5001);

        BufferedReader keyboard = new BufferedReader(
            new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        System.out.print("Enter a message: ");
        String msg = keyboard.readLine();

        out.println(msg);

        String reply = in.readLine();
        System.out.println("Server replied: " + reply);

        s.close();
    }
}