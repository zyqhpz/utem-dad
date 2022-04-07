package week5.sale.client.app;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

import week5.sale.client.view.ProductViewer;
import week5.sale.model.Product;

/**
 * This is a TCP client class that process a list of object as complex data .
 * 
 * @author emalianakasmuri
 *
 */
public class TCPProductsClientApp {
	
	public static void main (String[] args) {
		
		try {
		
			// Server information
			int serverPortNo = 8088;
			InetAddress serverAddress = InetAddress.getLocalHost();
			
			// 1. Connect to remote machine
			Socket socket = new Socket(serverAddress, serverPortNo);
			
			
			// Create stream to receive response from the server
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			// 3. Read respond from the server - cast the object
			List<Product> products = (List<Product>) ois.readObject();
			
			// 4. Process response - display the object
			ProductViewer productViewer = new ProductViewer();
			productViewer.displayProducts(products);
			
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
		}
		
		
		
		
		
		
	}

}
