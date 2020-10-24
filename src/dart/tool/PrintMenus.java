package dart.tool;

/**
 * This class is for printing all menu's similarly:
 */

public class PrintMenus {

    public PrintMenus(String title, String[] subMenus, String inputPrompt, String line) {
        printMenuItems(title, subMenus, inputPrompt, line);
    }

    public void printMenuItems(String title, String[] subMenus, String inputPrompt, String line) {
        if (line.equalsIgnoreCase("yes")) {
            System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
        }
        System.out.println(title);

        // This loop prints out all the menu options that are stored in the "menuItems" array.
        for (int i = 0; i < subMenus.length; i++) {
            System.out.println((i + 1) + ". " + subMenus[i]);
        }
        System.out.println("");
        System.out.print(inputPrompt);
    }
}
