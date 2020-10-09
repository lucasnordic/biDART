package dart;

/*
    Todo:                   "VG feature 2: Rent based on date"
 */

import dart.items.ItemController;
import dart.users.UserController;

public class Dart {

    private ItemController itemController = new ItemController();
    private UserController userController = new UserController();

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
        printMenuItems(title, subMenus, inputPrompt);

        String[] validMenuChoice = {"M", "E", "C", "X"}; //Valid choices for user while in main menu:
        String menuChoice = UserInputHandler.inputValidString(validMenuChoice); // We store the choice the user is going to take:

        if (menuChoice.equalsIgnoreCase("M")) {
            loginCheck(menuChoice); // if the input is "M" then we send user to the login menu
        } else if (menuChoice.equalsIgnoreCase("E")) {
            loginCheck(menuChoice);
        } else if (menuChoice.equalsIgnoreCase("C")) {
            loginCheck(menuChoice);
        } else {
            printOutroAscii();
            UserInputHandler.closeScanner();  // We go into the class that has the scanner and close it.
            //System.out.println("RIP");
        }
    }

    public void loginCheck(String menuChoice) {

        if (menuChoice.equalsIgnoreCase("M")) {

            String managerPassword = "admin1234";
            System.out.print("Enter a password:");
            String inputPassword = UserInputHandler.inputString();

            if (!inputPassword.equals(managerPassword)) {
                System.out.print("Invalid password! ");
                System.out.print("Press any key to continue: ");
                UserInputHandler.pressAnyKeyCon();

                mainMenu(); // allows go back to menu
            } else {
                menuManager();
            }

        } else if (menuChoice.equalsIgnoreCase("E")) {

            String employeePassword = "password123";
            System.out.print("Enter a password:");
            String inputPassword = UserInputHandler.inputString();

            if (!inputPassword.equals(employeePassword)) {
                System.out.print("Invalid password! ");
                System.out.print("Press any key to continue: ");
                UserInputHandler.pressAnyKeyCon();

                mainMenu(); // allows go back to menu
            } else {
                menuEmployee();
            }

        } else if (menuChoice.equalsIgnoreCase("C")) {

            System.out.print("Please enter your username: ");
            String userName = UserInputHandler.inputString();

            System.out.print("Enter a password: ");
            String inputPassword = UserInputHandler.inputString();

            boolean userFound = userController.checkIfUserExists(userName, inputPassword);

            if (!userFound) {
                System.out.print("Invalid password! ");
                System.out.print("Press any key to continue: ");
                UserInputHandler.pressAnyKeyCon();
                mainMenu(); // allows go back to menu
            } else {
                menuCustomer();
            }

        }
    }

    /**
     * Once the user has entered the correct password the user will get access to these menu's:
     */

    //  This method handles the manager menu contents:
    public void menuManager() {
        // Here we create the content of the menu:
        String title = "Manager Screen - Type one of the options below:";
        String[] menuItems = {"Add an employee", "View all employees", "Remove an employee", "Return to Main Menu"};
        String inputPrompt = "Enter choice: ";

        // Here we send this content to be printed:
        printMenuItems(title, menuItems, inputPrompt);

        //  Here we store the max and min choice of the "menuItems":
        int minMenuChoice = 1;
        int maxMenuChoice = menuItems.length;

        // Here we let the user input a number between the choices available based on the size of the menuItems array:
        int menuChoice = UserInputHandler.inputIntMinMax(minMenuChoice, maxMenuChoice);

        // Here we go to different menus based on user input:
        switch (menuChoice) {
            case 1 -> userController.addEmployee();
            case 2 -> {
                userController.showEmployeeList();
                System.out.print("Press any key to continue...");
                UserInputHandler.pressAnyKeyCon();
            }
            case 3 -> userController.RemoveEmployee();
            case 4 -> mainMenu();
        }
        // This is not nececcary?
        menuManager();
    }

    //  This handles the employee menu contents:
    public void menuEmployee() {
        //  Here we store the menu content:
        String title = "Employee Screen - Type one of the options below:";
        String[] menuItems = {"Register a game", "Remove a game", "Register a customer",
                "Remove a customer", "Add a song album", "Remove a song album", "Show total rent profit", "View all games", "Return to Main Menu",
        };
        String inputPrompt = "Enter choice: ";

        //  Here we store the max and min choice based on "menuItems":
        int minMenuChoice = 1;
        int maxMenuChoice = menuItems.length;

        // Here we send the menu content to be printed:
        printMenuItems(title, menuItems, inputPrompt);

        // Here we let the user input a number between the choices available based on the size of the menuItems array:
        int menuChoice = UserInputHandler.inputIntMinMax(minMenuChoice, maxMenuChoice);

        // Here we go to different menus based on users input.
        switch (menuChoice) {
            case 1 -> itemController.registerAGame();
            case 2 -> itemController.RemoveAGame();
            case 3 -> userController.registration();
//            case 4 -> dartUsers.cancellation();
            case 5 -> itemController.addSong();
            case 6 -> itemController.deleteSong();
            case 7 -> itemController.showTotalRentProfit();
            case 8 -> itemController.showAllGames();
            case 9 -> mainMenu();
            //default -> System.exit(0);
            default -> throw new IllegalStateException("Unexpected value: " + menuChoice);
        }
        menuEmployee();
    }

    //  This method handles the customer menu contents:
    public void menuCustomer() {
        String title = "Customer Screen - Type one of the options below:";
        String[] menuItems = {"Rent a game", "Return a game", "Rent a song album", "Return a songalbum", "Return to Main Menu"};
        String inputPrompt = "Enter choice: ";
        printMenuItems(title, menuItems, inputPrompt);    // Here we send this content to be printed by the Class "Print"

        //  Here we store the max and min choice based on "menuItems":
        int minMenuChoice = 1;
        int maxMenuChoice = menuItems.length;
        int menuChoice = UserInputHandler.inputIntMinMax(minMenuChoice, maxMenuChoice);  // Goes into the MenuHandler class. MenuHandler prints the "prompt" and "mainMenuItems"

        switch (menuChoice) {  // Here we go to different menus based on user input.
            case 1 -> itemController.rentAGame();
            case 2 -> itemController.returnItem();
            case 3 -> itemController.rentSong();
            case 4 -> itemController.returnItem();
//            case 5 -> itemController.findGame();
//            case 6 -> itemController.findSong();
            case 5 -> mainMenu();
            //default -> System.exit(0);
        }
        menuCustomer();
    }


    /**
     * These methods handle printing certain parts related to menu's:
     */

    private void printMenuItems(String title, String[] subMenus, String inputPrompt) {
        System.out.println("- - - - - - - - - - - - - - - - -");
        System.out.println(title);

        // This loop prints out all the menu options that are stored in the "menuItems" array.
        for (int i = 0; i < subMenus.length; i++) {
            System.out.println( (i + 1) + ". " + subMenus[i]);
        }
//        for (String subMenu : subMenus) {
//            System.out.println(subMenu);
//        }

        System.out.println(" ");
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