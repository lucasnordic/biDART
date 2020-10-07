package dart.data;

import dart.data.users.Customer;
import dart.InputOutput;

import java.util.ArrayList;

public class CustomerController {
    private ArrayList<Customer> customerList;

    public CustomerController() {
        this.customerList = new ArrayList<>();
    }

    // Getters and setters:
    public ArrayList<Customer> getCustomers() {
        return customerList;
    }

    public void registerCustomer() {
        System.out.print("Please enter a username: ");
        String name = InputOutput.inputString();

        System.out.print("Please enter the password you want to use: ");
        String password = InputOutput.inputString();
    }

    public void addCustomer() {

    }

    public void customerMembership() {
        Customer newCustomer = null;
        do {
            System.out.print("Do you want to upgrade your membership type(type yes or no): ");
            String[] validChoices = {"yes", "no"};
            String yesNo = InputOutput.inputValidString(validChoices);
            switch (yesNo) {
                case "yes" -> registerCustomer();
                case "no" -> registerCustomer();
            }

        }while(newCustomer == null);
    }

    public String toString() {
        return  "" + this.getCustomers();
    }

}
