package week4.lab4.exercise3.clientapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/*
 * This class represent the window for the client side TCP application.
 * It display the word count of a text from the server.
 * 
 * @author haziqhapiz
 *
 */

public class ClientTextApplication {

	public static void main(String[] args) {
		// Launch the frame
		ClientTextFrame clientFrame = new ClientTextFrame();
		clientFrame.setVisible(true);

		// server information
		int portNo = 4228;

		try {
			// 1. connect to remote machine
			// 2. send request to the server
			Socket socket = new Socket(InetAddress.getLocalHost(), portNo);

			// 3. accept response from the server
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());

			String text = inputStream.readUTF();
			int count = inputStream.readInt()

			// 4. Process the response
			clientFrame.setCount(count);
			clientFrame.setText(text);
			clientFrame.updateConnectionStatus(true);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
