package week5.lab.sale.client.view;

import java.util.List;
import java.util.Scanner;

import week5.lab.sale.model.Customer;
import week5.lab.sale.server.controller.CustomerDataManager;

public class CustomerViewer {

    public void displayCustomers(List<Customer> customers) {

        // Some information about the record
        System.out.println("\tNumber of record: " + customers.size());
        System.out.println("\tCustomer Information");

        // Print all products on console
        for (Customer customer : customers) {

            System.out.println("\tCustomer Id: " + customer.getCustomerId());
            System.out.println("\tCustomer Name: " + customer.getName());
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

    // // search customer by customer id
    // public void searchCustomerById(List<Customer> customers, int customerId) {

    // // Some information about the record
    // System.out.println("\tNumber of record: " + customers.size());
    // System.out.println("\tCustomer Information");

    // CustomerDataManager customerDataManager = new CustomerDataManager();

    // // create a loop to search a customer
    // customer.sear

    // // Print all customers on console
    // for (Customer customer : customers) {

    // if (customer.getCustomerId() == customerId) {
    // System.out.println("\tCustomer Id: " + customer.getCustomerId());
    // System.out.println("\tCustomer Name: " + customer.getName());
    // }
    // }

    // }

}
