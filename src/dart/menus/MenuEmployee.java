package dart.menus;

import dart.UserInputHandler;
import dart.data.GamesController;
import dart.data.items.Game;
import dart.data.users.Customer;

/*
    This class handles every option in the Employee Menu and then redirects the user to sub-menu's or back to Main Menu
 */

public class MenuEmployee {

    private MainMenu mainMenu;
    private GamesController gamesController;

    //  This handles the employee menu contents:
    public void employeeMenu() {
        System.out.println("- - - - - - - - - - - - - - - - -");
        System.out.println("Employee Screen - Type one of the options below:");
        String[] menuItems = {
                "Register a game",
                "Remove a game",
                "Register a customer",
                "Remove a customer",
                "Show total rent profit",
                "View all games",
                "Return to Main Menu",
        };
        UserInputHandler.printMenuItems(menuItems);  // Here we send the menuItems content to be printed
        System.out.println("Enter choice: ");

        int minMenuChoice = 1; //  Here we store the max and min choice based on "menuItems":
        int maxMenuChoice = menuItems.length;
        int menuChoice = UserInputHandler.inputIntMinMax(minMenuChoice, maxMenuChoice); // Here we let the user input a number between a min and max value.

        switch (menuChoice) { // Here we go to different menus based on users input.
            case 1 -> menuRegisterAGame();
            case 2 -> menuRemoveAGame();
            case 3 -> menuNewCustomer();
            case 4 -> menuRemoveCustomer();
            case 5 -> gamesController.menuShowTotalRentProfit();
            case 6 -> gamesController.showAllGames();
            case 7 -> mainMenu.mainMenu();
        }
    }

    private static void menuRegisterAGame() {


        System.out.print("Please enter title of a game: ");
        name = UserInputHandler.inputString();
        System.out.print("Please enter genre of a game: ");
        genre = UserInputHandler.inputString();
        System.out.print("Please enter daily rent of a game: ");
        dailyRent = UserInputHandler.inputDouble();
        Game game = new Game();

        System.out.print("Rent status: " + rentStatus);
        System.out.println("\nYou created a new game. Game ID " + id + "!" );
        Game game = new Game(gameLastNumber++);//creating new game, next id +1
        gameLibrary.addGame(game);// method that allow to add games to library
        System.out.println(
                gameLastNumber - 1 + " : " + game.getTitle() + " (" + game.getGenre() + "). " + game.getDailyRent() + "$. Status: " + game.getRentStatus() + "\n");

    }

    private static void menuRemoveAGame() {
        System.out.print("Please enter a number of the game you want to remove: ");
        int id = UserInputHandler.inputInt();
        gameLibrary.removeGame(id);
    }

    public void menuNewCustomer() {
        System.out.print("Creating a Customer. Please type the customer’s:\nName: ");
        String name = UserInputHandler.inputString();

        Customer customer = new Customer(name, "regular");
        customer.setName(name);

        customerList.addCustomer();
        System.out.println(customerList);
    }

    public void menuRemoveCustomer() {
        customerList.getCustomers();

        System.out.println("Which customer should be removed? ID:");
        int ID = UserInputHandler.inputInt();

        for (int i = 0; i < customerList.getSize(); i++) {

            int a = (customerList.get(i)).getId();

            if (a == ID) {

                customerList.removeCustomer(i);
                System.out.println(customerList);
            } else {
                System.out.println("Customer's ID not found");
            }
        }
    }
}
