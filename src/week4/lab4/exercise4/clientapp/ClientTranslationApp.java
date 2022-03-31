package exercise4.clientapp;

import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientTranslationApp {
    
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 4228);

            DataInputStream dis = new DataInputStream(socket.getInputStream());

            String text = dis.readUTF();
            System.out.println(text);

            // Close everything
            dis.close();
            socket.close();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
