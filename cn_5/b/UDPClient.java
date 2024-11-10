// Corrected version of the UDPClient class
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        // Create a DatagramSocket
        DatagramSocket socket = new DatagramSocket();
        
        // Prepare the message to send
        String message = "Hello, Server!";
        byte[] buffer = message.getBytes();
        
        // Specify the server address and port
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 3000);
        
        // Send the packet to the server
        socket.send(packet);
        
        // Prepare to receive a response
        buffer = new byte[1024]; // Increase the buffer size for receiving
        packet = new DatagramPacket(buffer, buffer.length);
        
        // Receive the response packet
        socket.receive(packet);
        
        // Print the received message
        System.out.println("Sent: " + new String(packet.getData(), 0, packet.getLength()));
        
        // Close the socket
        socket.close();
    }
}
