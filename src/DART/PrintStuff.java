package DART;

//  This class will handle printing
public class PrintStuff {

    // this method will print out any menu
    public static void printMenuItems(String title, String[] menuItems, String inputPrompt) {

        System.out.println( title );

        for (int i = 0; i < menuItems.length; i++) {    // This loop prints out all the menu options that are stored in the "menuItems" array.
            System.out.println((i + 1) + ". " + menuItems[i]);
        }
        System.out.println(" ");
        System.out.print(inputPrompt);  // This prints the text before the user input. For example, "Enter choice: "
    }
}

