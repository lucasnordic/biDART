package dart;

public class MenuInterface {
    public static void mainMenu() {
        System.out.println("- - - - - - - - - - - - - - - - -");
        System.out.println(
                "Main Menu - Welcome to DART,\n" +
                "your good old game rental system. The competition has no steam to keep up! ;)\n\n" +
                "Please specify your role by entering one of the options given:"
        );
        String[] menuItems = {
                "1. Enter “M” for Manager\n" +
                "2. Enter “E” for Employee\n" +
                "3. Enter “C” for Customer\n" +
                "4. Enter “X” to exit system\n"
        };
        printMenuItems(menuItems);
        System.out.println("Choose menu: ");
    }

    public static void managerMenu() {    //  This method handles the manager menu contents:
        System.out.println("Manager Screen - Type one of the options below:");
        String[] menuItems = {
                "Add an employee",
                "View all employees",
                "Remove an employee",
                "View Net Salary",
                "Return to Main Menu"
        };
        printMenuItems(menuItems); // Here we send this content to be printed
        System.out.print("Enter choice: ");
    }

    public static void employeeMenu() {
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
        printMenuItems(menuItems);  // Here we send the menuItems content to be printed
        System.out.println("Enter choice: ");
    }

    public static void customerMenu() {
        System.out.println("- - - - - - - - - - - - - - - - -");
        System.out.println("Customer Screen - Type one of the options below:");
        String[] menuItems = {
                "Rent a game",
                "Return a game",
                "Change Membership",
                "Return to Main Menu"
        };
        printMenuItems(menuItems);
        System.out.print("Enter choice: ");
    }

    // This loop prints out all the menu options that are stored in the "menuItems" array.
    public static void printMenuItems(String[] menuItems) {
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ". " + menuItems[i]);
        }
    }
}
