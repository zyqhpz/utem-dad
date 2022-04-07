package week5.lab.sale.client.CustomerApp;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;

import week5.lab.sale.client.view.CustomerViewer;
import week5.lab.sale.model.Customer;

/**
 * This is a TCP client class that get int and string input.
 * process data from server and print customer information.
 * 
 * @author haziqhapiz
 *
 */
public class TCPCustomerClientApp {

    public static void main(String[] args) {

        Customer customer;

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
            customer = (Customer) ois.readObject();

            // print customer information if customer is not null
            if (customer != null) {
                System.out.println("\tCustomer Id: " + customer.getCustomerId());
                System.out.println("\tCustomer Name: " + customer.getName());
            } else {
                System.out.println("\tCustomer not found");
            }

            // read string input from user
            String customerName = customerViewer.getCustomerName();

            // send customer name to server to search customer by customer name
            dos.writeUTF(customerName);

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

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

}
