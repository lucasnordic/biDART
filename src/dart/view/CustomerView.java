package dart.view;


import dart.controller.ItemController;
import dart.controller.MessageController;
import dart.controller.UserController;
import dart.model.user.Customer;
import dart.model.user.Message;
import dart.model.user.User;
import dart.tool.PrintMenus;
import dart.tool.UserInputHandler;

import java.util.ArrayList;

public class CustomerView {
    private ItemController itemController;
    private MessageController messageController;
    private UserController userController;
    private Customer customer;

    public CustomerView(User user, ItemController itemController, MessageController messageController, UserController userController) {
        this.customer = (Customer) user;
        this.itemController = itemController;
        this.userController = userController;
        this.messageController = messageController;
        menuCustomer();
    }

    private void menuCustomer() {
        String title = "Customer Screen - Type one of the options below:";
        String[] menuItems = {
                "Rent an game",
                "Return a game",
                "Rent an album",
                "Return a song album",
                "Search for game or song album",
                "Sort",
                "Message center",
                "Return to Main Menu"
        };
        String inputPrompt = "Enter choice: ";
        PrintMenus.printMenuItems(title, menuItems, inputPrompt, "yes");    // Here we send this content to be printed by the Class "Print"

        //  Here we store the max and min choice based on "menuItems":
        int minMenuChoice = 1;
        int maxMenuChoice = menuItems.length;
        int menuChoice = UserInputHandler.inputIntMinMax(minMenuChoice, maxMenuChoice);  // Goes into the MenuHandler class. MenuHandler prints the "prompt" and "mainMenuItems"

        switch (menuChoice) {

            case 1 -> rentAGame();
            case 2 -> returnAGame();
            case 3 -> rentAnAlbum();
            case 4 -> returnAnAlbum();
            case 5 -> findItem();
            case 6 -> sort();
            case 7 -> messageCenterMenu();
            case 8 -> { return; }
        }
        menuCustomer();
    }

    public void rentAGame() {
        itemController.showAllAvailableGames();
        System.out.print("Please enter ID of the game that you want to rent: ");
        String id = UserInputHandler.inputString();
        itemController.rentProcess(customer, id);
    }

    public void rentAnAlbum() {
        itemController.showAllAvailableAlbums();
        System.out.print("Please enter ID of the album that you want to rent: ");
        String id = UserInputHandler.inputString();
        itemController.rentProcess(customer, id);

    }

    public void returnAGame() {
        itemController.showAllGames();
        System.out.print("Insert the ID of the game you wish to return:");
        String id = UserInputHandler.inputString();
        itemController.returnProcess(customer, id);
    }

    public void returnAnAlbum() {
        itemController.showAllAlbums();
        System.out.print("Insert the ID of the album you wish to return:");
        String id = UserInputHandler.inputString();
        itemController.returnProcess(customer, id);

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
        PrintMenus.printMenuItems(title, menuItems, inputPrompt, "yes");

        int menuChoice = UserInputHandler.inputIntMinMax(1, menuItems.length);
        switch (menuChoice) {
            case 1 -> receiveNewMessage();
            case 2 -> sendMessage();
            case 3 -> removeMessage();
            case 4 -> messageController.addMessageToList(
                    "Requesting upgrade from " + customer.getMembership().getMembershipClass() + " membership.",
                    customer.getName(),
                    customer.getId(),
                    null,
                    "employee"
            );
            case 5 -> {
                return;
            }
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
}




