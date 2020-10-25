package dart.view;

/*
    Todo: FIX REVIEW. IT IS POSTED AS NULL.
 */

import dart.controller.ItemController;
import dart.controller.MessageController;
import dart.controller.StorageController;
import dart.controller.UserController;
import dart.model.user.Customer;
import dart.model.user.Employee;
import dart.model.user.User;
import dart.tool.PrintMenus;
import dart.tool.UserInputHandler;

public class DartView {

    private ItemController itemController = new ItemController();
    public UserController userController = new UserController();
    private MessageController messageController = new MessageController();
    private StorageController storageController = new StorageController();

    public DartView() {
        mainMenu();

    }

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
        PrintMenus.printMenuItems(title, subMenus, inputPrompt, "yes"); // We print the menu.

        String[] validMenuChoice = {"M", "E", "C", "X"}; //Valid choices for user while in main menu:
        String menuChoice = UserInputHandler.inputValidString(validMenuChoice); // We store the choice the user is going to take:

        switch (menuChoice.toUpperCase()) {
            case "M" -> loginCheckManager();
            case "E" -> loginCheckEmployee();
            case "C" -> loginCheckCustomer();
            default -> {
                printOutroAscii();
                UserInputHandler.closeScanner();  // We go into the class that has the scanner and close it.
            }
        }
        mainMenu();
    }


    public void loginCheckManager() {
        String managerPassword = "admin1234";

        System.out.print("Enter a password:");
        String inputPassword = UserInputHandler.inputString();

        if (!inputPassword.equals(managerPassword)) {
            System.out.print("Invalid password! ");
            UserInputHandler.pressAnyKeyCon();

            mainMenu();
        } else {
            userController.setCurrentUser(null);
            new ManagerView(itemController, messageController, userController, storageController);
        }
    }


    public void loginCheckEmployee() {
        String employeePassword = "password123";

        System.out.print("Enter a password:");
        String inputPassword = UserInputHandler.inputString();

        if (!inputPassword.equals(employeePassword)) {
            System.out.print("Invalid password! ");
            UserInputHandler.pressAnyKeyCon();

            mainMenu();
        } else {
            Employee employee = new Employee();
            userController.setCurrentUser(employee);
            new EmployeeView(employee, itemController, messageController, userController);
        }
    }


    public void loginCheckCustomer() {
        System.out.print("Please enter your username: ");
        String userName = UserInputHandler.inputString();

        System.out.print("Enter a password: ");
        String inputPassword = UserInputHandler.inputString();

        User user = userController.getUserWithNameAndPassword(userName, inputPassword);
        if (user instanceof Customer) {
            userController.setCurrentUser(user);
            new CustomerView(user, itemController, messageController, userController);
        } else {
            System.out.print("Invalid user! ");
            UserInputHandler.pressAnyKeyCon();
            mainMenu();
        }
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

