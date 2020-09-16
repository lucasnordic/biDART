package DART.MenuItems;

import DART.HandlePrinting;
import java.util.Scanner;

// This class handles the main menu.
public class MenuMain {

    //  This method handles creating all the information the MenuHandler needs to print.
    public static void mainMenu(Scanner input) {

        // I create a title, mainMenuItems, inputPrompt
        // I also create a variable, "menuChoice", to store the menu choice.
        String title = "Main Menu - Welcome to DART,\n" +
                "your good old game rental system. The competition has no steam to keep up ;)\n\n" +
                "Please specify your role by entering one of the options given:";
        String[] mainMenuItems = {
                "Go to Manager menu",
                "Go to Employee menu",
                "Go to Customer menu",
                "Exit system"
        };
        String inputPrompt = "Enter choice: ";
        int menuChoice = 0;

        // If the choice is greater than 4 or lesser than 1 then we keep going in the loop.
        // if the user types a valid number then we go to:
        // Menuhandler and print "mainMenuItems, title, inputPrompt and we ask the user for input.
        while (menuChoice < 1 || menuChoice > mainMenuItems.length) {
            menuChoice = HandlePrinting.chooseFromMenu(input, mainMenuItems, title, inputPrompt);

            //  Here we go to the method "handleMenuChoice" to check which menu we should go to.
            handleMenuChoice(input, menuChoice);
        }
    }

    //  Here we check the
    public static void handleMenuChoice (Scanner input, int menuChoice ) {
        switch (menuChoice) {
            case 1 -> MenuManager.managerMenu(input);
            case 2 -> MenuEmployee.employeeMenu(input);
            case 3 -> MenuCustomer.customerMenu(input);
            case 4 -> MenuExit.exitMenu(input);
            default -> System.out.println("Please Choose a correct number: ");
        }
    }
}
