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

//          if (customerFile.exists()) {
            // This fileReader and bufferedReader connects to our customer file
            FileReader fileReader = new FileReader(customerFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // This String variable holds each line as the line is read.
            String line = null;

            // While there is something to read, keep reading.
            while ((line = bufferedReader.readLine()) != null) {

                // here we split the line into separate strings and store it in an array.
                String[] retrievedInfo = line.split(";");

                // If the first index position in the array equals to "",
                // then we create a customer with the retrievedInfo.
                if (retrievedInfo[0].equals("Customer")) {
                    Customer customer = new Customer(retrievedInfo);

                    // If the customer does not exist already,
                    // then we add the customer to the list in usercontroller;
                    if(userController.getUserWithId(customer.getId()) == null) {
                        userController.addCustomer(customer);
                    }
                } else if(retrievedInfo[0].equals("Employee")) {
                    System.out.println("code here");
                } //TODO add more else ifs for Game and Song...


            }
            bufferedReader.close();
//          }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}