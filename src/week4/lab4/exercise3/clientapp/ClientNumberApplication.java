package week4.lab4.exercise3.clientapp;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

/*
 * This class represent the window for the client side TCP application.
 * It display the series of numbers from the server side application.
 * 
 * @author haziqhapiz
 *
 */

public class ClientNumberApplication {

	public static void main(String[] args) {

		// server information
		int portNo = 8082;
		String ipAddress = "10.73.32.7";

		try {
			// 1. connect to remote machine
			// 2. send request to the server
			InetAddress ip = InetAddress.getByName(ipAddress);
			Socket socket = new Socket(ip, portNo);

			System.out.print("Connected to server");

			// read all int from the server and end if the server send -1
			int number = 0;
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);

			while (dis.available() != -1) {
				number = dis.readInt();

				if (number == -1)
					break;
				System.out.println("Number: " + number);
			}

			dis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
