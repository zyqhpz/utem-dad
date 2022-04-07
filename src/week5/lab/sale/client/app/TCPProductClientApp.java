package week5.sale.client.app;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import week5.sale.model.Product;

/**
 * This is a TCP client class that process primitive (product id) and complex
 * (Product) data using different streams.
 * 
 * @author emalianakasmuri
 *
 */
public class TCPProductClientApp {
	
	public static void main (String[] args) {
		
		try {
			
			System.out.println("\tExecuting TCPProductClientApp");
		
			// Server information
			int serverPortNo = 8088;
			InetAddress serverAddress = InetAddress.getLocalHost();
			
			// 1. Connect to remote machine
			Socket socket = new Socket(serverAddress, serverPortNo);
			
			// Create stream to send request
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			// 2. Send request to the server
			int productId = 1003;
			dos.writeInt(productId);
			System.out.println("\tRequesting product id " + productId + "\n");
			
			// Create stream to receive response from the server
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			
			// 3. Read respond from the server - cast object
			Product product = (Product) ois.readObject();
			
			// 4. Process response - display the object
			System.out.println("\tProduct Information (From the server)");
			System.out.println("\tProduct Id: " + product.getProductId());
			System.out.println("\tName: " + product.getName());
			System.out.println("\tPrice: RM" + product.getPrice());
			
			
		} catch (Exception ex) {
			
			
			
		}
		
		
		
		
		
		
	}

}
