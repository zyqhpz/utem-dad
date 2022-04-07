package week5.sale.server.app;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import week5.sale.model.Product;
import week5.sale.server.controller.ProductDataManager;

public class TCPProductsServerApp {

	public static void main(String[] args) {
		
		int portNo = 8088;
		
		ProductDataManager manager = new ProductDataManager();
		
		System.out.println("\n\tExecuting TCPProductsServerApp");
		
		try {
			
			System.out.println("\tWaiting for next request");
			
			// 1. Bind to a port
			ServerSocket serverSocket = new ServerSocket(portNo); 
			
			// 2. Server need to continually run to listen to request
			while (true) {
				
				// 3. Accept request from client
				Socket clientSocket = serverSocket.accept();
								
				// Get product
				List<Product> products = manager.getProducts();
				
				// 4. Respond to client
				OutputStream os  = clientSocket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(products);
				System.out.println("\tSending : " + products.size() 
					+ " products");
				
			}
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

	}

}
