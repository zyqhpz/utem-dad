package week5.lab.greeting.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

/**
 * A client-side application using UDP
 * send a sentence to server to count vowels, consonants and punctuation
 * 
 * @author haziqhapiz
 *
 */

public class UDPCountClient {

    public static void main(String[] args) {

        System.out.println("\n\tRunning UDPCountClient....");

        Sentence sc = new Sentence();

        try {

            // 1. Define server port number and address
            int portNo = 8083;
            InetAddress ip = InetAddress.getLocalHost();

            // 2. Get sentence input from userand transform data into bytes
            sc.getSentenceInput();
            String sentence = sc.getSentence();
            byte buf[] = sentence.getBytes();

            // 3. Wrap data in datagram packet (constructor no 5)
            DatagramPacket outPacket = new DatagramPacket(buf, buf.length, ip, portNo);

            // 4. Create the socket object to transmit the data.
            DatagramSocket datagramSocket = new DatagramSocket();

            // 5. Send datagram packet
            datagramSocket.send(outPacket);
            System.out.println("\n\tSending '" + sentence + "' to server.");

            // 6.New buffer to extract the received data
            byte[] inData = new byte[65535];

            // 7. Packet to receive data
            DatagramPacket inPacket = new DatagramPacket(inData, inData.length);

            // 8. Receive data
            datagramSocket.receive(inPacket);

            // 9. Extract data
            inData = inPacket.getData();

            // 10. Further processing
            // Transform data into human readable text
            String vowels = new String(inData, 0, inPacket.getLength());
            String consonants = new String(inData, 0, inPacket.getLength());
            String punctuation = new String(inData, 0, inPacket.getLength());

            // Display the data received from the server
            System.out.println("\tVowels from the server is : " + vowels);
            System.out.println("\tConsonants from the server is : " + consonants);
            System.out.println("\tPunctuation from the server is : " + punctuation);

            datagramSocket.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        System.out.println("\n\tUDPCountClient: End of program.");

    }

}
