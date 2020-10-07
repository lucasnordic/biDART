package dart.menus;

import dart.UserInputHandler;

/*
    This class Handles redirecting users depending on the password they enter
 */

public class MenuPassword {

    private MainMenu mainMenu;
    private MenuEmployee menuEmployee;
    private MenuManager menuManager;
    private static String managerPassword = "admin1234";
    private static String employeePassword = "password123";

    // this menu checks if the password is correct and sends the user to the corresponding menu:
    public void passwordMenu(String menuChoice) {
        System.out.print("Enter a password:");
        String inputPassword = UserInputHandler.inputString();

        if (menuChoice.equalsIgnoreCase("M")) {
            if (!inputPassword.equals(managerPassword)) {
                System.out.print("Invalid password! ");
                System.out.print("Press any key to continue: ");
                UserInputHandler.pressAnyKeyCon();
                mainMenu.mainMenu(); // allows go back to menu
            } else {
                MenuManager menuManager = new MenuManager();
                menuManager.managerMenu();
            }
        } else if (menuChoice.equalsIgnoreCase("E")) {
            if (!inputPassword.equals(employeePassword)) {
                System.out.print("Invalid password! ");
                System.out.print("Press any key to continue: ");
                UserInputHandler.pressAnyKeyCon();
                mainMenu.mainMenu(); // allows go back to menu
            } else {
                menuEmployee.employeeMenu();
            }
        }
    }
}
