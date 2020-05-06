package Assignment_3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class TestMulticast {
    public static final int PORT = 8888;

    public static void main(String[] args) {
        System.out.println("Enter your username.");
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        System.out.println("Enter your message.");

        try {
            InetAddress inetAddress = InetAddress.getByName("224.2.2.3");
            MulticastSocket multicastSocket = new MulticastSocket(PORT);

            Thread serverThread = new Thread(new MulticastReceiver(multicastSocket, inetAddress));
            serverThread.start();

            MulticastSender multicastSender = new MulticastSender(name, inetAddress);
            multicastSender.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
