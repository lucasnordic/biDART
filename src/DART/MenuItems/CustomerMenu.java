package DART.MenuItems;

import DART.MenuHandler;
import java.util.Scanner;

public class CustomerMenu {

    public static void customerMenu(Scanner input) {

        // I create a title, mainMenuItems, inputPrompt and a variable to store the menu choice.
        String prompt = "Customer Screen - Type one of the options below:";
        String[] mainMenuItems = {
                "Rent a game",
                "Return a game",
                "Return to Main Menu"
        };
        String inputPrompt = "Enter choice: ";
        int choice = 0;

        // If the choice is greater than 4 or lesser than 1 then we keep going in the loop.
        // if the user types a valid number then we go to:
        // Menuhandler and print "mainMenuItems, title, inputPrompt and we ask the user for input.
        while (choice < 4) {
            choice = MenuHandler.chooseFromMenu(input, mainMenuItems, prompt, inputPrompt);
            handleMenuChoice(input, choice);
        }
    }

    public static void handleMenuChoice (Scanner input, int menuChoice ) {
        switch (menuChoice) {
            case 1 -> ManagerMenu.managerMenu(input);
            case 2 -> EmployeeMenu.employeeMenu(input);
            case 3 -> MainMenu.mainMenu(input);
            default -> System.out.println("Please Choose a correct number: ");
        }
    }
}
