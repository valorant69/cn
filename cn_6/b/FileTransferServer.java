//6b
import java.io.*;
import java.net.*;
public class FileTransferServer {
public static void main(String[] args) {
int port = 65432; // Port to listen on
String filename = "path/to/your/file.txt"; // Change to your file path
try (ServerSocket serverSocket = new ServerSocket(port)) {
System.out.println("Server listening on port " + port + "...");
try (Socket socket = serverSocket.accept()) {
System.out.println("Connection established with " + socket.getInetAddress());
// Send the filename and size
File file = new File(filename);
long filesize = file.length();
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
out.println(file.getName() + " " + filesize);
// Send the file
try (FileInputStream fileInputStream = new FileInputStream(file);
BufferedOutputStream outputStream = new
BufferedOutputStream(socket.getOutputStream())) {
byte[] buffer = new byte[1024];
int bytesRead;
while ((bytesRead = fileInputStream.read(buffer)) != -1) {
outputStream.write(buffer, 0, bytesRead);
}
}
System.out.println("File transfer completed.");
}
} catch (IOException e) {
e.printStackTrace();
}
}
}
