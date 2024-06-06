import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public  Client(Socket socket){

        try{
            OutputStream output = socket.getOutputStream();
            InputStream input = socket.getInputStream();

            String message = "MjAxOQ==";
            byte[] messageInBytes = message.getBytes();
            output.write(messageInBytes);
            output.flush();

            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);

            String serverAnswer = new String(buffer, 0, bytesRead);
            System.out.println(serverAnswer);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Socket clientSocket = null;
        try {
            clientSocket = new Socket("10.130.129.103", 12345);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        new Client(clientSocket);
    }
}