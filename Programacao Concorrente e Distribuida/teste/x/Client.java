import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedInputStream bufferedInputStream;
    private PrintWriter sendToServer;
    String message;

    public Client(Socket socket) {
        try {
            this.socket = socket;
            this.message = "Opa meu chapa";
            this.bufferedInputStream = new BufferedInputStream(socket.getInputStream());
            this.bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));
            this.sendToServer = new PrintWriter(socket.getOutputStream(), true);

            sendToServer.println(message);

            System.out.println("Server Answer: " + bufferedReader.readLine());
        
            closeEverything(this.socket, this.bufferedReader, this.bufferedInputStream);

        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedInputStream);
            e.printStackTrace();
        }
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedInputStream bufferedInputStream) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.130.129.103", 12345);
        Client client = new Client(socket);
        client.listenForMessage();
    }
}