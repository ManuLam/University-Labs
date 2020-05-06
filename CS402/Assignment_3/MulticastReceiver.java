package Assignment_3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.sql.Timestamp;
import java.util.Date;

public class MulticastReceiver implements Runnable {
    private MulticastSocket multicastSocket;
    private InetAddress inetAddress;
    private static final int MAX_BUFFER_LENGTH = 256;

    public MulticastReceiver(MulticastSocket multicastSocket, InetAddress inetAddress) {
        this.multicastSocket = multicastSocket;
        this.inetAddress = inetAddress;
    }

    @Override
    public void run() {
        System.out.println("Server has started up...");

        byte[] buffer = new byte[MAX_BUFFER_LENGTH];    // Max buffer size
        DatagramPacket datagramPacket;
        String msg;

        try {
            multicastSocket.joinGroup(inetAddress);

            while (true) {
                datagramPacket = new DatagramPacket(buffer, buffer.length);
                multicastSocket.receive(datagramPacket);

                msg = new String(buffer, 0, datagramPacket.getLength(), "UTF-8");
                System.out.println("User " + msg + " || IP Address: " + datagramPacket.getAddress() + " || Received at: " + new Timestamp(new Date().getTime()));
            }
        } catch (IOException ioe) {
            System.out.println("Socket has been closed: " + ioe);
        }
    }

}
