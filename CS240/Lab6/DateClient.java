// This is the Client Code, save as DateClient.java
import java.net.*;
import java.io.*;
 
public class DateClient
{
   public static void main(String[] args) throws IOException {
      try {
         Socket sock = new Socket("149.157.242.72",1234);
 
	 System.out.println("Connecting input stream to server socket\n");
         InputStream in = sock.getInputStream();
         // bin is the input stream from the server
         BufferedReader bin = new
               BufferedReader(new InputStreamReader(in));

	 System.out.println("What follows is from server\n");
         String line;
         while ( (line = bin.readLine()) != null)
            System.out.println(line);
 
         sock.close();
      }
      catch (IOException ioe) {
         System.err.println(ioe);
      }
   }
}

