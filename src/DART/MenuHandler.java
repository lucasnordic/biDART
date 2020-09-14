package DART;

import java.util.Scanner;

public class MenuHandler {

    public static int chooseFromMenu(Scanner input, String[] menuItems, String prompt) {
        System.out.println( prompt );

        for (int i = 0; i < menuItems.length; i++) {                //0 7 = 8
            System.out.println((i + 1) + ". " + menuItems[i]);
        }

        return InputHandler.inputInt(input, "Enter choice: ", 1, menuItems.length);
        //     Class        Method  (                                            );
    }
}
