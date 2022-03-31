package week4.lab4.exercise3.serverapp;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class represent the window for the server side TCP application.
 * It display the word count of a text from the server.
 * 
 * @author haziqhapiz
 *
 */

public class ServerTextApplication {

	public static void main(String[] args) {

		// Launch server frame
		ServerTextFrame serverFrame = new ServerTextFrame();
		serverFrame.setVisible(true);

		// construct object
		TextCounter textCounter = new TextCounter();

		// 1. bind to a port
		try {
			int portNo = 4228;
			ServerSocket serverSocket = new ServerSocket(portNo);

			// 2. Listen to request for connection continuously
			while (true) {
				// 3. Accept request to connection
				Socket socket = serverSocket.accept();

				// 4. Process the request
				String text = "Hello dunia ku! hehe";
				
				int count = textCounter.countWords(text);

				// Send current date to client using data output stream
				DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
				dataOutputStream.writeUTF(text);
				dataOutputStream.writeInt(count);

				// close output stream
				dataOutputStream.close();

				// close the socket
//				socket.close();

				// close server socket
				serverSocket.close();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
