package DART;

import DART.Data.*;

import java.util.ArrayList;

/*
    Todo:                   "2.3" - Net salary?"
    Todo:                   "6.3" - "Show total rent profit?" - Employee screen
    Todo:                   "VG feature 2: Rent based on date"
 */

public class Dart {
    private Customers customers = new Customers();
    private EmployeeLibrary employeeLibrary = new EmployeeLibrary(); // The Library will exist as long as the Dart program is running.
    private static GameLibrary2 gameLibrary = new GameLibrary2();  //creating new library for games
    private static String managerPassword = "admin123";
    private static String employeePassword = "password123";
    private static int gameLastNumber = 1;

    // This method handles the main menu contents:
    public void mainMenu() {
        mockData(); // Only for testing purposes. Added a mockData method at the bottom
        System.out.println("- - - - - - - - - - - - - - - - -");
        // Here we create the content of the menu in two strings and the menu options in one string array:
        String title = "Main Menu - Welcome to DART,\n" +
                "your good old game rental system. The competition has no steam to keep up! ;)\n\n" +
                "Please specify your role by entering one of the options given:";
        String[] menuItems = {
                "Enter “M” for Manager",
                "Enter “E” for Employee",
                "Enter “C” for Customer",
                "Enter “X” to exit system"
        };
        String inputPrompt = "Choose menu: ";

        // Here we send this content to be printed by the Class "Print"
        printMenuItems(title, menuItems, inputPrompt);

        //  Valid choices for user while in main menu.
        String[] validMenuChoice = {"M", "E", "C", "X", "Z"};

        // We store the choice the user is going to take.
        String menuChoice = UserInputHandler.inputValidString(validMenuChoice);

        //  Once the user types a correct input we direct users to a menu based on what is stored in "menuChoice":
        if (menuChoice.equalsIgnoreCase("M")) {
            passwordMenu(menuChoice);
            managerMenu();
        } else if (menuChoice.equalsIgnoreCase("E")) {
            passwordMenu(menuChoice);
            employeeMenu();
        } else if (menuChoice.equalsIgnoreCase("C")) {
            customerMenu();
        } else if (menuChoice.equalsIgnoreCase("Z")) {
            // UserInputHandler.setInputStream(System.in);
        } else {
            printOutroAscii();
            //System.out.println("RIP");
        }
    }

    //  This method handles the manager menu contents:
    public void managerMenu() {
        System.out.println("- - - - - - - - - - - - - - - - -");
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
            case 1 -> menuAddEmployee();
            case 2 -> {
                menuShowEmployeeList();
                System.out.print("Press any key to continue...");
                UserInputHandler.pressAnyKeyCon();
            }
            case 3 -> menuRemoveEmployee();
            case 4 -> mainMenu();
        }
        // We go back to the same method we are in.
        managerMenu();
    }

    //This method handles the sub-menu when adding an employee:
    public void menuAddEmployee() {

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

        // Here we add the new employee to the employee arrayList:
        employeeLibrary.addEmployee(newEmployee);

        System.out.println("You added: " + newEmployee);
        System.out.println(" ");

    }

    // this method handles showing the employeelist
    public void menuShowEmployeeList() {
        ArrayList<Employee> list = employeeLibrary.getEmployeeList();


        // Prints the list of employees:
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    // This method handles removing employees:
    public void menuRemoveEmployee() {
        ArrayList<Employee> list = employeeLibrary.getEmployeeList();
        Employee foundEmployee = null;

        System.out.println(" ");
        menuShowEmployeeList();

        while (foundEmployee == null) {
            System.out.println("Which employee should be removed? Please enter an ID or NAME: ");
            String input = UserInputHandler.inputString();

            int count = 0;
            for (int i = 0; i < list.size() && count < 2; i++) {
                Employee e = list.get(i);

                if (e.getId().startsWith(input) || e.getName().startsWith(input)) {
                    count++;
                    foundEmployee = e;
                }
            }
            if (count > 1) {
                System.out.print("Not a Unique ID, try again. ");
                foundEmployee = null;
            }
        }
        employeeLibrary.removeEmployee(foundEmployee);
        System.out.println("Employee removed");
    }

    //  This handles the employee menu contents:
    public void employeeMenu() {
        System.out.println("- - - - - - - - - - - - - - - - -");
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
            case 4 -> customers.cancellation();
            // case 5 -> menuShowTotalRentProfit();
            case 6 -> gameLibrary.showAllGames();
            case 7 -> mainMenu();
            //default -> System.exit(0);
        }
        employeeMenu();
    }

    //  This method handles the customer menu contents:
    public void customerMenu() {
        System.out.println("- - - - - - - - - - - - - - - - -");
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

    public void passwordMenu(String menuChoice) {
        System.out.print("Enter a password:");
        String inputPassword = UserInputHandler.inputString();

        if (menuChoice.equalsIgnoreCase("M")) {
            if (!inputPassword.equals(managerPassword)) {
                System.out.print("Invalid password! ");
                System.out.print("Press any key to continue: ");
                UserInputHandler.pressAnyKeyCon();
                mainMenu(); // allows go back to menu
            } else {
                managerMenu();
            }
        } else if (menuChoice.equalsIgnoreCase("E")) {
            if (!inputPassword.equals(employeePassword)) {
                System.out.print("Invalid password! ");
                System.out.print("Press any key to continue: ");
                UserInputHandler.pressAnyKeyCon();
                mainMenu(); // allows go back to menu
            } else {
                employeeMenu();
            }

        }

    }

    //  This right here is our good old menu printer:
    private void printMenuItems(String title, String[] menuItems, String inputPrompt) {

        System.out.println(title);

        // This loop prints out all the menu options that are stored in the "menuItems" array.
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ". " + menuItems[i]);
        }
        System.out.println(" ");
        System.out.print(inputPrompt);
    }

    public static void printIntroAscii() {
//        System.out.println("- - - - - - - - - - - - - - - - -");
        System.out.println(" _   _ ____  _____ _____ _____ \n" +
                "| |_|_|    \\|  _  | __  |_   _|\n" +
                "| . | |  |  |     |    -| | |  \n" +
                "|___|_|____/|__|__|__|__| |_|  ");
      // System.out.println("- - - - - - - - - - - - - - - - - -");
    }

    private static void printOutroAscii () {
        System.out.println("- - - - - - - - - - - - -");
        System.out.println("                       _   \n" +
                " _____            _   |_|_ \n" +
                "| __  |_ _ ___   |_|    | |\n" +
                "| __ -| | | -_|   _     | |\n" +
                "|_____|_  |___|  |_|   _|_|\n" +
                "      |___|           |_|  ");
//        System.out.println("- - - - - - - - - - - - -");
    }

    private void mockData() {
        employeeLibrary.addEmployee(new Employee("Anwar", 2010, 10));
        employeeLibrary.addEmployee(new Employee("Lucas", 1990, 100));
        employeeLibrary.addEmployee(new Employee("Maryam", 1930, 1000));
        employeeLibrary.addEmployee(new Employee("Deba", 309, 10000));
        employeeLibrary.addEmployee(new Employee("Olga", 1769, 100000));
        employeeLibrary.addEmployee(new Employee("J-man", 0, 0));
    }

    //private Game[] games = new Game[1];//array for games
}
