package dart.controller;

import dart.model.item.Game;
import dart.model.item.Song;
import dart.model.item.Transaction;
import dart.model.user.Customer;
import dart.model.user.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class StorageController {


    /**
     * Attributes:
     */

    private static String storageFilePath = "./src/models.csv";
    private static final String HISTORY_NAME = "./src/history";


    /**
     * Methods:
     */

    public static boolean saveTranscationToFile(Transaction transaction) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_NAME, true))) {
            writer.append(transaction.getInfo() + "\n");
            return true;
        } catch (IOException a) {
            return false;
        }
    }

    public void importCustomerCSVBuffer(UserController userController, ItemController itemController) {
        try{

            // We create a an object that leads to the location of the customer file:
            File customerFile = new File(STORAGE_ITEMS_USERS);

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
                        System.out.println("Added: " + Arrays.toString(retrievedInfo));
                    }

                } else if(retrievedInfo[0].equals("Employee")) {
                    Employee employee = new Employee(retrievedInfo);
                    if(userController.getUserWithId(employee.getId()) == null) {
                        userController.addEmployee(employee);
                        System.out.println("Added: " + Arrays.toString(retrievedInfo));
                    }

                } else if(retrievedInfo[0].equals("Game")) {
                    Game game = new Game(retrievedInfo);

                    if(itemController.getItemWithId(game.getID()) == null) {
                        itemController.addGame(game);
                        System.out.println("Added: " + Arrays.toString(retrievedInfo));
                    }

                } else if(retrievedInfo[0].equals("Song")) {
                    Song song = new Song(retrievedInfo);

                    if(itemController.getItemWithId(song.getID()) == null) {
                        itemController.addSong(song);
                        System.out.println("Added: " + Arrays.toString(retrievedInfo));
                    }
                }
            }
            bufferedReader.close();

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    //this cm is only to check sth
}