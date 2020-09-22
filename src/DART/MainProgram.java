// https://www.youtube.com/watch?v=MoXxF3aWW8k&ab_channel=IntelliJIDEAbyJetBrains
// Learn how to GitHub.
package DART;
//package DART.UserRoles;


import DART.UserRoles.Customers;

public class MainProgram {

    private static Customers customerObject = new Customers();

    public static void main(String[] args) {

        System.out.print("Hey dude, Please enter a number: ");

        int userTypedNumber = ScannerInput.inputInt(1, 2);
        System.out.println(userTypedNumber);
        //code here:


        mainMenu(); // Program goes directly into the mainMenu method. This is how we call a void method
    }

    public static void mainMenu() { //  This method handles the main menu contents. It is void so it doesn't return anything

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
        PrintStuff.printMenuItems(title, menuItems, inputPrompt);    // Here we send this content to be printed by the Class "Print"

        String[] validMenuChoice = {"M", "E", "C", "X"};    //  Valid choices for user while in main menu.
        String menuChoice;  // In "menuChoice" we store the choice the user is going to take.

        // Here we go to class "ScannerInput", method "inputValidString".
        // In "inputValidString" we check so that "menuChoice" is equal to "validMenuChoice":
        menuChoice = ScannerInput.inputValidString(validMenuChoice);

        //  Once the user types a correct input we direct users to a menu based on what is stored in "menuChoice":
        if (menuChoice.equalsIgnoreCase("M")) {
            managerMenu();
        } else if (menuChoice.equalsIgnoreCase("E")) {
            employeeMenu();
        } else if (menuChoice.equalsIgnoreCase("C")) {
            customerMenu();
        } else {    // If the user types X we exit the program
            System.out.println("RIP");
            System.exit(0);
        }
    }

    public static void managerMenu() {  //  This method handles the manager menu contents.

        // Here we create the content of the menu:
        String title = "Manager Screen - Type one of the options below:";
        String[] menuItems = { "Add an employee", "View all employees", "Return to Main Menu" };
        String inputPrompt = "Enter choice: ";
        PrintStuff.printMenuItems(title, menuItems, inputPrompt);    // Here we send this content to be printed by the Class "Print"

        //  Here we store the max and min choice of the "menuItems":
        int minMenuChoice = 1;
        int maxMenuChoice = menuItems.length;
        int menuChoice = ScannerInput.inputInt(minMenuChoice, maxMenuChoice);  // these min* and max* goes into the MenuHandler class. MenuHandler prints the "title" and "mainMenuItems"

        switch (menuChoice) {   // Here we go to different menus based on user input.
            case 1 -> mainMenu();
            case 2 -> mainMenu();
            case 3 -> mainMenu();
            default -> System.exit(0);
        }
    }

    public static void employeeMenu () {    //  This method handles the employee menu contents.
        String title = "Employee Screen - Type one of the options below:";
        String[] menuItems = {"Register a game", "Remove a game", "Register a customer",
                "Remove a customer", "Show total rent profit", "View all games", "Return to Main Menu",
        };
        String inputPrompt = "Enter choice: ";

        //  Here we store the max and min choice based on "menuItems":
        int minMenuChoice = 1;
        int maxMenuChoice = menuItems.length;

        System.out.println("Insert password:");
        String password = ScannerInput.inputString();   // Here we call the method "inputString" from the class "ScannerInput" and we say that the password is equal to the input.

        if (password.equals("password123")) {

            PrintStuff.printMenuItems(title, menuItems, inputPrompt);    // Here we send this content to be printed by the Class "Print"

            int menuChoice = ScannerInput.inputInt(minMenuChoice, maxMenuChoice);  // Goes into the MenuHandler class. MenuHandler prints the "prompt" and "mainMenuItems"

            switch (menuChoice) {   // Here we go to different menus based on user input.
                case 1 -> mainMenu();
                case 2 -> mainMenu();
                case 3 -> customerObject.registration();
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

    public static void customerMenu() { //  This method handles the customer menu contents.

        String title = "Customer Screen - Type one of the options below:";
        String[] menuItems = { "Rent a game", "Return a game", "Return to Main Menu" };
        String inputPrompt = "Enter choice: ";
        PrintStuff.printMenuItems(title, menuItems, inputPrompt);    // Here we send this content to be printed by the Class "Print"

        //  Here we store the max and min choice based on "menuItems":
        int minMenuChoice = 1;
        int maxMenuChoice = menuItems.length;
        int menuChoice = ScannerInput.inputInt(minMenuChoice, maxMenuChoice);  // Goes into the MenuHandler class. MenuHandler prints the "prompt" and "mainMenuItems"

        switch (menuChoice) {  // Here we go to different menus based on user input.
            case 1 -> mainMenu();
            case 2 -> mainMenu();
            case 3 -> mainMenu();
            default -> System.exit(0);
        }
    }
}