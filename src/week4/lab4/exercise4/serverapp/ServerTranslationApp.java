package exercise4.serverapp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTranslationApp {
	public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        
        try {
            int portNo = 4228;
            serverSocket = new ServerSocket(portNo);

            String text1 = "Good Afternoon.";
            System.out.println("Waiting for request");

            while (true) {
                Socket clientSocket = serverSocket.accept();

                DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

                outputStream.writeUTF(text1);

                clientSocket.close();
            }
        } catch (IOException e) {

            if (serverSocket != null) {
                serverSocket.close();
            }

            e.printStackTrace();
        }
    }
}
