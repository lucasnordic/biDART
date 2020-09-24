package DART;

import DART.Data.*;

import java.util.ArrayList;

/*
    Todo:    "2.2" - remove employee
    Todo:    "2.3" - Net salary
    Todo:    "3.0" - A game Array
    Todo:    "3.2" - Remove a game
    Todo:    "4.0" - A customer Array
    Todo:    "4.1" - Create a customer
    Todo:    "4.2" - Remove a customer
    Todo:    "5.2" - Can't do before 4.0 is done
    Todo:    "5.3" - Can't do before 3.0 is done
    Todo:    "6.1"
    Todo:    "6.2"
    Todo:    "6.3"
    Todo:    "VG feature 1: UUID for Employees, Games and Customers"
    Todo:    "VG feature 2: Rent based on date"
 */

public class Dart {
    private Customers customers = new Customers();
    private EmployeeLibrary employeeLibrary = new EmployeeLibrary();
    private static GameLibrary2 gameLibrary = new GameLibrary2();//creating new library for games
    private static String managerPassword = "admin123";
    private static String employeePassword = "password123";
    private static int gameLastNumber = 1;

    // This method handles the main menu contents:
    public void mainMenu() {
        // Here we create the content of the menu in two strings and the menu options in one string array:
        String title = "Main Menu - Welcome to DART,\n" +
                "your good old game rental system. The competition has no steam to keep up ;)\n\n" +
                "Please specify your role by entering one of the options given:";
        String[] menuItems = {
                "Enter “M” for Manager",
                "Enter “E” for Employee",
                "Enter “C” for Customer",
                "Enter “X” to exit system"
        };
        String inputPrompt = "Enter choice: ";

        // Here we send this content to be printed by the Class "Print"
        printMenuItems(title, menuItems, inputPrompt);

        //  Valid choices for user while in main menu.
        String[] validMenuChoice = {"M", "E", "C", "X"};

        // We store the choice the user is going to take.
        String menuChoice = UserInputHandler.inputValidString(validMenuChoice);

        //  Once the user types a correct input we direct users to a menu based on what is stored in "menuChoice":
        if (menuChoice.equalsIgnoreCase("M")) {

            System.out.println("Enter a password:");
            String inputPasswordMa = UserInputHandler.inputString();
            System.out.println(" ");
            if (!inputPasswordMa.equals(managerPassword)) {
                System.out.println("Invalid password!\n" +
                        "Please try again.");
                mainMenu(); // allows go back to menu
            }
            managerMenu();
        } else if (menuChoice.equalsIgnoreCase("E")) {
            System.out.println("Enter a password:");
            System.out.println(" ");
            String inputPasswordEm = UserInputHandler.inputString();
            if (!inputPasswordEm.equals(employeePassword)) {
                System.out.println("Invalid password!\n" +
                        "Please try again.");
                mainMenu(); // allows go back to menu
            }
            employeeMenu();
        } else if (menuChoice.equalsIgnoreCase("C")) {
            customerMenu();
        } else {    // If the user types X we exit the program
            System.out.println("RIP");
        }
    }

    //  This method handles the manager menu contents:
    public void managerMenu() {

        // Here we create the content of the menu:
        String title = "Manager Screen - Type one of the options below:";
        String[] menuItems = {"Add an employee", "View all employees", "Return to Main Menu"};
        String inputPrompt = "Enter choice: ";

        //  Here we store the max and min choice of the "menuItems":
        int minMenuChoice = 1;
        int maxMenuChoice = menuItems.length;
        int menuChoice;

        // Here we send this content to be printed:
        printMenuItems(title, menuItems, inputPrompt);

        // Here we let the user input a number between the choices available based on the size of the menuItems array:
        menuChoice = UserInputHandler.inputIntMinMax(minMenuChoice, maxMenuChoice);

        // Here we go to different menus based on user input:
        switch (menuChoice) {
            case 1 -> addEmployeeInput();
            case 2 -> showEmployeeList();
            case 3 -> mainMenu();
            //default -> System.exit(0);
        }
        // We go back to the same method we are in.
        managerMenu();
    }

    //This method handles the sub-menu when adding an employee:
    public void addEmployeeInput() {

        System.out.print("Type employee's name: ");
        String employeeName = UserInputHandler.inputString();

        System.out.print("Type employee's birth year: ");
        int employeeBirthYear = UserInputHandler.inputInt();

        System.out.print("Type employee's gross salary: ");
        double employeeGrossSalary = UserInputHandler.inputDouble();

        Employee newEmployee = employeeLibrary.createEmployee(
                employeeName,
                employeeBirthYear,
                employeeGrossSalary
        );

        System.out.println("You added: " + employeeName);
        System.out.println(" ");
//        System.out.print("Add employee? ");
//        String result = UserInputHandler.inputValidString(new String[]{"Y","N"});

//        if (result.equalsIgnoreCase("Y")) {
//            employeeLibrary.addEmployee(newEmployee);
//        }
    }

    // this method handles showing the employeelist and removing employees:
    public void showEmployeeList() {
        //System.out.println(employeeLibrary.getEmployeeList());
        ArrayList<Employee> list = employeeLibrary.getEmployeeList();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
//        System.out.println(" ");
        UserInputHandler.inputString();

    }

    //  This handles the employee menu contents:
    public void employeeMenu() {
        //  Here we store the menu content:
        String title = "Employee Screen - Type one of the options below:";
        String[] menuItems = {"Register a game", "Remove a game", "Register a customer",
                "Remove a customer", "Show total rent profit", "View all games", "Return to Main Menu",
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
            case 1 -> menuRegisterAGame();
            case 2 -> menuRemoveAGame();
            case 3 -> customers.registration();
            //case 4 -> menuRemoveACustomer();
            // case 5 -> menuShowTotalRentProfit();
            case 6 -> gameLibrary.showAllGames();
            case 7 -> mainMenu();
            //default -> System.exit(0);
        }
        employeeMenu();
    }

    //  This method handles the customer menu contents:
    public void customerMenu() {

        String title = "Customer Screen - Type one of the options below:";
        String[] menuItems = {"Rent a game", "Return a game", "Return to Main Menu"};
        String inputPrompt = "Enter choice: ";
        printMenuItems(title, menuItems, inputPrompt);    // Here we send this content to be printed by the Class "Print"

        //  Here we store the max and min choice based on "menuItems":
        int minMenuChoice = 1;
        int maxMenuChoice = menuItems.length;
        int menuChoice = UserInputHandler.inputIntMinMax(minMenuChoice, maxMenuChoice);  // Goes into the MenuHandler class. MenuHandler prints the "prompt" and "mainMenuItems"

        switch (menuChoice) {  // Here we go to different menus based on user input.
            case 1 -> rentAGame();
            case 2 -> returnAGame();
            case 3 -> mainMenu();
            //default -> System.exit(0);
        }
        customerMenu();
    }

    //  This right here is our good old menu printer:
    private void printMenuItems(String title, String[] menuItems, String inputPrompt) {

        System.out.println(title);

        for (int i = 0; i < menuItems.length; i++) {    // This loop prints out all the menu options that are stored in the "menuItems" array.
            System.out.println((i + 1) + ". " + menuItems[i]);
        }
        System.out.println(" ");
        System.out.print(inputPrompt);  // This prints the text before the user input. For example, "Enter choice: "
    }

    private static void menuRegisterAGame() {

        Game game = new Game(gameLastNumber++);//creating new game, next id +1
        gameLibrary.addGame(game);// method that allow to add games to library
        System.out.println(gameLastNumber - 1 + " : " + game.getTitle() + " (" + game.getGenre() + "). " + game.getDailyRent() + "$. Status: " + game.getRentStatus() + "\n");

    }

    private static void menuRemoveAGame() {
        System.out.println("Please enter a number of the game you want to remove: ");
        int id = UserInputHandler.inputInt();
        gameLibrary.removeGame(id);
    }

    private static void rentAGame() {
        gameLibrary.showAvailableGames();
        System.out.println("Please enter game ID that you want to rent: ");
        int gameID = UserInputHandler.inputInt();
        gameLibrary.rentAGame(gameID);
    }

    private static void returnAGame() {
        System.out.println("Please enter game ID that you want to return: ");
        int gameID = UserInputHandler.inputInt();
        Game game = gameLibrary.find(gameID);// extracting a game from library by game id
        if (game == null) {
            System.out.println("This game was not found!Try again!");
            return;
        }
        System.out.println("Please enter the number of days in which the game was rented ");
        int days = UserInputHandler.inputInt();
        double dailyRent = game.getDailyRent();
        double totalRent = dailyRent * days;
        System.out.println("The total rent is"+ dailyRent+"*"+days+"="+totalRent);
        game.makeGameAvailableAgain();
    }


    //private Game[] games = new Game[1];//array for games
}
