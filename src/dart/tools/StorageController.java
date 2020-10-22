package dart.tools;

import dart.users.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StorageController {

    /**
     * Attributes:
     */

    private ArrayList<Customer> customerStorage;
    private static String customerFilePath = "./files/storage.txt";


    /**
     * Controller:
     */
    public StorageController() {
        this.customerStorage = new ArrayList<>();
    }


    /**
     * Methods:
     */

    public void importCustomerCSVBuffer() {
        try{

            // We create a an object that leads to the location of the customer file:
            File customerFile = new File(customerFilePath);

            // This fileReader and bufferedReader connects to our customer file
            FileReader fileReader = new FileReader(customerFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // This variable holds each line as the line
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }



              bufferedReader.close();



    } catch(IOException ex) {
            ex.printStackTrace();
        }
    }


}