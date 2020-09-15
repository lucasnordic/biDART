// https://www.youtube.com/watch?v=MoXxF3aWW8k&ab_channel=IntelliJIDEAbyJetBrains
// Learn how to GitHub.

package DART;

import DART.MenuItems.MainMenu;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        // Creates a scanner that is used throughout the program
        // So wherever the name "input" comes up. That means I am
        // sending the scanner along the program.
        //maybe there is a better way of doing this. Perhaps opening and closing the scanner in every class?
        Scanner input = new Scanner(System.in);

        // Program goes directly into the mainMenu method. The method needs the scanner(input). We can turn this into a class.
        MainMenu.mainMenu(input);

    }

    //  This could go into EmployeeMenu class instead.
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