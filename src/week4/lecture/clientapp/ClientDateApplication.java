package week4.lecture.clientapp;

import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;

/*
 * This class represent the window for the client side TCP application.
 * It display the date retrieve from the server.
 * 
 * @author haziqhapiz
 *
 */

public class ClientDateApplication {

	public static void main(String[] args) {
		// Launch the frame
		ClientDateFrame clientFrame = new ClientDateFrame();
		clientFrame.setVisible(true);

		// server information
		int portNo = 4228;

		try {
			// 1. connect to remote machine
			// 2. send request to the server
			Socket socket = new Socket(InetAddress.getLocalHost(), portNo);

			// 3. accept response from the server
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			String currentDate = inputStream.readUTF();

			// 4. Process the response
			clientFrame.updateServerDate(currentDate);
			clientFrame.updateConnectionStatus(true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
