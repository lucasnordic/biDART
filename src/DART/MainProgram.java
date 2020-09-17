// https://www.youtube.com/watch?v=MoXxF3aWW8k&ab_channel=IntelliJIDEAbyJetBrains
// Learn how to GitHub.
package DART;

public class MainProgram {

    public static void main(String[] args) {
        mainMenu(); // Program goes directly into the mainMenu method.
    }

    public static void mainMenu() { //  This method handles the main menu contents.

        // Here we create the content of the menu:
        String title = "Main Menu - Welcome to DART,\n" +
                "your good old game rental system. The competition has no steam to keep up ;)\n\n" +
                "Please specify your role by entering one of the options given:";
        String[] mainMenuItems = {
                "Enter “M” for Manager",
                "Enter “E” for Employee",
                "Enter “C” for Customer",
                "Enter “X” to exit system"
        };
        String inputPrompt = "Enter choice: ";
        Print.printMenuItems(title, mainMenuItems, inputPrompt);    // Here we send this content to be printed by the Class "Print"

        String[] validMenuChoice = {"M", "E", "C", "X"};    //  Valid choices for user while in main menu.
        String menuChoice;  // In "menuChoice" we store the choice the user is going to take.

        // Here we go to class "ScannerInput" and later method "inputValidString".
        // In "inputValidString" we check so that "menuChoice" is equal to "validMenuChoice"
        menuChoice = ScannerInput.inputValidString(validMenuChoice);

        //  We direct users to a menu based on string stored in "menuChoice"
        if (menuChoice.equalsIgnoreCase("M")) {
            managerMenu();
        } else if (menuChoice.equalsIgnoreCase("E")) {
            employeeMenu();
        } else if (menuChoice.equalsIgnoreCase("C")) {
            customerMenu();
        } else {
            System.out.println("RIP");
            System.exit(0);
        }
    }

    //  This method handles the manager menu contents.
    public static void managerMenu() {

        // I create a title, mainMenuItems, inputPrompt and a variable to store the menu choice.
        String title = "Manager Screen - Type one of the options below:";
        String[] menuItems = { "Add an employee", "View all employees", "Return to Main Menu" };
        String inputPrompt = "Enter choice: ";
        Print.printMenuItems(title, menuItems, inputPrompt);    // Here we send this content to be printed by the Class "Print"

        //  Here we store the max and min choice:
        int minMenuChoice = 1;
        int maxMenuChoice = menuItems.length;
        int menuChoice = ScannerInput.inputInt(minMenuChoice, maxMenuChoice);  // Goes into the MenuHandler class. MenuHandler prints the "prompt" and "mainMenuItems"

        switch (menuChoice) {
            case 1 -> mainMenu();
            case 2 -> mainMenu();
            case 3 -> mainMenu();
            default -> System.exit(0);
        }
    }

    //  This method handles the employee menu contents.
    public static void employeeMenu () {
        String title = "Employee Screen - Type one of the options below:";
        String[] employeeMenuItems = {"Register a game", "Remove a game", "Register a customer",
                "Remove a customer", "Show total rent profit", "View all games", "Return to Main Menu",
        };
        String inputPrompt = "Enter choice: ";
        //  Here we store the max and min choice:
        int minMenuChoice = 1;
        int maxMenuChoice = employeeMenuItems.length;

        System.out.println("Insert password:");
        String password = ScannerInput.inputString();

        if (password.equals("password123")) {

            Print.printMenuItems(title, employeeMenuItems, inputPrompt);    // Here we send this content to be printed by the Class "Print"

            int menuChoice = ScannerInput.inputInt(minMenuChoice, maxMenuChoice);  // Goes into the MenuHandler class. MenuHandler prints the "prompt" and "mainMenuItems"

            switch (menuChoice) {
                case 1 -> mainMenu();
                case 2 -> mainMenu();
                case 3 -> mainMenu();
                case 4 -> mainMenu();
                case 5 -> mainMenu();
                case 6 -> mainMenu();
                case 7 -> mainMenu();
                default -> System.exit(0);
            }
        } else {
            System.out.println("INVALID PASSWORD");
            System.out.println(" ");
            mainMenu();
        }
    }

    //  This method handles the customer menu contents.
    public static void customerMenu() {

        String title = "Customer Screen - Type one of the options below:";
        String[] menuItems = { "Rent a game", "Return a game", "Return to Main Menu" };
        String inputPrompt = "Enter choice: ";
        Print.printMenuItems(title, menuItems, inputPrompt);    // Here we send this content to be printed by the Class "Print"

        //  Here we store the max and min choice:
        int minMenuChoice = 1;
        int maxMenuChoice = menuItems.length;
        int menuChoice = ScannerInput.inputInt(minMenuChoice, maxMenuChoice);  // Goes into the MenuHandler class. MenuHandler prints the "prompt" and "mainMenuItems"

        switch (menuChoice) {
            case 1 -> mainMenu();
            case 2 -> mainMenu();
            case 3 -> mainMenu();
            default -> System.exit(0);
        }
    }
}