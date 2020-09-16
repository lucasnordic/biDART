package DART;

import java.util.Scanner;

//  This class will handle printing out menu's
public class HandlePrinting {

    // this method will print out any menu and then it will send the possible choices to the InputHandler.
    public static int chooseFromMenu(Scanner input, String[] menuItems, String title, String inputPrompt) {

        //  This prints out empty spaces to "clear the screen".
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");

        //  This prints the menu "title"
        System.out.println( title );

        //  This loop prints out all the menu options that are stored in the "menuItems" array.
        for (int i = 0; i < menuItems.length; i++) {                //0 7 = 8
            System.out.println((i + 1) + ". " + menuItems[i]);
        }

        //  Prints an empty row
        System.out.println("");

        //  This prints the text before the user input. For example, "Enter choice: "
        System.out.print(inputPrompt);

        // Here is where we send everything to the InputHandler class:
        // it will send "1", since that will be the lowest menu option choice
        // it will send the "menuItems.length", since that will be the maximum option the user can choose.
        return HandleInput.inputInt(input, 1, menuItems.length);
    }
/*


 */
}

