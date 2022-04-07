package week5.sale.server.app;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import week5.sale.model.Customer;
import week5.sale.server.controller.CustomerDataManager;

public class TCPCustomerServerApp {

    public static void main(String[] args) {

        int portNo = 8087;

        CustomerDataManager manager = new CustomerDataManager();

        System.out.println("\n\tExecuting TCPProductsServerApp");

        Customer customer;

        try {

            System.out.println("\tWaiting for next request");

            // 1. Bind to a port
            ServerSocket serverSocket = new ServerSocket(portNo);

            // 2. Server need to continually run to listen to request
            while (true) {

                // 3. Accept request from client
                Socket clientSocket = serverSocket.accept();

                // Get customers
                List<Customer> customers = manager.getCustomers();

                // read customer id from client request
                DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
                int customerId = dis.readInt();

                System.out.println("\tCustomer Id Received: " + customerId);

                // search customer by customer id
                customer = manager.searchCustomerById(customerId);

                // send customer to client
                OutputStream os = clientSocket.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(os);
                oos.writeObject(customer);

                System.out.println("\tSending Customer object to client.. ");

                // read customer name from client request
                String customerName = dis.readUTF();
                
                System.out.println("\tCustomer name Received: " + customerName);

                // search customer by customer name
                customer = manager.searchCustomerByName(customerName);

                oos.writeObject(customer);

                System.out.println("\tSending Customer object to client.. ");

                

                // 4. Respond to client
                // OutputStream os = clientSocket.getOutputStream();
                // ObjectOutputStream oos = new ObjectOutputStream(os);
                // oos.writeObject(customers);
                // System.out.println("\tSending : " + products.size()
                //         + " products");

            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }

}
