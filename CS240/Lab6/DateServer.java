// This is the Server code, save as DateServer.java
import java.net.*;
import java.io.*;
 
public class DateServer {
   public static void main(String[] args) throws 
                                          IOException {
      try {
         // This creates a listener socket 
         ServerSocket sock = new ServerSocket(1234);
	 System.out.println("Server is listening on port 1234\n");
         while (true) {
            Socket client = sock.accept();
	    System.out.println("Accepted Client Connection, sending Date\n");
            // pout is the output stream to the client
            PrintWriter pout = new  
                 PrintWriter(client.getOutputStream(),true);
 
            pout.println(new java.util.Date().toString());
 
            client.close();
         }
      }
      catch (IOException ioe) {
         System.err.println(ioe);
      }
   }
}

