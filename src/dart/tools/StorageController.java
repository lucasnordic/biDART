package dart.tools;

import dart.items.Game;
import dart.items.Item;
import dart.items.Song;
import dart.users.Customer;
import dart.users.Employee;
import dart.users.UserController;
import dart.items.ItemController;
import dart.users.membership.Membership;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StorageController {

    /**
     * Attributes:
     */

    private ArrayList storage;  // what is this?
    private static String storageFilePath = "./src/customers.csv";


    /**
     * Controller:
     */

    public StorageController() {
        this.storage = new ArrayList<>();
    }


    /**
     * Methods:
     */

    public void importCustomerCSVBuffer(UserController userController, ItemController itemController) {
        try{

            // We create a an object that leads to the location of the customer file:
            File customerFile = new File(storageFilePath);

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
                    Employee employee = new Employee(retrievedInfo);
                    if(userController.getUserWithId(employee.getId()) == null) {
                        userController.addEmployee(employee);
                    }

                } else if(retrievedInfo[0].equals("Game")) {
                    Game game = new Game(retrievedInfo);

                    if(itemController.getItemWithId(game.getID()) == null) {
                        itemController.addGame(game);
                    }

                } else if(retrievedInfo[0].equals("Song")) {
                    Song song = new Song(retrievedInfo);

                    if(itemController.getItemWithId(song.getID()) == null) {
                        itemController.addSong(song);
                    }

                }



            }
            bufferedReader.close();
//          }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}