package DART.Data.controllers;
import DART.Data.users.Customer;

import java.util.ArrayList;



public class CustomerLibrary {


    private ArrayList<Customer> customer;

    public CustomerLibrary() {

        this.customer = new ArrayList<Customer>();
    }

    public void addCustomer(Customer a) {
        customer.add(a);
    }

    public ArrayList<Customer> getCustomers() {
        return customer;
    }

    public void removeCustomer(Customer a){
        customer.remove(a);
    }

    public int getSize() {
        int a = customer.size();
        return a;
    }

    public String toString() {

        return  "" + this.getCustomers();
    }


    public Customer get(int i) {
        Customer a;
        a = customer.get(i);
        return a;
    }


    public void removeCustomer(int i) {
        customer.remove(i);
    }
}
