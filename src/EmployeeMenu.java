
import DART.MenuHandler;
import DART.MenuItems.MainMenu;

import java.util.Scanner;

public class EmployeeMenu {

    public static void employeeMenu (Scanner input) { // Employee menu
        String password = "";
        System.out.println("Insert password:");
        password = input.nextLine();

        if (password.equals("password123")) {
            String prompt = "Employee Screen - Type one of the options below:";

            String[] employeeMenuItems = {
                    "Register a game",
                    "Remove a game",
                    "Register a customer",
                    "Remove a customer",
                    "Show total rent profit",
                    "View all games",
                    "Return to Main Menu",
            };
            String inputPrompt = "";

            int choice = MenuHandler.chooseFromMenu(input, employeeMenuItems, prompt, inputPrompt);  // Goes into the MenuHandler class. MenuHandler prints the "prompt" and "mainMenuItems"
            // This should be handled in "InputHandler".
            switch (choice) {                                                       // choice has become the length of "String[] mainMenuItems".
                case 7 -> MainMenu.mainMenu(input);                                            // If user inputs 1 then we go to managerMenu method
                default -> System.out.println("Please Choose a correct number: ");
            }
        } else {
            System.out.println("INVALID PASSWORD");
            MainMenu.mainMenu(input);
        }
    }

}
