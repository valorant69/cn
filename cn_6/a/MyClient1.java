// Corrected version of the MyClient1 class
import java.net.*;
import java.io.*;

class MyClient1 {
    public static void main(String args[]) throws Exception {
        // Create a socket connection to localhost on port 3333
        Socket s = new Socket("localhost", 3333);
        
        // Set up input and output streams
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = "", str2 = "";
        
        // Communication loop
        while (!str.equals("stop")) {
            System.out.print("Enter message: "); // Prompt for user input
            str = br.readLine();
            dout.writeUTF(str);
            dout.flush();
            
            str2 = din.readUTF(); // Read response from server
            System.out.println("Server says: " + str2);
        }
        
        // Close the streams and socket
        dout.close();
        din.close();
        s.close();
    }
}
