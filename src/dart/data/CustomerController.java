package dart.data;

import dart.data.items.parent.Customer;
import dart.UserInputOutput;

import java.util.ArrayList;

public class CustomerController {
    private ArrayList<Customer> customerList;

    public CustomerController() {
        this.customerList = new ArrayList<>();
    }

    public void registerCustomer() {
        System.out.print("Please enter a username: ");
        String name = UserInputOutput.inputString();

        System.out.print("Please enter the password you want to use: ");
        String password = UserInputOutput.inputString();
    }

    public void addCustomer() {

    }

    public ArrayList<Customer> getCustomers() {
        return customerList;
    }

    public void customerMembership() {
        Customer newCustomer = null;
        do {
            System.out.print("Do you want to upgrade your membership type(type yes or no): ");
            String[] validChoices = {"yes", "no"};
            String yesNo = UserInputOutput.inputValidString(validChoices);
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
