package Assignment_3;

import java.io.*;
import java.net.*;
import java.util.*;

import static Assignment_3.TestMulticast.PORT;

public class MulticastSender implements Runnable {
    private Thread t;
    private String user;
    private InetAddress inetAddress;
    private Scanner sc = new Scanner(System.in);

    public MulticastSender(String user, InetAddress inetAddress){
        this.user = user;
        this.inetAddress = inetAddress;
    }

    @Override
    public void run() {
        while (true) {
            sendMessageToServer(user + " :" + sc.nextLine());
        }
    }

    public void start(){
        System.out.println("######################\nStarting Sender Thread"+"\n######################");

        if(t == null){
            t = new Thread(this);
            t.start();
        }

        sendMessageToServer( user + " -> Entered the Chat Server");
    }

    private void sendMessageToServer(String msg)  {
        byte [] outBuff = msg.getBytes();

        try {
            DatagramPacket outPacket = new DatagramPacket(outBuff,outBuff.length, inetAddress, PORT);
            DatagramSocket socket = new DatagramSocket();
            socket.send(outPacket);

        } catch(IOException ioe){
            System.out.println(ioe);
        }
    }

}
	