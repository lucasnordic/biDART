package DART;

import java.util.Scanner;

public class MenuHandler {

    public static int chooseFromMenu(Scanner input, String[] menuItems, String prompt, String inputPrompt) {
        System.out.println( prompt );

        for (int i = 0; i < menuItems.length; i++) {                //0 7 = 8
            System.out.println((i + 1) + ". " + menuItems[i]);
        }

        System.out.println(inputPrompt);

        return InputHandler.inputInt(input, 1, menuItems.length);
        //     Class        Method  (                                            );
    }
}
