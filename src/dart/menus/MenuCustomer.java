package dart.menus;

import dart.UserInputHandler;
import dart.data.GamesController;
import dart.data.items.Game;

/*
    This class handles every option in the Customer Menu and then redirects the user to sub-menu's or back to Main Menu
 */

public class MenuCustomer {

    private MainMenu mainMenu;

    public void customerMenu() {
        System.out.println("- - - - - - - - - - - - - - - - -");
        System.out.println("Customer Screen - Type one of the options below:");
        String[] menuItems = {
            "Rent a game",
            "Return a game",
            "Change Membership",
            "Return to Main Menu"
        };
        UserInputHandler.printMenuItems(menuItems);
        System.out.print("Enter choice: ");

        int minMenuChoice = 1; //  Here we store the max and min choice based on "menuItems":
        int maxMenuChoice = menuItems.length;
        int menuChoice = UserInputHandler.inputIntMinMax(minMenuChoice, maxMenuChoice);

        switch (menuChoice) { // Here we go to different menus based on user input.
            case 1 -> rentAGame();
            case 2 -> returnAGame();
            case 3 -> menuChangeMembership();
            case 4 -> mainMenu.mainMenu();
        }
    }

    /*
        Sub Menu's:
     */
    private static void rentAGame() {
        GamesController gamesController = new GamesController();
        gamesController.showAvailableGames();

        System.out.print("Please enter game ID that you want to rent: ");
        int gameID = UserInputHandler.inputInt();
        gamesController.rentAGame(gameID);
    }

    private static void returnAGame() {
        GamesController gamesController = new GamesController();

        System.out.print("Please enter game ID that you want to return: ");
        int gameID = UserInputHandler.inputInt();
        Game game = gamesController.find(gameID);// extracting a game from library by game id

        if (game == null) {
            System.out.println("This game was not found!Try again!");
            returnAGame();
        }

        System.out.print("Please enter the number of days in which the game was rented: ");
        int days = UserInputHandler.inputInt();
        double dailyRent = game.getDailyRent();
        double totalRent = dailyRent * days;

        System.out.println("The total rent is " + dailyRent + " * " + days + " = " + totalRent);
        game.makeGameAvailableAgain();
        gamesController.storeDailyRent(totalRent);
    }

    public void menuChangeMembership() {
        
    }
}
