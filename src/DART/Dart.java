package DART;

import DART.Data.Employee;
import DART.Data.EmployeeLibrary;
import DART.Data.Game;
import DART.Data.GameLibrary;

import java.util.ArrayList;

public class Dart {
    private EmployeeLibrary employeeLibrary = new EmployeeLibrary();
    private static GameLibrary gameLibrary = new GameLibrary();//creating new library for games
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
        printMenuItems(title, menuItems, inputPrompt);    // Here we send this content to be printed by the Class "Print"

        String[] validMenuChoice = {"M", "E", "C", "X"};    //  Valid choices for user while in main menu.
        // In "menuChoice" we store the choice the user is going to take.
        // Here we use the static method "inputValidString" in the class "ScannerInput".
        // In "inputValidString" we check so that "menuChoice" is equal to "validMenuChoice":
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
            default -> System.exit(0);
        }
        managerMenu();
    }

    //This method handles the sub-menu when adding an employee:
    public void addEmployeeInput(){

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

        System.out.println("You added\n" + newEmployee);
        System.out.print("Add employee? ");
        String result = UserInputHandler.inputValidString(new String[]{"Y","N"});

        if (result.equalsIgnoreCase("Y")) {
            employeeLibrary.addEmployee(newEmployee);
        }
    }

    // this method handles showing the employeelist and removing employees:
    public void showEmployeeList() {
        //System.out.println(employeeLibrary.getEmployeeList());
        ArrayList<Employee> list = employeeLibrary.getEmployeeList();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(" ");
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
            // case 3 -> menuRegisterACustomer();
            //case 4 -> menuRemoveACustomer();
            // case 5 -> menuShowTotalRentProfit();
            //case 6 -> menuViewAllGames();
            case 7 -> mainMenu();
            default -> System.exit(0);
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
            case 1 -> mainMenu();
            case 2 -> mainMenu();
            case 3 -> mainMenu();
            default -> System.exit(0);
        }
    }

    //  This right here is our good old menu printer:
    private void printMenuItems(String title, String[] menuItems, String inputPrompt) {

        System.out.println( title );

        for (int i = 0; i < menuItems.length; i++) {    // This loop prints out all the menu options that are stored in the "menuItems" array.
            System.out.println((i + 1) + ". " + menuItems[i]);
        }
        System.out.println(" ");
        System.out.print(inputPrompt);  // This prints the text before the user input. For example, "Enter choice: "
    }

    private static void menuRegisterAGame() {

        Game game = new Game(gameLastNumber++);//creating new game, next id +1
        gameLibrary.addGame(game);// method that allow to add games to library
        System.out.println(gameLastNumber - 1 + " : " + game.getTitle() + " (" + game.getGenre() + "). " + game.getDailyRent() + "$. Status: " + game.getRentStatus()+"\n");

    }

    private static void menuRemoveAGame () {
        System.out.println("Please enter a number of the game you want to remove: ");
        int id = UserInputHandler.inputInt();
        gameLibrary.removeAGame(id);
    }

    //private Game[] games = new Game[1];//array for games
}
