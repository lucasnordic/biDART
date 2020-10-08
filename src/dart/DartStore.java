package dart;

import dart.UserInputHandler;

/*
    This shows the structure of the menu's
 */

public class DartStore {

    public void dartStore() {

        MenuInterface.mainMenu();

        String[] validMenuChoice = {"M", "E", "C", "X"};
        String mainMenuChoice = UserInputHandler.inputValidString(validMenuChoice);

        UserInputHandler.passwordHandling(mainMenuChoice);
    }

    // this menu checks if the password is correct and sends the user to the corresponding menu:
    public static void passwordHandling(String menuChoice) {

        System.out.print("Enter a password:");
        String inputPassword = UserInputHandler.inputString();

        if (menuChoice.equalsIgnoreCase("M")) {
            if (!inputPassword.equals(managerPassword)) {
                System.out.print("Invalid password! ");
                UserInputHandler.pressAnyKeyCon();

                mainMenu.mainMenu(); // allows go back to menu
            } else {
                MenuManager menuManager = new MenuManager();
                menuManager.managerMenu();
            }
        } else if (menuChoice.equalsIgnoreCase("E")) {
            if (!inputPassword.equals(employeePassword)) {
                System.out.print("Invalid password! ");
                UserInputHandler.pressAnyKeyCon();

                mainMenu.mainMenu(); // allows go back to menu
            } else {
                menuEmployee.employeeMenu();
            }
        }
    }

    public void subMenus(mainMenuChoice) {
        int minMenuChoice = 1; //  Here we store the max and min choice based on "menuItems":
        int maxMenuChoice = menuItems.length;
        int subMenuChoice = UserInputHandler.inputIntMinMax(minMenuChoice, maxMenuChoice); // Here we let the user input a number between a min and max value.

        if () {
            switch (mainMenuChoice.equalsIgnoreCase("M")) { // Here we go to different menus based on user input.
                case 1 -> AddEmployee();
                case 2 -> ShowEmployeeList();
                case 3 -> RemoveEmployee();
                case 4 -> ViewNetSalary();
                case 5 -> dartStore();
            }
        } else if(mainMenuChoice.equalsIgnoreCase("E")) {

            switch (menuChoice) { // Here we go to different menus based on users input.
                case 1 -> menuRegisterAGame();
                case 2 -> menuRemoveAGame();
                case 3 -> menuNewCustomer();
                case 4 -> menuRemoveCustomer();
                case 5 -> gamesController.menuShowTotalRentProfit();
                case 6 -> gamesController.showAllGames();
                case 7 -> dartStore();
            }
        } else if(mainMenuChoice.equalsIgnoreCase("C")) {

            switch (menuChoice) { // Here we go to different menus based on user input.
                case 1 -> rentAGame();
                case 2 -> returnAGame();
                case 3 -> menuChangeMembership();
                case 4 -> dartStore();
            }
        } else if (mainMenuChoice.equalsIgnoreCase("X")){

            UserInputHandler.closeScanner();
        }
    }


}