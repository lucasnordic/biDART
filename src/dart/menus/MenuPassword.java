package dart.menus;

import dart.InputOutput;

public class MenuPassword {

    // this menu checks if the password is correct and sends the user to the corresponding menu:
    public void passwordMenu(String menuChoice) {
        System.out.print("Enter a password:");
        String inputPassword = InputOutput.inputString();

        if (menuChoice.equalsIgnoreCase("M")) {
            if (!inputPassword.equals(managerPassword)) {
                System.out.print("Invalid password! ");
                System.out.print("Press any key to continue: ");
                InputOutput.pressAnyKeyCon();
                mainMenu(); // allows go back to menu
            } else {
                managerMenu();
            }
        } else if (menuChoice.equalsIgnoreCase("E")) {
            if (!inputPassword.equals(employeePassword)) {
                System.out.print("Invalid password! ");
                System.out.print("Press any key to continue: ");
                InputOutput.pressAnyKeyCon();
                mainMenu(); // allows go back to menu
            } else {
                employeeMenu();
            }
        }
    }
}
