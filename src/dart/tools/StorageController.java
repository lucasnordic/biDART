package dart.tools;

import dart.users.Customer;
import dart.users.UserController;
import dart.users.membership.Membership;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StorageController {

    /**
     * Attributes:
     */

    private ArrayList<Customer> customerStorage;
    private static String customerFilePath = "./src/customers.csv";


    /**
     * Controller:
     */

    public StorageController() {
        this.customerStorage = new ArrayList<>();
    }


    /**
     * Methods:
     */

    public void importCustomerCSVBuffer(UserController userController) {
        try{

            // We create a an object that leads to the location of the customer file:
            File customerFile = new File(customerFilePath);

//            if (customerFile.exists()) {
                // This fileReader and bufferedReader connects to our customer file
                FileReader fileReader = new FileReader(customerFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                // This variable holds each line as the line
                String line = null;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] userInfo = line.split(";");

                    if (userInfo[0].equals("Customer")) {
                        Customer customer = new Customer(userInfo);

                        if(userController.getUserWithId(customer.getId()) == null) {
                            userController.addCustomer(customer);
                        }
                    }
                }
                bufferedReader.close();
//            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}