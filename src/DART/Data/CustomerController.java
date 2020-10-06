package DART.Data;

import DART.Data.items.Customer;
import DART.MainMenu;
import DART.UserInputHandler;
import com.sun.tools.javac.Main;

import java.util.ArrayList;

public class CustomerController {
    private ArrayList<Customer> customerList;

    public CustomerController() {
        this.customerList = new ArrayList<>();
    }

    public void registerCustomer() {
        System.out.print("Please enter a username: ");
        String name = UserInputHandler.inputString();

        System.out.print("Please enter the password you want to use: ");
        String password = UserInputHandler.inputString();
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
            String yesNo = UserInputHandler.inputString();
            while (!yesNo.equalsIgnoreCase("yes") || !yesNo.equalsIgnoreCase("no"))
                if (yesNo.equalsIgnoreCase("yes")) {

                } else if (yesNo.equalsIgnoreCase("no")) {
                    MainMenu mainMenu = new MainMenu();
                    mainMenu.mainMenu();
                } else {
                    System.out.print("Please enter a correct answer(type yes or no): ");
                }
        }while(newCustomer == null);
    }

    public String toString() {
        return  "" + this.getCustomers();
    }

}
