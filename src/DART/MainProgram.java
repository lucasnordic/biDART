package DART;

import java.util.Scanner;

public class MainProgram {                                                      // Main Program

    public static void main(String[] args) {
        DART.Utilities.DartUtilities.clearConsole();                            // Clear screen...
        Scanner input = new Scanner(System.in);                                 // Creates a scanner that is used throughout the program

        mainMenu(input);                                                        // Program goes directly into the mainMenu method. The method needs the scanner(input). We can turn this into a class.
        input.close();                                                          // When the program is done the Scanner input is closed.
    }

    public static void mainMenu(Scanner input) {

        DART.Utilities.DartUtilities.clearConsole();                            // Clear screen...

        String prompt = "Main Menu: \nWelcome to DART,\n" +                     // This is being sent into the MenuHandler Class later.
                "your good old game rental system. The competition has no steam to keep up ;)\n\n" +
                "Please specify your role by entering one of the options given:";
        String[] mainMenuItems = {                                              // This is being sent into the MenuHandler Class later.
                "Go to Manager menu",
                "Go to Employee menu",
                "Go to Customer menu",
                "Exit system",
        };

        int choice = MenuHandler.chooseFromMenu(input, mainMenuItems, prompt);  // Goes into the MenuHandler class. MenuHandler prints the "prompt" and "mainMenuItems"
                                                                                // This should be handled in "InputHandler".
        switch (choice) {                                                       // choice has become the length of "String[] mainMenuItems".
            case 1 -> managerMenu();                                            // If user inputs 1 then we go to managerMenu method
            case 2 -> employeeMenu();
            case 3 -> customerMenu();
            case 4 -> exitMenu();
            default -> System.out.println("Please Choose a correct number: ");
        }
    }

    public static void managerMenu () {  // Manager menu
        DART.Utilities.DartUtilities.clearConsole();
        System.out.println("Manager Screen - Type one of the options below:\n" +
                "1. Add an employee\n" +
                "2. View all employees\n" +
                "3. Return to Main Menu\n");
    }
    public static void employeeMenu () { // Employee menu
        DART.Utilities.DartUtilities.clearConsole();
        System.out.print("Employee Screen - Type one of the options below:\n" +
                "1. Register a game\n" +
                "2. Remove a game\n" +
                "3. Register a customer\n" +
                "4. Remove a customer\n" +
                "5. Show total rent profit\n" +
                "6. View all games\n" +
                "7. Return to Main Menu\n" +
                "Enter choice: ");
    }
    public static void customerMenu () { // Customer menu
        DART.Utilities.DartUtilities.clearConsole();
        System.out.print("Customer Screen - Type one of the options below:\n" +
                "1. Rent a game\n" +
                "2. Return a game\n" +
                "3. Return to Main Menu\n" +
                "Enter choice: ");
    }
    public static void exitMenu () {
        System.out.println("\nRIP");
    }
}

// https://www.youtube.com/watch?v=MoXxF3aWW8k&ab_channel=IntelliJIDEAbyJetBrains
// Learn how to GitHub.















//  Redundant code:
/*
    public static String mainMenu(Scanner input) {
        DART.Utilities.DartUtilities.clearConsole();    // Clear screen



        System.out.print("Main Menu: \nWelcome to DART," +
                " your good old game rental system. The competition has no steam to keep up ;)" + "\n" +
                "Please specify your role by entering one of the options given:\n\n" +
                "1. Go to Manager menu\n" +
                "2. Go to Employee menu\n" +
                "3. Go to Customer menu\n" +
                "4. Exit system\n" +
                "Enter choice: ");

        chosenMenu = input.nextInt();
        input.nextLine();

        while (chosenMenu >= 0 || chosenMenu <= 4) {
            switch (chosenMenu) {
                case 1:
                    chosenMenu = managerMenu(input);
                    break;
                case 2:
                    chosenMenu = employeeMenu(input);
                    break;
                case 3:
                    chosenMenu = customerMenu(input);
                    break;
                case 4:
                    chosenMenu = exitMenu(input);
                    break;
                default:
                    System.out.println("Please Choose a correct number: ");
                    break;
            }
        }



        if ( ChosenRoleMenu.equalsIgnoreCase("M")) {
            currentMenu = managerMenu(input);
        } else if ( ChosenRoleMenu.equalsIgnoreCase("E")) {
            currentMenu = employeeMenu(input);
        } else if ( ChosenRoleMenu.equalsIgnoreCase("C")) {
            currentMenu = customerMenu(input);
        } else if (ChosenRoleMenu.equalsIgnoreCase("X")) {
            currentMenu = exitMenu(input);
        }
        return currentMenu;
    }
         */