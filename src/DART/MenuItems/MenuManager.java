package DART.MenuItems;

import DART.HandlePrinting;
import java.util.Scanner;

public class MenuManager {

    public static void managerMenu(Scanner input) {

        // I create a title, mainMenuItems, inputPrompt and a variable to store the menu choice.
        String prompt = "Manager Screen - Type one of the options below:";
        String[] mainMenuItems = {
                "Add an employee",
                "View all employees",
                "Return to Main Menu"
        };
        String inputPrompt = "Enter choice: ";
        int choice = 0;

        // If the choice is greater than 4 or lesser than 1 then we keep going in the loop.
        // if the user types a valid number then we go to:
        // Menuhandler and print "mainMenuItems, title, inputPrompt and we ask the user for input.
        while (choice < 4) {
            choice = HandlePrinting.chooseFromMenu(input, mainMenuItems, prompt, inputPrompt);
            handleMenuChoice(input, choice);
        }
    }

    public static void handleMenuChoice (Scanner input, int menuChoice ) {
        switch (menuChoice) {
            case 1 -> MenuManager.managerMenu(input);
            case 2 -> MenuEmployee.employeeMenu(input);
            case 3 -> MenuMain.mainMenu(input);
            default -> System.out.println("Please Choose a correct number: ");
        }
    }
}