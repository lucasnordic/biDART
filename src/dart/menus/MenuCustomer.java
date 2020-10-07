package dart.menus;

import dart.InputOutput;

public class MenuCustomer {
    //  This method handles the customer menu contents:
    public void customerMenu() {
        System.out.println("- - - - - - - - - - - - - - - - -");
        System.out.println("Customer Screen - Type one of the options below:");
        String[] menuItems = {
                "Rent a game",
                "Return a game",
                "Change Membership",
                "Return to Main Menu"
        };
        InputOutput.printMenuItems(menuItems);
        System.out.println("Enter choice: ");

        //  Here we store the max and min choice based on "menuItems":
        int minMenuChoice = 1;
        int maxMenuChoice = menuItems.length;
        int menuChoice = InputOutput.inputIntMinMax(minMenuChoice, maxMenuChoice);  // Goes into the MenuHandler class. MenuHandler prints the "prompt" and "mainMenuItems"

        // Here we go to different menus based on user input.
        switch (menuChoice) {
            case 1 -> rentAGame();
            case 2 -> returnAGame();
            case 3 -> menuChangeMembership();
            case 4 -> mainMenu();
        }
    }

    public void menuChangeMembership() {
        
    }
}
