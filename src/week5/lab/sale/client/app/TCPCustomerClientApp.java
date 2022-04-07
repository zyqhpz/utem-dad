package week5.lab.sale.client.app;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

import week5.lab.sale.client.view.CustomerViewer;
import week5.lab.sale.model.Customer;

/**
 * This is a TCP client class that process a list of object as complex data .
 * 
 * @author emalianakasmuri
 *
 */
public class TCPCustomerClientApp {

    public static void main(String[] args) {

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
            CustomerViewer customerViewer = new CustomerViewer();
            int customerId = customerViewer.getCustomerId();

            // send customer id to server to search customer by customer id
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeInt(customerId);

            // get customer from server
            // Create stream to receive response from the server
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);

            // read customer object from server
            Customer customer = (Customer) ois.readObject();

            // print customer information if customer is not null
            if (customer != null) {
                System.out.println("\tCustomer Id: " + customer.getCustomerId());
                System.out.println("\tCustomer Name: " + customer.getName());
            } else {
                System.out.println("\tCustomer not found");
            }

            // 3. Read respond from the server - cast the object
            // List<Customer> customers = (List<Customer>) ois.readObject();

            // read string input from user
            String customerName = customerViewer.getCustomerName();

            // send customer name to server to search customer by customer name
            dos.writeUTF(customerName);

            // get customer from server
            // Create stream to receive response from the server

            // read customer object from server
            customer = (Customer) ois.readObject();

            // print customer information if customer is not null
            if (customer != null) {
                System.out.println("\tCustomer Id: " + customer.getCustomerId());
                System.out.println("\tCustomer Name: " + customer.getName());
            } else {
                System.out.println("\tCustomer not found");
            }

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
