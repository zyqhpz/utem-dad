package week4.lecture.serverdate;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDateApplication {

	public static void main(String[] args) {
		
		// Launch server frame
		ServerDateFrame serverFrame = new ServerDateFrame();
		serverFrame.setVisible(true);
		
		// 1. bind to a port
		try {
			int portNo = 4228;
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			// 2. Listen to request for connection continuously
			while(true) {				
				// 3. Accept request to connection
				Socket socket = serverSocket.accept();
				
				// 4. Process the request
				DateGenerator dateGenerator = new DateGenerator();
				String currentDate = dateGenerator.generateCurrentDate();
				
				// Send current date to client using data output stream
				DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
				dataOutputStream.writeUTF(currentDate);
				
				// close the socket
				socket.close();
				
				// close server socket
				serverSocket.close();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
