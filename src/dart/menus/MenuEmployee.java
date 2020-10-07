package dart.menus;

import dart.InputOutput;

public class MenuEmployee {
    //  This handles the employee menu contents:
    public void employeeMenu() {
        System.out.println("- - - - - - - - - - - - - - - - -");
        //  Here we store the menu content:
        String title = "Employee Screen - Type one of the options below:";
        String[] menuItems = {
                "Register a game",
                "Remove a game",
                "Register a customer",
                "Remove a customer",
                "Show total rent profit",
                "View all games",
                "Return to Main Menu",
        };
        String inputPrompt = "Enter choice: ";

        //  Here we store the max and min choice based on "menuItems":
        int minMenuChoice = 1;
        int maxMenuChoice = menuItems.length;

        // Here we send the menu content to be printed:
        InputOutput.printMenuItems(title, menuItems, inputPrompt);

        // Here we let the user input a number between the choices available based on the size of the menuItems array:
        int menuChoice = InputOutput.inputIntMinMax(minMenuChoice, maxMenuChoice);

        // Here we go to different menus based on users input.
        switch (menuChoice) {
//            case 1 -> menuRegisterAGame();
//            case 2 -> menuRemoveAGame();
//            case 3 -> manager.registration();
//            case 4 -> manager.cancellation();
            case 5 -> gameLibrary.menuShowTotalRentProfit();
            case 6 -> gameLibrary.showAllGames();
            case 7 -> mainMenu();
            //default -> System.exit(0);
        }
        employeeMenu();
    }

//    private static void menuRegisterAGame() {
//
//        Game game = new Game(gameLastNumber++);//creating new game, next id +1
//        gameLibrary.addGame(game);// method that allow to add games to library
//        System.out.println(gameLastNumber - 1 + " : " + game.getTitle() + " (" + game.getGenre() + "). " + game.getDailyRent() + "$. Status: " + game.getRentStatus() + "\n");
//
//    }

//    private static void menuRemoveAGame() {
//        System.out.print("Please enter a number of the game you want to remove: ");
//        int id = UserInputHandler.inputInt();
//        gameLibrary.removeGame(id);
//    }
//
//    private static void rentAGame() {
//        gameLibrary.showAvailableGames();
//        System.out.print("Please enter game ID that you want to rent: ");
//        int gameID = UserInputHandler.inputInt();
//        gameLibrary.rentAGame(gameID);
//    }
//
//    private static void returnAGame() {
//        System.out.print("Please enter game ID that you want to return: ");
//        int gameID = UserInputHandler.inputInt();
//        Game game = gameLibrary.find(gameID);// extracting a game from library by game id
//        if (game == null) {
//            System.out.println("This game was not found!Try again!");
//            returnAGame();
//        }
//        System.out.print("Please enter the number of days in which the game was rented: ");
//        int days = UserInputHandler.inputInt();
//        double dailyRent = game.getDailyRent();
//        double totalRent = dailyRent * days;
//        System.out.println("The total rent is "+ dailyRent+" * "+days+" = "+totalRent);
//        game.makeGameAvailableAgain();
//        gameLibrary.storeDailyRent(totalRent);
//    }



}
