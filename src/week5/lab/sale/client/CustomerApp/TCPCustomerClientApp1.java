package week5.lab.sale.client.CustomerApp;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;

import java.util.List;
import week5.lab.sale.client.view.CustomerViewer;
import week5.lab.sale.model.Customer;
import week5.lab.sale.server.controller.CustomerDataManager;

/**
 * This is a TCP client class that get int and string input.
 * search customer in client-side and print customer information.
 * 
 * @author haziqhapiz
 *
 */
public class TCPCustomerClientApp1 {

    public static void main(String[] args) {

        Customer customer;
        CustomerViewer customerViewer = new CustomerViewer();
        CustomerDataManager manager = new CustomerDataManager();

        try {

            // Server information
            int serverPortNo = 8087;
            InetAddress serverAddress = InetAddress.getLocalHost();

            // 1. Connect to remote machine
            Socket socket = new Socket(serverAddress, serverPortNo);

            // Create stream to receive response from the server
            // InputStream is = socket.getInputStream();
            // ObjectInputStream ois = new ObjectInputStream(is);

            // get int input from user

            int customerId = customerViewer.getCustomerId();
            //
            // send customer id to server to search customer by customer id
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            // dos.writeInt(customerId);

            // get customer from server
            // Create stream to receive response from the server
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);

            // read customer object from server
            List<Customer> customers = (List<Customer>) ois.readObject();

            customer = manager.searchCustomerById(customerId);

            // customer.sear

            // customerViewer.displayCustomers(customers);

            // // 3. Read respond from the server - cast the object
            // // List<Customer> customers = (List<Customer>) ois.readObject();

            // // read string input from user
            // String customerName = customerViewer.getCustomerName();

            // // send customer name to server to search customer by customer name
            // dos.writeUTF(customerName);

            // // get customer from server
            // // Create stream to receive response from the server

            // // read customer object from server
            // customer = (Customer) ois.readObject();

            // // print customer information if customer is not null
            // if (customer != null) {
            // System.out.println("\tCustomer Id: " + customer.getCustomerId());
            // System.out.println("\tCustomer Name: " + customer.getName());
            // } else {
            // System.out.println("\tCustomer not found");
            // }

            // 4. Close connection
            socket.close();

            // 4. Display the result

            // get string input from user
            // String customerName = customerViewer.getCustomerName();
            // customerViewer.searchCustomerByName(customers, customerName);

            // 4. Process response - display the object
            // customerViewer.displayCustomers(customers);

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

}
