package week5.lab.sale.client.view;

import java.util.List;
import java.util.Scanner;

import week5.lab.sale.model.Customer;

public class CustomerViewer {

    public void displayCustomers(List<Customer> customers) {

        // Some information about the record
        System.out.println("\tNumber of record: " + customers.size());
        System.out.println("\n\tCustomer Information");

        sortCustomer(customers);

        // Print all products on console
        int i = 1;
        for (Customer customer : customers) {
            System.out.println("\t" + i + ". Name: " + customer.getName() + ", ID: " + customer.getCustomerId());
            i++;
        }
    }

    // receive customer id from user using java Scanner
    public int getCustomerId() {
        System.out.print("Enter customer id: ");
        Scanner sc = new Scanner(System.in); // Create a Scanner object

        int customerId = sc.nextInt(); // Read user input

        return customerId;
    }

    // receive customer name from user using java Scanner
    public String getCustomerName() {
        System.out.print("Enter customer name: ");
        Scanner sc = new Scanner(System.in); // Create a Scanner object

        String customerName = sc.nextLine(); // Read user input

        return customerName;
    }

    // sort customer by customer name
    public List<Customer> sortCustomer(List<Customer> customers) {

        customers.sort((Customer c1, Customer c2) -> c1.getName().compareTo(c2.getName()));

        return customers;
    }

}
