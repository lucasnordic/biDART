package dart;

/*
    Todo: A LOT!
 */

import dart.items.ItemController;
import dart.tools.Message;
import dart.tools.StorageController;
import dart.tools.UserInputHandler;
import dart.users.*;
import dart.tools.MessageController;
import dart.users.membership.Membership;
//import dart.view.ViewManager;

import java.util.ArrayList;

public class Dart {

    private ItemController itemController = new ItemController();
    public UserController userController = new UserController();
    private MessageController messageController = new MessageController();
    private StorageController storageController = new StorageController();


    /**
     * This is where the user first lands:
     */

    public void mainMenu() {
        String title = "Main Menu - Welcome to DART,\n" +
                "your good old game rental system. The competition has no steam to keep up! ;)\n\n" +
                "Please specify your role by entering one of the options given:";
        String[] subMenus = {
                "Enter “M” for Manager",
                "Enter “E” for Employee",
                "Enter “C” for Customer",
                "Enter “X” to exit system"
        };
        String inputPrompt = "Choose menu: ";
        printMenuItems(title, subMenus, inputPrompt, "yes"); // We print the menu.

        String[] validMenuChoice = {"M", "E", "C", "X"}; //Valid choices for user while in main menu:
        String menuChoice = UserInputHandler.inputValidString(validMenuChoice); // We store the choice the user is going to take:

        switch (menuChoice.toUpperCase()) {
            case "M" -> loginCheckManager();
            case "E" -> loginCheckEmployee();
            case "C" -> loginCheckCustomer();
            default -> {
                printOutroAscii();
                UserInputHandler.closeScanner();  // We go into the class that has the scanner and close it.
                //System.out.println("RIP");
            }
        }
    }


    public void loginCheckManager() {
        String managerPassword = "admin1234";

        System.out.print("Enter a password:");
        String inputPassword = UserInputHandler.inputString();

        if (!inputPassword.equals(managerPassword)) {
            System.out.print("Invalid password! ");
            UserInputHandler.pressAnyKeyCon();

            mainMenu(); // allows go back to menu
        } else {
            userController.setCurrentUser(null);
            menuManager();
        }
    }


    public void loginCheckEmployee() {
        String employeePassword = "password123";

        System.out.print("Enter a password:");
        String inputPassword = UserInputHandler.inputString();

        if (!inputPassword.equals(employeePassword)) {
            System.out.print("Invalid password! ");
            UserInputHandler.pressAnyKeyCon();

            mainMenu(); // allows go back to menu
        } else {
            userController.setCurrentUser(null);
            menuEmployee();
        }
    }


    public void loginCheckCustomer() {
        System.out.print("Please enter your username: ");
        String userName = UserInputHandler.inputString();

        System.out.print("Enter a password: ");
        String inputPassword = UserInputHandler.inputString();

//            boolean userFound = userController.checkIfUserExists(userName, inputPassword);

        User user = userController.getUserWithNameAndPassword(userName, inputPassword);
        if (user instanceof Customer) {
            userController.setCurrentUser(user);
            menuCustomer();
        } else {
            System.out.print("Invalid user! ");
            UserInputHandler.pressAnyKeyCon();
            mainMenu(); // allows go back to menu
        }
    }


    /**
     * These methods handles the manager menu contents:
     */

    public void menuManager() {
        // Here we create the content of the menu:
        String title = "Manager Screen - Type one of the options below:";
        String[] menuItems = {
                "Add an employee",
                "View all employees",
                "Remove an employee",
                "Calculate Net Salary",
                "View transaction",
                "Most profitable items",
                "Most popular items",
                "Best customers",
                "Import or export a file",
                "Return to Main Menu"
        };
        String inputPrompt = "Enter choice: ";
        printMenuItems(title, menuItems, inputPrompt, "yes"); // Here we send this content to be printed:

        // Here we let the user input a number between the choices available based on the size of the menuItems array:
        int menuChoice = UserInputHandler.inputIntMinMax(1, menuItems.length);
        switch (menuChoice) { // Here we go to different menus based on user input:
            case 1 -> userController.addEmployee();
            case 2 -> userController.showEmployeeList();
            case 3 -> userController.removeEmployee();
            case 4 -> menuShowNetSalary();
            case 5 -> itemController.showTransaction();
            case 6 -> itemController.profitableItems();
            case 7 -> itemController.rentFrequency();
            case 8 -> itemController.myFavoriteCustomer();
            case 9 -> menuImportOrExportFile();
            case 10 -> mainMenu();
        }
        menuManager();
    }


    // This menu shows net salary:
    public void menuShowNetSalary() {
        System.out.println("The total net salary of all employees are " + userController.calculateNetSalary());
        UserInputHandler.pressAnyKeyCon();
    }

    public void menuImportOrExportFile() {

        String title = "Import/Export menu";
        String[] menuItems = {
                "Import a file",
                "Export a file",
                "Go back"
        };
        String inputPrompt = "Enter choice: ";
        printMenuItems(title, menuItems, inputPrompt, "yes"); // Here we send this content to be printed:

        // Here we let the user input a number between the choices available based on the size of the menuItems array:
        int menuChoice = UserInputHandler.inputIntMinMax(1, menuItems.length);
        switch (menuChoice) { // Here we go to different menus based on user input:
            case 1 -> storageController.importCustomerCSVBuffer(this.userController);
//            case 2 -> storageController.importCustomerCSVBuffer();
            case 3 -> menuManager();
        }
        menuManager();
    }

    public void menuRentHistory() {
        /**
         * See
         */
    }


    /**
     * These methods handles the Employee menu contents:
     */

    public void menuEmployee() {
        //  Here we store the menu content:
        String title = "Employee Screen - Type one of the options below:";
        String[] menuItems = {
                "Register a game",
                "Remove a game",
                "Register a customer",
                "Remove a customer",
                "Add a song album",
                "Remove a song album",
                "Show total rent profit",
                "View all items",
                "View Upgrade requests",
                "Return to Main Menu",
        };
        String inputPrompt = "Enter choice: ";
        printMenuItems(title, menuItems, inputPrompt, "yes"); // Here we send the menu content to be printed.

        // Here we let the user input a number between the choices available based on the size of the menuItems array:
        int menuChoice = UserInputHandler.inputIntMinMax(1, menuItems.length);
        switch (menuChoice) { // Here we go to different menus based on users input.
            case 1 -> itemController.registerAGame();
            case 2 -> itemController.removeAGame();
            case 3 -> userController.registration();
            case 4 -> userController.cancellation();
            case 5 -> itemController.addSong();
            case 6 -> itemController.deleteSong();
            case 7 -> itemController.menuShowTotalRentProfit();
            case 8 -> itemController.showAll();
            case 9 -> menuUpgradeCustomer();
            case 10 -> mainMenu();
            //default -> System.exit(0);
            //default -> throw new IllegalStateException("Unexpected value: " + menuChoice);
        }
        menuEmployee();
    }


    //  These menu's handles upgrading a customer:
    public void menuUpgradeCustomer() {
        Employee employee = new Employee();
        ArrayList<Message> messages = messageController.getMessageListForUser(employee);

        //shown all messages as a numbered list.
        for (int i = 0; i < messages.size(); i++) {
            System.out.println(/*i + 1 + " " +*/ messages.get(i));
        }

        String title = "What would you like to do:";
        String[] menuItems = {
                "Deny upgrade",
                "Accept upgrade",
                "Return to main menu"
        };
        String inputPrompt = "Enter choice: ";
        printMenuItems(title, menuItems, inputPrompt, "yes");
        // TODO: I have to check if no upgrade

        //  Here we store the max and min choice based on "menuItems" size:
        int menuChoice = UserInputHandler.inputIntMinMax(1, menuItems.length);

        if (menuChoice == 1) {
            System.out.print("Enter the ID of the customer you want to Deny: ");
        } else {
            System.out.print("Enter the ID of the customer you want to Accept: ");
        }

        String customerId = UserInputHandler.inputString();
        System.out.println(" ");    // printing an empty line

        Customer customer = (Customer) userController.getUserWithId(customerId);
        // TODO: main menu or employee menu??
        if (customer != null) {
            switch (menuChoice) {
                case 1 -> messageController.removeMessageFromListBasedOnCustomerId(customerId);
                case 2 -> menuManageCustomerUpgrade(customer);
                case 3 -> mainMenu();
            }
        } else {
            System.out.println("Could not find Customer with ID: " + customerId);
            UserInputHandler.pressAnyKeyCon();
        }
        mainMenu();
    }

    //  This is a continuation of previous method. It checks if a user is already Platinum.
    //  If he is not, then he will be upgraded.
    public void menuManageCustomerUpgrade(Customer customer){
        Membership membership = customer.getMembership();

        // TODO Use enum???
        if (membership.getMembershipClass().equals("Platinum")) {
            System.out.println("Customer is already Platinum!");

            messageController.removeMessageFromListBasedOnCustomerId(customer.getId());
        } else {
            membership = customer.membershipUpgrade();
            System.out.println(
                    "User is upgraded to " + membership.getMembershipClass() + ".\n"
//                "Press any key to go back: "
            );

            messageController.removeMessageFromListBasedOnCustomerId(customer.getId());
        }
        menuEmployee();
    }


    /**
     * These methodd handles the customer menu contents:
     */


    public void menuCustomer() {
        // TODO: Print out the current users membership type.
//        Customer customer = (Customer) userController.getCurrentUser().;
//        System.out.println(userController.getCurrentUser());
        String title = "Customer Screen - Type one of the options below:";
        String[] menuItems = {
                "Rent a game",
                "Return a game",
                "Rent a song album",
                "Return a song album",
                "Search for game or song album",
                "Sort",
                "Message center",
                "Return to Main Menu"
        };
        String inputPrompt = "Enter choice: ";
        printMenuItems(title, menuItems, inputPrompt, "yes");    // Here we send this content to be printed by the Class "Print"

        //  Here we store the max and min choice based on "menuItems":
        int minMenuChoice = 1;
        int maxMenuChoice = menuItems.length;
        int menuChoice = UserInputHandler.inputIntMinMax(minMenuChoice, maxMenuChoice);  // Goes into the MenuHandler class. MenuHandler prints the "prompt" and "mainMenuItems"

        switch (menuChoice) {  // Here we go to different menus based on user input.

            case 1 -> rentUserTeleport();
            case 2 -> returnUserTeleport();
            case 3 -> rentUserTeleport();
            case 4 -> returnUserTeleport();
            case 5 -> findItem();
            case 6 -> sort();
            case 7 -> messageCenterMenu();
            case 8 -> mainMenu();
            //default -> System.exit(0);
            // default -> throw new IllegalStateException("Unexpected value: " + menuChoice);
        }
        menuCustomer();
    }


    public void rentUserTeleport() {
        User currentUser = userController.getCurrentUser();
        itemController.rentProcess((Customer) currentUser);
    }


    public void returnUserTeleport() {
        User currentUser = userController.getCurrentUser();
        itemController.returnProcess((Customer) currentUser);
    }


    private void sort() {
        System.out.println("Please press G for games and S for song albums: ");
        String choice = UserInputHandler.inputString();
        if (choice.equalsIgnoreCase("G")) {
            System.out.println("Please press Y for sort by year and R for sort by average user rating: ");
            String choiceG = UserInputHandler.inputString();
            if (choiceG.equalsIgnoreCase("Y")) {
                itemController.sortByYearUsingInterfaces();
                itemController.showAllGames();
            }
            if (choiceG.equalsIgnoreCase("R")) {
                itemController.sortByAverageRatingUsingInterfaces();
                itemController.showAllGames();
            }
            return;
        }
        if (choice.equals("S")) {
            System.out.println("Please press Y for sort by year and R for sort by average user rating: ");
            String choiceS = UserInputHandler.inputString();
            if (choiceS.equalsIgnoreCase("Y")) {
                itemController.sortByYearUsingInterfaces();
                itemController.showAllAlbums();
            }
            if (choiceS.equalsIgnoreCase("R")) {
                itemController.sortByAverageRatingUsingInterfaces();
                itemController.showAllAlbums();
            }
            return;
        }
        System.out.println("Invalid input! Please try again.");
    }


    public void findItem() {
        System.out.print("Please enter S for song album search or G for game search: ");
        String input = UserInputHandler.inputString();
        if (input.equals("S")) {
            System.out.print("Please enter the year of a song album: ");
            int year = UserInputHandler.inputInt();
            itemController.findSong(year);
        } else if (input.equals("G")) {
            System.out.print("Please enter the genre of a game:  ");
            String genre = UserInputHandler.inputString();
            itemController.findGame(genre);
        } else {
            System.out.println("Invalid input! Please try again.");
            return;
        }
    }

    /**
     * These methods handle the users interaction with messages:
     */
    //  This method handles all the message sending the user will have to do:
    private void messageCenterMenu() {
        String title = "Message center - Type one of the options below:";
        String[] menuItems = {
                "View inbox",
                "Send a message",
                "Remove message",
                "Send a membership upgrade request",
                "Go back"
        };
        String inputPrompt = "Enter choice: ";
        printMenuItems(title, menuItems, inputPrompt, "yes");

        Customer customer = (Customer)userController.getCurrentUser();

        int menuChoice = UserInputHandler.inputIntMinMax(1, menuItems.length);
        switch (menuChoice) {
            case 1 -> receiveNewMessage();
            case 2 -> sendMessage();
            case 3 -> removeMessage();
            case 4 -> messageController.addMessageToList(
                    "Requesting upgrade from " + customer.getMembership().getMembershipClass() + " membership.",
                    userController.getCurrentUserName(),
                    userController.getCurrentUserId(),
                    null,
                    "employee"
            );
            case 5 -> menuCustomer();
        }
        messageCenterMenu();
    }

    // you are getting all messages from array list of the current user who logged in.
    // Then we check all the messages and if they are read or not and print only unread.
    private void receiveNewMessage() {
        //String userID = userController.getCurrentUserId();
        ArrayList<Message> messages = messageController.getMessageListForUser(userController.getCurrentUser());// you are getting all messages from array list of the current user who logged in
        for (Message message : messages) {
            if (!(message.getIsRead())) {
                System.out.println(message);
                message.setRead();
            } else {
                System.out.println("No new messages found!");
            }
        }

        UserInputHandler.pressAnyKeyCon();
    }


    private void sendMessage() {

        System.out.println("Here is a list of all Customers: ");
        userController.showCustomerListNameId();// fixed here to show all customers Names and Id only
        System.out.print("Please enter the recipients ID: ");
        String id = UserInputHandler.inputString();
        System.out.print("Write your message: ");
        String message = UserInputHandler.inputString();

        messageController.addMessageToList(message, userController.getCurrentUserName(), userController.getCurrentUserId(), id, "personal");

        UserInputHandler.pressAnyKeyCon();
    }


    private void removeMessage() {
        ArrayList<Message> messages = messageController.getMessageListForUser(userController.getCurrentUser());// you are getting all messages from array list of the current user who logged in
        for (Message message : messages) {
            System.out.println(message);//shown all messages
        }

        System.out.print("Please type the ID of the message that should be removed: ");
        String userID = UserInputHandler.inputString();

        messageController.removeMessageFromListBasedOnCustomerId(userID);

        UserInputHandler.pressAnyKeyCon();
    }


    /**
     * These methods handle printing certain parts related to menu's:
     */

    private void printMenuItems(String title, String[] subMenus, String inputPrompt, String line) {
        if (line.equalsIgnoreCase("yes")) {
            System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
        }
        System.out.println(title);

        // This loop prints out all the menu options that are stored in the "menuItems" array.
        for (int i = 0; i < subMenus.length; i++) {
            System.out.println((i + 1) + ". " + subMenus[i]);
        }
//        for (String subMenu : subMenus) {
//            System.out.println(subMenu);
//        }

        System.out.println("");
        System.out.print(inputPrompt);
    }

    public static void printIntroAscii() {
        System.out.println(" _   _ ____  _____ _____ _____ \n" +
                "| |_|_|    \\|  _  | __  |_   _|\n" +
                "| . | |  |  |     |    -| | |  \n" +
                "|___|_|____/|__|__|__|__| |_|  ");
    }
    private static void printOutroAscii() {
        System.out.println("- - - - - - - - - - - - -");
        System.out.println("                       _   \n" +
                " _____            _   |_|_ \n" +
                "| __  |_ _ ___   |_|    | |\n" +
                "| __ -| | | -_|   _     | |\n" +
                "|_____|_  |___|  |_|   _|_|\n" +
                "      |___|           |_|  ");
    }
}



/*  OLD CODE:

//    public User user = userController.getCurrentUser();



 */