// Corrected version of the UDPServer class
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        // Create a DatagramSocket on port 3000
        DatagramSocket socket = new DatagramSocket(3000);
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        System.out.println("Server is running and waiting for packets...");

        while (true) {
            // Receive a packet
            socket.receive(packet);
            String receivedMessage = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received: " + receivedMessage);

            // Echo the packet back to the sender
            DatagramPacket responsePacket = new DatagramPacket(
                packet.getData(), packet.getLength(), packet.getAddress(), packet.getPort()
            );
            socket.send(responsePacket);
        }
    }
}
