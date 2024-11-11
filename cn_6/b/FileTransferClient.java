//6b
import java.io.*;
import java.net.*;
public class FileTransferClient {
public static void main(String[] args) {
String host = "127.0.0.1"; // Change to your server's IP
int port = 65432; // Port to connect to
try (Socket socket = new Socket(host, port)) {
// Receive the filename and size
BufferedReader in = new BufferedReader(new
InputStreamReader(socket.getInputStream()));
String data = in.readLine();
String[] parts = data.split(" ");
String filename = parts[0];
long filesize = Long.parseLong(parts[1]);
try (FileOutputStream fileOutputStream = new FileOutputStream("received_" +
filename);

BufferedInputStream inputStream = new
BufferedInputStream(socket.getInputStream())) {
byte[] buffer = new byte[1024];
long bytesReceived = 0;
int bytesRead;
while (bytesReceived < filesize && (bytesRead = inputStream.read(buffer)) !=

-1) {

fileOutputStream.write(buffer, 0, bytesRead);
bytesReceived += bytesRead;
}
}
System.out.println("File received successfully.");
} catch (IOException e) {
e.printStackTrace();
}
}
}
