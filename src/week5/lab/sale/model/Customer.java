package week5.lab.sale.model;

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {
    private int customerId;
    private String name;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public List<Customer> getCustomers() {
    // return customers;
    // }

    public Customer searchCustomerById(int id, List<Customer> customers) {
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
}
