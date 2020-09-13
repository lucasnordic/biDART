/*  / old main menu

 */

package DART; // "viDeo gAme Rental sysTem"

import java.io.IOException;
import java.util.Scanner;

public class mainProgram {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String roleChoice = "";
        String currentMenu = "MM";
        String menuMessage = mainMenu( input, currentMenu );
    }

    public static String mainMenu(Scanner input, String currentMenu) {

        DartUtilities.clearConsole();
        System.out.println("Main Menu: \nWelcome to DART," +
                " your good old game rental system. The competition has no steam to keep up" + "\n" +
                "Please specify your role by entering one of the options given:\n\n" +
                "1. Enter “M” for Manager\n" +
                "2. Enter “E” for Employee\n" +
                "3. Enter “C” for Customer\n" +
                "4. Enter “X” to exit system");
        String chosenRole = input.nextLine();
        if ( chosenRole.equalsIgnoreCase("M")) {
            currentMenu = managerMenu(input, chosenRole);
        } else if ( chosenRole.equalsIgnoreCase("E")) {
            currentMenu = employeeMenu(input, chosenRole);
        } else if ( chosenRole.equalsIgnoreCase("C")) {
            currentMenu = customerMenu(input, chosenRole);
        } else if (chosenRole.equalsIgnoreCase("X")) {
            currentMenu = exitMenu(input, chosenRole);
        }
        return currentMenu;
    }

    public static String managerMenu (Scanner Input, String currentMenu) {
        DartUtilities.clearConsole();
        System.out.println("Manager Screen - Type one of the options below:\n" +
                "1. Add an employee\n" +
                "2. View all employees\n" +
                "3. Return to Main Menu\n");
        return "";
    }
    public static String employeeMenu (Scanner Input, String choosenRole) {
        System.out.println("Employee Screen - Type one of the options below:\n" +
                "1. Register a game\n" +
                "2. Remove a game\n" +
                "3. Register a customer\n" +
                "4. Remove a customer\n" +
                "5. Show total rent profit\n" +
                "6. View all games\n" +
                "7. Return to Main Menu\n");
        return "";
    }
    public static String customerMenu (Scanner Input, String choosenRole) {

        System.out.println("Customer Screen - Type one of the options below:\n" +
                "1. Rent a game\n" +
                "2. Return a game\n" +
                "3. Return to Main Menu\n");
        return "";
    }
    public static String exitMenu (Scanner Input, String choosenRole) {
        System.out.println("RIP");
        return "";
    }
}

class DartUtilities {
    public static void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }
}

class Menu {

}

class MenuItem {
    String label = "";
}

// https://www.youtube.com/watch?v=MoXxF3aWW8k&ab_channel=IntelliJIDEAbyJetBrains
// YEAH


/*
User Story 1.1 - Main Menu
As a user I want to access different functions of my system to add, remove or edit different items or users.
Your first task is to create a menu for the different users of your software, which are store Manager, store Employee and Customer. This menu is the entry point of your system and enables the user to (i) register new types of users (Manager, Employee or Customer), or (ii) register new games or items DART.

Upon starting your system, the following messages should be shown:

Main Menu:
Welcome to DART, your good old game rental system. The competition has no steam to keep up!

Please specify your role by entering one of the options given:
1. Enter “M” for Manager
2. Enter “E” for Employee
3. Enter “C” for Customer
4. Enter “X” to exit system

// main menu method. Where we choose our role.
//

 */