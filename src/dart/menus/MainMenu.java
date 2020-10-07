package dart.menus;

import dart.UserInputHandler;

/*
    This class handles every option in the Main Menu and then redirects the user to sub-menu's
 */

public class MainMenu {

    private MenuManager menuManager;
    private MenuEmployee menuEmployee;
    private MenuCustomer menuCustomer;

    public void mainMenu() {

        System.out.println("- - - - - - - - - - - - - - - - -");
        System.out.println(
            "Main Menu - Welcome to DART,\n" +
            "your good old game rental system. The competition has no steam to keep up! ;)\n\n" +
            "Please specify your role by entering one of the options given:"
        );
        System.out.println(
            "1. Enter “M” for Manager\n" +
            "2. Enter “E” for Employee\n" +
            "3. Enter “C” for Customer\n" +
            "4. Enter “X” to exit system\n"
        );

        System.out.println("Choose menu: ");
        String[] validMenuChoice = {"M", "E", "C", "X"};
        String menuChoice = UserInputHandler.inputValidString(validMenuChoice); // We store the choice the user is going to take:

        if (menuChoice.equalsIgnoreCase("M")) { //  We direct users to a menu based on what is stored in "menuChoice".
            menuManager.managerMenu();
        } else if (menuChoice.equalsIgnoreCase("E")) {
            menuEmployee.employeeMenu();
        } else if (menuChoice.equalsIgnoreCase("C")) {
            menuCustomer.customerMenu();
        } else if (menuChoice.equalsIgnoreCase("X")){
            UserInputHandler.closeScanner();
        }
    }
}