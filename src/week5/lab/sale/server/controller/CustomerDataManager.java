package week5.lab.sale.server.controller;

import java.util.ArrayList;
import java.util.List;

import week5.lab.sale.model.Customer;

public class CustomerDataManager {
    private List<Customer> customers;

    public CustomerDataManager() {
        this.customers = new ArrayList<Customer>();
        createSample();
    }

    // create a list of customers. 10 customers
    private void createSample() {

        // store name in array
        String[] names = { "John", "Mary", "Peter", "James", "Linda", "David", "Susan", "Robert", "Lisa", "Michael" };
        int[] id = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // create a customer object
        Customer customer;

        // create a loop to store 10 customers
        for (int i = 0; i < 10; i++) {
            customer = new Customer();
            customer.setCustomerId(id[i]);
            customer.setName(names[i]);
            customers.add(customer);
        }
    }

    // search a customer based on customer's name and return a customer object
    public Customer searchCustomerByName(String name) {
        Customer customer = new Customer();

        boolean found = false;

        // create a loop to search a customer
        for (Customer c : customers) {
            if (c.getName().equals(name)) {
                customer = c;
                found = true;
                break;
            }
        }

        if (!found) {
            return null;
        }

        else {
            return customer;
        }
    }

    // search a customer based on customer's id and return a customer object
    public Customer searchCustomerById(int id) {
        Customer customer = new Customer();

        boolean found = false;

        // create a loop to search a customer
        for (Customer c : customers) {
            if (c.getCustomerId() == id) {
                customer = c;
                found = true;
                break;
            }
        }

        if (!found) {
            return null;
        }

        else {
            return customer;
        }
    }

    // return a list of customers
    public List<Customer> getCustomers() {
        return customers;
    }

}
