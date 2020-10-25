package dart.view;


import dart.controller.ItemController;
import dart.controller.MessageController;
import dart.controller.UserController;
import dart.model.item.Game;
import dart.model.item.Item;
import dart.model.item.Song;
import dart.model.user.Customer;
import dart.model.user.Employee;
import dart.model.user.Message;
import dart.model.user.User;
import dart.model.user.membership.Membership;
import dart.tool.InvalidDataInput;
import dart.tool.PrintMenus;
import dart.tool.UserInputHandler;

import java.util.ArrayList;

public class EmployeeView {
    private ItemController itemController;
    private MessageController messageController;
    private UserController userController;
    private final User user;


    public EmployeeView(User user, ItemController itemController, MessageController messageController, UserController userController) {
        this.user = user;
        this.itemController = itemController;
        this.userController = userController;
        this.messageController = messageController;
        menuEmployee();
    }


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
        PrintMenus.printMenuItems(title, menuItems, inputPrompt, "yes"); // Here we send the menu content to be printed.

        // Here we let the user input a number between the choices available based on the size of the menuItems array:
        int menuChoice = UserInputHandler.inputIntMinMax(1, menuItems.length);
        switch (menuChoice) { // Here we go to different menus based on users input.
            case 1 -> registerGame();
            case 2 -> removeGame();
            case 3 -> registerCustomer();
            case 4 -> removeCustomer();
            case 5 -> registerAlbum();
            case 6 -> removeAlbum();
            case 7 -> itemController.menuShowTotalRentProfit();
            case 8 -> itemController.showAll();
            case 9 -> menuUpgradeCustomer();
            case 10 -> {
                return;
            }
        }
        menuEmployee();
    }

    public void registerGame() {
        System.out.print("Title: ");
        String title = UserInputHandler.inputString();
        System.out.print("Genre: ");
        String genre = UserInputHandler.inputString();
        System.out.print("Daily rent: ");
        double rent = UserInputHandler.inputDouble();
        System.out.print("Release year: ");
        int year = UserInputHandler.inputInt();
        try {
            Item item = new Game(title, rent, year, genre);
            itemController.addItem(item);
        } catch (InvalidDataInput e) {
            System.out.println(e.getMessage());
        }

    }

    public void removeGame() {
        itemController.showAllGames();
        System.out.print("Please enter the ID of the game you want to remove: ");
        String id = UserInputHandler.inputString();
        String result = itemController.removeItem(id);
        System.out.println(result);
    }

    public void registerCustomer() {
        System.out.print("Please enter the Customers username: ");
        String name = UserInputHandler.inputString();
        System.out.print("Please enter a password for the Customer: ");
        String password = UserInputHandler.inputString();
        try {
            Customer customer = new Customer(name, password);
            userController.registerUSer(customer);
        } catch (InvalidDataInput e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeCustomer() {
        userController.showCustomerListNameId();
        System.out.print("Which customer should be removed? ID: ");
        String id = UserInputHandler.inputString();
        String result = userController.removeUserByPartialInput(id);
        System.out.println(result);
        UserInputHandler.pressAnyKeyCon();
    }

    public void registerAlbum() {
        System.out.print("Title: ");
        String title = UserInputHandler.inputString();
        System.out.print("Artist: ");
        String artist = UserInputHandler.inputString();
        System.out.print("Release year: ");
        int releaseYear = UserInputHandler.inputInt();
        System.out.print("Daily rent: ");
        double rent = UserInputHandler.inputDouble();
        try {
            Item item = new Song(title, rent, artist, releaseYear);
            itemController.addItem(item);

        } catch (InvalidDataInput e) {
            System.out.println(e.getMessage());
        }

    }

    public void removeAlbum() {
        itemController.showAllAlbums();
        System.out.print("Please enter the ID of the song which you wish to delete:");
        String id = UserInputHandler.inputString();
        String result = itemController.removeItem(id);
        System.out.println(result);
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
        PrintMenus.printMenuItems(title, menuItems, inputPrompt, "yes");


        //  Here we store the max and min choice based on "menuItems" size:
        int menuChoice = UserInputHandler.inputIntMinMax(1, menuItems.length);

        if (menuChoice == 1 || menuChoice == 2) {
            System.out.print("Enter the ID of the customer: ");
            String customerId = UserInputHandler.inputString();
            System.out.println(" ");

            Customer customer = (Customer) userController.getUserWithId(customerId);
            if (customer != null) {
                switch (menuChoice) {
                    case 1 -> messageController.removeMessageFromListBasedOnCustomerId(customerId);
                    case 2 -> menuManageCustomerUpgrade(customer);
                    case 3 -> {
                        return;
                    }
                }
            } else {
                System.out.println("Could not find Customer with ID: " + customerId);
                UserInputHandler.pressAnyKeyCon();
                menuEmployee();
            }
        } else {
//            menuEmployee();
            return;
        }
    }

    //  This is a continuation of previous method. It checks if a user is already Platinum.
    //  If he is not, then he will be upgraded.
    public void menuManageCustomerUpgrade(Customer customer) {
        Membership membership = customer.getMembership();

        if (membership.getMembershipClass().equals("Platinum")) {
            System.out.println("Customer is already Platinum!");

            messageController.removeMessageFromListBasedOnCustomerId(customer.getId());
        } else {
            membership = customer.membershipUpgrade();
            System.out.println(
                    "User is upgraded to " + membership.getMembershipClass() + ".\n"
            );

            messageController.removeMessageFromListBasedOnCustomerId(customer.getId());
        }
        menuEmployee();
    }
}
